/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 25/09/2014.
 */

package com.aldebaran.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALBasicAwareness;
import com.aldebaran.qi.helper.proxies.ALFaceCharacteristics;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * Works only on a real robot. This example shows how the robot is capable of
 * detecting a smile on the tracked person's face. Touch the front tactile head
 * sensor to start tracking people. Touch the rear tactile head sensor to stop
 * tracking people.
 */
public class ExSmileDetector {

    private static ALMemory alMemory;
    private static Application application;
    private static ALBasicAwareness awareness;
    private static ALFaceCharacteristics faceCharac;
    private static ALTextToSpeech tts;
    private static ALMotion motion;
    private static DetectEmotion routine;

    public static void main(String[] args) {
        String robotUrl = "tcp://" + RobotInfo.IP + ":" + RobotInfo.PORT;
        application = new Application(args, robotUrl);

        try {
            application.start();

            alMemory = new ALMemory(application.session());
            awareness = new ALBasicAwareness(application.session());
            tts = new ALTextToSpeech(application.session());
            motion = new ALMotion(application.session());
            faceCharac = new ALFaceCharacteristics(application.session());

            tts.say("hello");
            motion.wakeUp();
            awareness.setEngagementMode("SemiEngaged");
            awareness.setTrackingMode("Head");
            awareness.setStimulusDetectionEnabled("Sound", true);
            awareness.setStimulusDetectionEnabled("Movement", true);
            awareness.setStimulusDetectionEnabled("People", true);
            awareness.setStimulusDetectionEnabled("Touch", true);

            alMemory.subscribeToEvent("RearTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                System.out.println("Stopping basic awareness");
                                if (routine.isRunning)
                                    routine.interrupt();
                                awareness.stopAwareness();
                            }
                        }
                    });
            alMemory.subscribeToEvent("FrontTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                System.out.println("Starting basic awareness");
                                awareness.startAwareness();
                            }
                        }
                    });

            alMemory.subscribeToEvent("ALBasicAwareness/HumanTracked",
                    new EventCallback<Integer>() {

                        int trackedHuman = -1;

                        @Override
                        public void onEvent(Integer humanId)
                                throws InterruptedException, CallError {
                            if (trackedHuman != humanId) {
                                trackedHuman = humanId;
                                System.out.println("humanId " + humanId);
                                if (routine != null && routine.isRunning)
                                    routine.interrupt();
                                if (humanId > 0) {
                                    routine = new DetectEmotion(faceCharac,
                                            alMemory, tts);
                                    routine.start();
                                } else {
                                    tts.say("I don't see anybody.");
                                }
                            }
                        }
                    });

            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DetectEmotion extends Thread {
    boolean isRunning;
    ALFaceCharacteristics faceCharac;
    ALMemory alMemory;
    ALTextToSpeech tts;

    DetectEmotion(ALFaceCharacteristics faceCharac, ALMemory alMemory,
            ALTextToSpeech tts) {
        this.faceCharac = faceCharac;
        this.alMemory = alMemory;
        this.tts = tts;
    }

    @Override
    public void run() {
        try {
            isRunning = true;
            detectEmotion();
        } catch (InterruptedException e) {
            return;
        } catch (CallError e) {
            e.printStackTrace();
            return;
        }

    }

    private void detectEmotion() throws InterruptedException, CallError {

        float neutralEmotion = 0.5f;
        float threshHappyEmotion = 0.35f;
        float threshSurprisedEmotion = 0.45f;
        float threshAngryEmotion = 0.7f;
        float threshSadEmotion = 0.55f;

        float[] tabProperties = new float[5];
        int counter = 0;
        while (isRunning) {
            if (counter < 3) {
                @SuppressWarnings("unchecked")
                ArrayList<Integer> ids = (ArrayList<Integer>) alMemory
                        .getData("PeoplePerception/PeopleList");
                if (ids.size() > 0) {

                    faceCharac.analyzeFaceCharacteristics(ids.get(0));
                    Thread.sleep(400);
                    try {
                        @SuppressWarnings("unchecked")
                        ArrayList<Float> properties = (ArrayList<Float>) alMemory
                                .getData("PeoplePerception/Person/"
                                        + ids.get(0) + "/ExpressionProperties");
                        tabProperties[0] += properties.get(0);
                        tabProperties[1] += properties.get(1);
                        tabProperties[2] += properties.get(2);
                        tabProperties[3] += properties.get(3);
                        tabProperties[4] += properties.get(4);
                        counter += 1;
                    } catch (CallError e) {
                        System.err
                                .println("Couldn't get face characteristics for "
                                        + ids.get(0));
                    }
                }

            } else {
                tabProperties[0] /= 3;
                tabProperties[1] /= 3;
                tabProperties[2] /= 3;
                tabProperties[3] /= 3;
                tabProperties[4] /= 3;

                List<Float> percentage = new ArrayList<Float>();

                percentage.add(tabProperties[0] - neutralEmotion);
                percentage.add(tabProperties[1] - threshHappyEmotion);
                percentage.add(tabProperties[2] - threshSurprisedEmotion);
                percentage.add(tabProperties[3] - threshAngryEmotion);
                percentage.add(tabProperties[4] - threshSadEmotion);

                int i;
                for (i = 0; i < 5; i++) {
                    if (percentage.get(i).equals(Collections.max(percentage))) {
                        break;
                    }
                }
                switch (i) {
                case 1:
                    tts.say("You are smiling ");
                    break;
                case 2:
                    tts.say("You are surprised ");
                    break;
                case 3:
                    tts.say("You are angry ");
                    break;
                case 4:
                    tts.say("You are sad ");
                    break;
                }
                counter = 0;

            }
        }
    }
}
