/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 26/09/2014.
 */
package com.aldebaran.demo;

import java.util.ArrayList;
import java.util.List;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALAnimatedSpeech;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;
import com.aldebaran.qi.helper.proxies.ALBasicAwareness;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * This example shows a simple demo scenario where 6 states are declared: ->
 * Start-up: Robot waits for its middle head sensor to be touched. -> Wake-up:
 * Robot wakes up, starts basic awareness and waits to see someone. -> Moving
 * around: Robot listens for instructions to move ('left', 'right', 'forward',
 * 'faster', 'slower', 'faster') or 'next' to go to next state. -> Jokes: Robot
 * tells a joke and waits for an answer. -> Laugh: Robot laughs of its joke. ->
 * End: Application is stopped. Robot comes back to rest.
 * 
 */
public class ExScenar1 {

    private static final int STEP_STARTUP = 0;
    private static final int STEP_WAKE_UP = 1;
    private static final int STEP_MOVING_AROUND = 2;
    private static final int STEP_JOKES = 3;
    private static final int STEP_LAUGH = 4;
    private static final int STEP_END = 10;

    private static String APP_NAME = "scenar1_1";

    private static int currentStep = 0;

    private static float x = 0f;
    private static float y = 0f;
    private static float teta = 0f;

    private static ALBasicAwareness awareness;
    private static ALSpeechRecognition alSpeechRecognition;
    private static ALAnimatedSpeech alAnimatedSpeech;
    private static ALAudioPlayer alAudioPlayer;
    private static Application application;
    private static ALMemory alMemory;
    private static ALTextToSpeech tts;
    private static ALMotion motion;
    private static int next_step = STEP_MOVING_AROUND;
    private static long subscriberId;

