package com.aldebaran.demo;

import com.aldebaran.qimessaging.*;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 11/05/2014.
 */
public class ExHelloWorld {


    public static void main(String[] args) {
        Session session = new Session();
        Future<Void> future = null;
        try {
	        future = session.connect("tcp://"+RobotIP.ip+":"+RobotIP.port);

            synchronized (future) {
                future.wait(1000);
            }

	        ALTextToSpeech tts = new ALTextToSpeech(session);
            tts.say("Hello, Java One!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
