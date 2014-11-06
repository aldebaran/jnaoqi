package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;


/**
 * Created by epinault on 05/11/14.
 */
public class ExHelloJava {

	public static void main(String[] args) {

		Session session = new Session();
		Application application = new Application();
		try {
			Future<Void> future = session.connect("tcp://nao.local:9559");
			synchronized (future) {
				future.wait(1000);
			}

			final ALTextToSpeech tts = new ALTextToSpeech(session);
			tts.setLanguage("English");

			ALMemory alMemory = new ALMemory(session);
			alMemory.subscribeToEvent("FrontTactilTouched" , "onTouchFront::(f)", new Object() {

				public void onTouchFront(Float touch) throws InterruptedException, CallError {
					if(touch == 1.0) {
						tts.say("Hi");
					}
					else {
						tts.say("Thank's you!");
					}
				}
			});

			application.run();
			application.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
