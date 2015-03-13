package com.aldebaran.examples;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class ReactToEvents {

    public static void main(String[] args) throws Exception {

        String robotUrl = "tcp://nao.local:9559";
        // Create a new application
        Application application = new Application(args, robotUrl);
        // Start your application
        application.start();
        System.out.println("Successfully connected to the robot");
        // Subscribe to selected ALMemory events
        ReactToEvents reactor = new ReactToEvents();
        reactor.run(application.session());
        System.out
                .println("Subscribed to FrontTactilTouched and RearTactilTouched.");
        // Run your application
        application.run();

    }

    ALMemory memory;
    ALTextToSpeech tts;
    long frontTactilSubscriptionId;

    public void run(Session session) throws Exception {

        memory = new ALMemory(session);
        tts = new ALTextToSpeech(session);
        frontTactilSubscriptionId = 0;

        // Subscribe to FrontTactilTouched event,
        // create an EventCallback expecting a Float.
        frontTactilSubscriptionId = memory.subscribeToEvent(
                "FrontTactilTouched", new EventCallback<Float>() {
                    @Override
                    public void onEvent(Float arg0)
                            throws InterruptedException, CallError {
                        // 1 means the sensor has been pressed
                        if (arg0 > 0) {
                            tts.say("ouch!");
                        }
                    }
                });
        // Subscribe to RearTactilTouched event,
        // create an EventCallback expecting a Float.
        memory.subscribeToEvent("RearTactilTouched",
                new EventCallback<Float>() {
                    @Override
                    public void onEvent(Float arg0)
                            throws InterruptedException, CallError {
                        if (arg0 > 0) {
                            if (frontTactilSubscriptionId > 0) {
                                tts.say("I'll no longer say ouch");
                                // Unsubscribing from FrontTactilTouched event
                                memory.unsubscribeToEvent(frontTactilSubscriptionId);
                            }
                        }
                    }
                });
    }

}