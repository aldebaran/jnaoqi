package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 11/05/2014.
 */
public class ExHelloWorldApplication {


    public static void main(String[] args) {
	    Application application = new Application(args);
        try {

	        ALTextToSpeech tts = new ALTextToSpeech();
	        Boolean pong = tts.ping();
	        if(pong)
                tts.say("Hello World");
	        else
		        System.out.println("Can't find ALTextToSpeech module");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
