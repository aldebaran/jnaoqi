/**
 * Copyright (c) 2015 Aldebaran Robotics. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the COPYING file.
 * Created by epinault on 11/05/2014.
 */
package com.aldebaran.demo;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * This example show how the robot can listen to touch events:
 * FrontTactilTouched, MiddleTactilTouched, RearTactilTouched, LeftBumperPressed
 * and RightBumperPressed.
 */
public class ExReactToTouch {

	private static ALTextToSpeech tts;

	public static void main(String[] args) {
        String robotUrl = "tcp://" + RobotInfo.IP + ":" + RobotInfo.PORT;
		Application application = new Application(args, robotUrl);
        try {
            application.start();

	        ALMemory alMemory = new ALMemory(application.session());
            tts = new ALTextToSpeech(application.session());

	        alMemory.subscribeToEvent("FrontTactilTouched", (touch) -> {
		        if ((float) touch == 1.0) {
			        tts.say("Front");
		        }
	        });
            alMemory.subscribeToEvent("MiddleTactilTouched", (touch) -> {
	            if ((float) touch == 1.0) {
		            tts.say("Middle");
	            }
            });
            alMemory.subscribeToEvent("RearTactilTouched", (touch) -> {
	            if ((float) touch == 1.0) {
		            tts.say("Rear");
	            }
            });;
            alMemory.subscribeToEvent("LeftBumperPressed", (touch) -> {
	            if ((float) touch == 1.0) {
		            tts.say("Left bumper");
	            }
            });
            alMemory.subscribeToEvent("RightBumperPressed", (touch) -> {
	            if ((float) touch == 1.0) {
		            tts.say("Right bumper");
	            }
            });

            tts.say("I am ready");
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
