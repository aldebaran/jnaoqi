package com.aldebaran.examples;

import com.aldebaran.qi.RawApplication;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class SayHello {

    public static void main(String[] args) throws Exception {
        String robotUrl = "tcp://nao.local:9559";
        // Create a new application
        // Application application = new Application(args, robotUrl);
        RawApplication application = new RawApplication(args);
        Session session = new Session();
        session.connect(robotUrl).get();
        // Start your application
        // application.start();
        // Create an ALTextToSpeech object and link it to your current session
        // ALTextToSpeech tts = new ALTextToSpeech(application.session());
        ALTextToSpeech tts = new ALTextToSpeech(session);
        // Make your robot say something
        tts.say("Hello World!");
    }
}