    public static void main(String[] args) {
        APP_NAME += System.currentTimeMillis();
        // Connect to the robot
        application = new Application(args, RobotInfo.URL);

        try {
            System.out.printf("Connect to " + RobotInfo.PORT);
            application.start();
            tts = new ALTextToSpeech(application.session());
            alMemory = new ALMemory(application.session());
            motion = new ALMotion(application.session());
            alAnimatedSpeech = new ALAnimatedSpeech(application.session());
            awareness = new ALBasicAwareness(application.session());
            alSpeechRecognition = new ALSpeechRecognition(application.session());
            alAudioPlayer = new ALAudioPlayer(application.session());

            alMemory.subscribeToEvent("RearTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float value)
                                throws InterruptedException, CallError {
                            System.out.println(APP_NAME + " : Touch " + value);
                            if (value == 1.0) {
                                stateMachine(STEP_END);
                            }
                        }
                    });
            stateMachine(STEP_STARTUP);
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stateMachine(int step) {
        currentStep = step;
        System.out.println("STEP : " + step);
        try {
            switch (currentStep) {

            // At Startup
            case STEP_STARTUP:
                // Create a proxy to listen for head touch events
                alMemory.subscribeToEvent("MiddleTactilTouched",
                        new EventCallback<Float>() {

                            @Override
                            public void onEvent(Float value)
                                    throws InterruptedException, CallError {
                                System.out.println(APP_NAME + " : Touch "
                                        + value);
                                if (value == 1.0) {
                                    switch (currentStep) {
                                    case STEP_STARTUP:
                                        stateMachine(STEP_WAKE_UP);
                                        break;
                                    }
                                }
                            }
                        });
                tts.say("Touch my head to start!");
                break;

            // On touch
            case STEP_WAKE_UP:
                // Wake the robot up
                motion.wakeUp();

                // Configure robot's awareness
                awareness.setEngagementMode("SemiEngaged");
                awareness.setTrackingMode("Head");
                awareness.setStimulusDetectionEnabled("Sound", true);
                awareness.setStimulusDetectionEnabled("Movement", true);
                awareness.setStimulusDetectionEnabled("People", true);
                awareness.setStimulusDetectionEnabled("Touch", true);

                alMemory.subscribeToEvent("ALBasicAwareness/HumanTracked",
                        new EventCallback<Integer>() {

                            @Override
                            public void onEvent(Integer humanId)
                                    throws InterruptedException, CallError {
                                if (humanId >= 0) {
                                    switch (currentStep) {
                                    case STEP_WAKE_UP:
                                        stateMachine(next_step);
                                        break;
                                    }
                                }
                            }
                        });
                awareness.startAwareness();
                // Now we wait for the robot to somebody
                break;

            // When seeing someone
            case STEP_MOVING_AROUND:
                // Ask the human where to go
                awareness.stopAwareness();
                alAnimatedSpeech.setBodyLanguageModeFromStr("disabled");
                tts.say("Where do you want me to go ?");

                // List of words that the robot will recognize
                ArrayList<String> words1 = new ArrayList<String>();
                words1.add("forward");
                words1.add("left");
                words1.add("right");
                words1.add("stop");
                words1.add("faster");
                words1.add("slower");
                words1.add("next");

                alSpeechRecognition.setVocabulary(words1, false);
                alSpeechRecognition.subscribe(APP_NAME);
                subscriberId = alMemory.subscribeToEvent("WordRecognized",
                        new EventCallback<List<Object>>() {

                            @Override
                            public void onEvent(List<Object> words)
                                    throws InterruptedException, CallError {
                                alSpeechRecognition.pause(true);

                                String word = (String) words.get(0);
                                System.out.println("Word " + word);

                                if (word.equals("next")) {
                                    x = 0;
                                    y = 0;
                                    teta = 0;
                                    // motion.moveToward(x, y, teta);
                                    motion.stopMove();
                                    Thread.sleep(3000);
                                    alMemory.unsubscribeToEvent(subscriberId);
                                    alSpeechRecognition.unsubscribe(APP_NAME);
                                    stateMachine(STEP_JOKES);

                                } else {
                                    if (word.equals("forward")) {
                                        x = 0.6f;
                                    } else if (word.equals("left")) {
                                        teta = 0.4f;
                                    } else if (word.equals("right")) {
                                        teta = -0.4f;
                                    } else if (word.equals("stop")) {
                                        x = 0f;
                                        y = 0f;
                                        teta = 0f;
                                    } else if (word.equals("faster")) {
                                        if (x > 0)
                                            x += 0.2;
                                        else
                                            x -= 0.2;
                                    } else if (word.equals("slower")) {
                                        if (x < 0)
                                            x += 0.2;
                                        else
                                            x -= 0.2;
                                    }

                                    motion.moveToward(x, y, teta);
                                    Thread.sleep(3000);
                                    tts.say("What now ?");
                                    alSpeechRecognition.pause(false);
                                }
                            }
                        });
                break;

            // At the end motions
            case STEP_JOKES:
                tts.say("What is a witch in a desert ? ");

                ArrayList<String> words2 = new ArrayList<String>();
                words2.add("I don't know");
                words2.add("a sandwich");

                alSpeechRecognition.setVocabulary(words2, false);
                alSpeechRecognition.subscribe(APP_NAME);
                alMemory.subscribeToEvent("LastWordRecognized",
                        new EventCallback<List<Object>>() {

                            @Override
                            public void onEvent(List<Object> words)
                                    throws InterruptedException, CallError {
                                alSpeechRecognition.pause(true);
                                String word = (String) words.get(0);
                                System.out.println("Word " + word);
                                if (word.equals("sandwich")
                                        || word.equals("a sandwich")) {
                                    alAnimatedSpeech
                                            .say("^start(animations/Stand/Emotions/Positive/Winner_1) Yeah you win !! ^wait(animations/Stand/Emotions/Positive/Winner_1)");
                                } else {
                                    alAnimatedSpeech
                                            .say("^start(animations/Stand/Emotions/Negative/Angry_4) A sandwich !! ^wait(animations/Stand/Emotions/Negative/Angry_4)");
                                }
                                alSpeechRecognition.unsubscribe(APP_NAME);
                                stateMachine(STEP_LAUGH);
                            }
                        });
                break;

            case STEP_LAUGH:
                try {
                    alAudioPlayer.playSoundSetFile("Aldebaran",
                            "enu_ono_laugh_expressive_01");
                } catch (Exception e) {
                    System.err
                            .println("Couldn't play sound from Aldebaran Soundset.");
                }
                stateMachine(STEP_END);
            case STEP_END:
                tts.say("I'm stopping now.");
                awareness.stopAwareness();

                motion.rest();

                application.stop();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
