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
import com.aldebaran.qi.helper.proxies.ALSoundLocalization;

/**
 * This example shows how the robot can detect sounds by subscribing to the
 * ALSoundLocalization/SoundLocated event. The robot's head will turn towards
 * the direction of the detected sound. When touching the middle tactile head
 * sensor, the application will stop. Note that when Basic Awareness is started
 * and sound detection is enabled, the robot will also track the detected sounds
 * with its head.
 */
public class ExReactToSound {

    private static Application application;

    private static ALMemory alMemory;
    private static ALSoundLocalization sound;
    private static ALMotion motion;

    public static void main(String[] args) {

        application = new Application(args, RobotInfo.URL);
        try {
            application.start();
            alMemory = new ALMemory(application.session());
            sound = new ALSoundLocalization(application.session());
            motion = new ALMotion(application.session());
            motion.wakeUp();
            sound.subscribe("demo");
            alMemory.subscribeToEvent("ALSoundLocalization/SoundLocated",
                    new EventCallback<ArrayList<?>>() {
                        ArrayList<Float> torsoCoord;
                        ArrayList<Float> soundParam;
                        float azimuth;
                        float elevation;
                        float confidence;

                        @SuppressWarnings("unchecked")
                        @Override
                        public void onEvent(ArrayList<?> sound)
                                throws InterruptedException, CallError {

                            if (sound != null && sound.size() >= 3) {
                                soundParam = (ArrayList<Float>) sound.get(1);
                                // torsoCoord is a 6 dimensional vector
                                // containing [x, y, z, Wx,
                                // Wy, Wz], where Wx is the rotation around X
                                // axis, etc.
                                torsoCoord = (ArrayList<Float>) sound.get(2);
                                System.out.println("" + torsoCoord);

                                if (soundParam.size() >= 4) {
                                    azimuth = soundParam.get(0)
                                            + torsoCoord.get(5);
                                    elevation = soundParam.get(1)
                                            + torsoCoord.get(4);

                                    confidence = soundParam.get(3);
                                    System.out.println(" Level: "
                                            + soundParam.get(3) + "isMoving "
                                            + motion.moveIsActive());

                                    if (confidence > 0.3) {
                                        // limitate neck movement.
                                        if (azimuth > 1.0)
                                            azimuth = 1.0f;
                                        else if (azimuth < -1.0)
                                            azimuth = -1.0f;
                                        System.out.println("azimuth " + azimuth
                                                + " elevation " + elevation);
                                        List<String> names = new ArrayList<String>();
                                        names.add("HeadYaw");
                                        names.add("HeadPitch");
                                        List<Float> angles = new ArrayList<Float>();
                                        angles.add(azimuth);
                                        angles.add(elevation);
                                        motion.setAngles(names, angles, 0.3f);
                                    }
                                }
                            }
                        }
                    });

            alMemory.subscribeToEvent("MiddleTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                sound.unsubscribe("demo");
                                motion.rest();
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
