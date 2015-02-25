/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 12/05/2014.
 */
package com.aldebaran.demo;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import com.aldebaran.demo.picture.Picture;
import com.aldebaran.demo.picture.ShowPicture;
import com.aldebaran.demo.picture.Util;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import com.aldebaran.qi.helper.proxies.ALVideoDevice;

/**
 * This example shows how to take pictures using your robot's camera. Touch the
 * front head sensor to take a picture and display it in a new window. Touch the
 * rear head sensor to stop the application.
 */
public class ExTakePicture {

    private static Application application;
    private static ALMemory alMemory;
    private static String moduleName;

    private static ALVideoDevice video;
    private static ALMotion motion;
    private static ALTextToSpeech tts;
    private static ALAudioPlayer audio;
    private static List<ShowPicture> pictureWindow;

    static int topCamera = 0;
    static int resolution = 2; // 640 x 480
    static int colorspace = 11; // RGB
    static int frameRate = 10; // FPS

    public static void main(String[] args) {

        String robotUrl = "tcp://" + RobotInfo.IP + ":" + RobotInfo.PORT;
        application = new Application(args, robotUrl);
        pictureWindow = new ArrayList<ShowPicture>();

        try {
            application.start();

            alMemory = new ALMemory(application.session());
            alMemory.subscribeToEvent("FrontTactilTouched",
                    new EventCallback<Float>() {

                        @Override
                        public void onEvent(Float touch)
                                throws InterruptedException, CallError {
                            if (touch == 1.0) {
                                try {
                                    motion.wakeUp();
                                    tts.say("I'm going to take a picture. One. Two. Three. Smile!");
                                    byte[] rawData = takePicture();
                                    Picture picture = Util.toPicture(rawData);
                                    showPicture(picture);
                                    new File(picture.getFilename()).delete();
                                    tts.say("You look great!");
                                } catch (Exception e) {
                                    e.printStackTrace();
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
                                tts.say("Stopping application");
                                if (pictureWindow != null)
                                    for (int i = 0; i < pictureWindow.size(); i++)
                                        pictureWindow.get(i).dispose();
                                motion.rest();
                                application.stop();
                            }
                        }
                    });

            motion = new ALMotion(application.session());
            tts = new ALTextToSpeech(application.session());
            video = new ALVideoDevice(application.session());
            audio = new ALAudioPlayer(application.session());

            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showPicture(Picture picture) {
        pictureWindow.add(new ShowPicture(picture));
    }

    public static byte[] takePicture() throws Exception {
        moduleName = video.subscribeCamera("ExTakePicture", topCamera,
                resolution, colorspace, frameRate);
        System.out.format("subscribed with id: %s", moduleName);

        audio.playSoundSetFile("Aldebaran", "sfx_duck");
        @SuppressWarnings("unchecked")
        List<Object> image = (List<Object>) video.getImageRemote(moduleName);
        ByteBuffer buffer = (ByteBuffer) image.get(6);
        byte[] rawData = buffer.array();
        video.unsubscribe(moduleName);
        return rawData;
    }
}
