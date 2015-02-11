package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 07/11/14.
 */
public class Main2 {

	public static void main(String[] args) {
		Session session = new Session();
		Application application = new Application();
		try {
			Future<Void> future = session.connect("tcp://169.254.232.44:9559");
//			Future<Void> future = session.connect("tcp://ngrok.com:56336");
			synchronized (future) {
				future.wait(1000);
			}
			final ALTextToSpeech tts = new ALTextToSpeech(session);
			tts.setLanguage("English");

			ALMemory alMemory = new ALMemory(session);
			alMemory.subscribeToEvent("FrontTactilTouched", "onTouchFront::(f)", new Object() {

				public void onTouchFront(Float touch) throws InterruptedException, CallError {
					if (touch == 1.0) {
						tts.say("Hi");
					} else {
						tts.say("Thank you!");
					}
				}
			});
			application.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
