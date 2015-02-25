/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 25/09/2014.
 */

package com.aldebaran.demo;

import java.util.ArrayList;
import java.util.Arrays;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * This example shows how to make the robot move by using the ALMotion API. When
 * touching the front tactile head sensor, a list of angles will be set to make
 * the arms move. When touching the rear tactile head sensor, the robot will go
 * to a rest position.
 */
public class ExMotion {

    public static ArrayList<Float> LARM_STRETCHED;
    public static ArrayList<Float> LARM_UP;
    public static ArrayList<Float> LARM_FRONT;
    public static ArrayList<Float> LARM_HIP;

    public static ArrayList<Float> RARM_STRETCHED;
    public static ArrayList<Float> RARM_UP;
    public static ArrayList<Float> RARM_FRONT;
    public static ArrayList<Float> RARM_HIP;

    private static ALMemory alMemory;
    private static ALTextToSpeech tts;
    private static ALMotion motion;
    private static Application application;

    public static void main(String[] args) {
        Float[] Lstretched = { 0.2111847996711731f, 1.3107420206069946f,
                -1.284562587738037f, -0.03490659222006798f,
                -1.8238688707351685f, 0.5400000214576721f };
        Float[] Lup = { -1.4800336360931396f, 0.08084873855113983f,
                0.44161051511764526f, -0.03490658476948738f,
                -1.787217378616333f, 0.5400000214576721f };
        Float[] Lfront = { 2.802596928649634e-45f, -0.174532949924469f,
                2.00189208984375f, -0.03490659222006798f, -1.787217378616333f,
                0.5400000214576721f };
        Float[] Lhip = { 1.1889886856079102f, 0.7981850504875183f,
                0.3110186457633972f, -1.230137586593628f, -1.787217378616333f,
                0.0f };

        Float[] Rstretched = { 0.15184366703f, -1.31074202061f, 1.20078623295f,
                0.076794475317f, 1.82386887074f, 0.589999973774f };
        Float[] Rup = { -1.6335183382f, -0.00976557750255f, -0.232178241014f,
                0.0730158835649f, 1.82386887074f, 0.0f };
        Float[] Rfront = { -0.0907571017742f, 0.0209439471364f,
                -1.70693230629f, 0.076794475317f, 1.82386887074f, 0.0f };
        Float[] Rhip = { 1.51965844631f, -0.880720674992f, 0.0393116399646f,
                1.50638234615f, 1.82386887074f, 0.0f };

        LARM_STRETCHED = new ArrayList<Float>(Arrays.asList(Lstretched));
        LARM_UP = new ArrayList<Float>(Arrays.asList(Lup));
        LARM_FRONT = new ArrayList<Float>(Arrays.asList(Lfront));
        LARM_HIP = new ArrayList<Float>(Arrays.asList(Lhip));

        RARM_STRETCHED = new ArrayList<Float>(Arrays.asList(Rstretched));
        RARM_UP = new ArrayList<Float>(Arrays.asList(Rup));
        RARM_FRONT = new ArrayList<Float>(Arrays.asList(Rfront));
        RARM_HIP = new ArrayList<Float>(Arrays.asList(Rhip));

        final ArrayList<ArrayList<Float>> movesL = new ArrayList<ArrayList<Float>>();
        movesL.add(LARM_HIP);
        movesL.add(LARM_STRETCHED);
        movesL.add(LARM_HIP);
        movesL.add(LARM_STRETCHED);
        final ArrayList<ArrayList<Float>> movesR = new ArrayList<ArrayList<Float>>();
        movesR.add(RARM_HIP);
        movesR.add(RARM_STRETCHED);
        movesR.add(RARM_HIP);
        movesR.add(RARM_STRETCHED);
        final float speed = 0.5f;

        application = new Application(args, RobotInfo.URL);
        try {
            application.start();
            alMemory = new ALMemory(application.session());
            tts = new ALTextToSpeech(application.session());
            motion = new ALMotion(application.session());

            alMemory.subscribeToEvent("FrontTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                tts.say("Let's go!");
                                motion.wakeUp();
                                ArrayList<Float> destL = movesL.get(0);
                                ArrayList<Float> destR = movesR.get(0);
                                for (int i = 1; i < movesL.size(); i++) {
                                    motion.setAngles("LArm", destL, speed);
                                    motion.setAngles("RArm", destR, speed);
                                    Thread.sleep(50);
                                    float dist = measureDistance("LArm", destR);
                                    if (dist < 0.1) {
                                        destL = movesL.get(i);
                                        destR = movesR.get(i);
                                    }
                                }
                            }
                        }
                    });

            alMemory.subscribeToEvent("RearTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                tts.say("Done. Going to rest.");
                                motion.rest();
                            }
                        }
                    });
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static float measureDistance(String joint, ArrayList<Float> desired) {
        float distanceSum = 0.0f;
        try {
            ArrayList<Float> angles = (ArrayList<Float>) motion.getAngles(
                    joint, true);
            if ((desired.size() <= 0) || (desired.size() != angles.size())) {
                return 0f; // Could print a warning too, or even assert
            }
            for (int i = 0; i < angles.size(); i++) {
                distanceSum += Math.abs(desired.get(i) - angles.get(i));
            }
            return distanceSum / desired.size();
        } catch (CallError callError) {
            callError.printStackTrace();
            return 0f;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0f;
        }
    }

}
