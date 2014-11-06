package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.Object;

import java.util.concurrent.TimeUnit;

public class Main {

    private static Application qiApp;
    private static Session session;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting...");

        routine();
        Thread.sleep(3000);
        Object tts = null;
        try {
            tts = session.service("ALTextToSpeech");
            tts.call("say", "Hello, Geecon");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void routine() {

        Thread routine = new Thread(new Runnable() {
            @Override
            public void run() {

                session = new Session();
                try {
                    session.connect("tcp://" + "127.0.0.1" + ":9559").sync(500, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        routine.start();
    }


}
