/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 11/05/2014.
 */

package com.aldebaran.demo;

import java.util.ArrayList;
import java.util.List;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * This example shows how the robot can obey to voice commands: 'wake up',
 * 'come' and 'stop'. The application will be stopped when touching the middle
 * tactile head sensor.
 */
public class ExReactToVoice {

    private static boolean isAwake = false;
    private static Application application;

    private static ALMemory alMemory;
    private static ALMotion motion;
    private static ALSpeechRecognition alSpeechRecognition;
    private static ALTextToSpeech tts;
    private static String APP_NAME = "DemoVoiceReaction";

    public static void main(String[] args) {

        application = new Application(args, RobotInfo.URL);

        try {
            application.start();

            alMemory = new ALMemory(application.session());
            motion = new ALMotion(application.session());
            alSpeechRecognition = new ALSpeechRecognition(application.session());
            tts = new ALTextToSpeech(application.session());

            ArrayList<String> listOfWords = new ArrayList<String>();
            listOfWords.add("wake up");
            listOfWords.add("come");
            listOfWords.add("stop");

            alSpeechRecognition.setVocabulary(listOfWords, false);

            alSpeechRecognition.subscribe(APP_NAME);
            alMemory.subscribeToEvent("WordRecognized",
                    new EventCallback<List<Object>>() {

                        @Override
                        public void onEvent(List<Object> words)
                                throws InterruptedException, CallError {
                            String word = (String) words.get(0);
                            System.out.println("Word " + word);

                            if (word.equals("wake") && !isAwake) {
                                tts.say("hi");
                                alSpeechRecognition.pause(true);
                                motion.wakeUp();
                                alSpeechRecognition.pause(false);
                                isAwake = true;
                            } else if (word.equals("come") && isAwake) {
                                motion.moveToward(0.6f, 0f, 0f);
                            } else if (word.equals("stop") && isAwake) {
                                motion.moveToward(0f, 0f, 0f);
                            }
                        }
                    });
            alMemory.subscribeToEvent("MiddleTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                tts.say("Application is stopping");
                                motion.rest();
                                alSpeechRecognition.unsubscribe(APP_NAME);
                                application.stop();

                            }
                        }
                    });
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
