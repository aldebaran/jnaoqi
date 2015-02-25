/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 25/09/2014.
 */

package com.aldebaran.demo;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALBasicAwareness;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * Works only on real robot. This example shows how ALBasicAwareness works, how
 * it can be started and stopped. When started, the robot is able to detect and
 * track sound, movement, people and sensor touch. For this example, use the
 * front tactile head sensor to start basic awareness and the rear tactile head
 * sensor to stop it. Each time the robot tracks a human, it will assign him an
 * id.
 */

public class ExBasicAwareness {

    private static ALMemory alMemory;
    private static Application application;
    private static ALBasicAwareness awareness;
    private static ALTextToSpeech tts;
    private static ALMotion motion;

    public static void main(String[] args) {

        application = new Application(args, RobotInfo.URL);
        try {
            application.start();

            alMemory = new ALMemory(application.session());
            awareness = new ALBasicAwareness(application.session());
            tts = new ALTextToSpeech(application.session());
            motion = new ALMotion(application.session());

            tts.say("Launching Basic Awareness demo.");
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
                                System.out.println("Stopping Basic Awareness");
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
                                System.out.println("Starting Basic Awareness");
                                awareness.startAwareness();
                            }
                        }
                    });
            alMemory.subscribeToEvent("ALBasicAwareness/HumanTracked",
                    new EventCallback<Integer>() {

                        @Override
                        public void onEvent(Integer humanId)
                                throws InterruptedException, CallError {
                            if (humanId > 0) {
                                tts.say("I see " + humanId);
                            }

                        }
                    });
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
