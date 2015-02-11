package com.aldebaran.demo;

import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 07/11/14.
 */
public class Main1 {

	public static void main(String[] args) {
		Session session = new Session();
		try {
			Future<Void> future = session.connect("tcp://169.254.232.44:9559");
			synchronized (future) {
				future.wait(1000);
			}

			ALTextToSpeech tts = new ALTextToSpeech(session);
			tts.setLanguage("English");
			tts.say("Hello Java!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
