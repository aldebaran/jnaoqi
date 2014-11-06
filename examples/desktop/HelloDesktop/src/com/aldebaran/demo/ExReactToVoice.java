package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epinault on 11/05/2014.
 */
public class ExReactToVoice {

    private static boolean isAwake = false;
    private static Application application;

    private static ALMemory alMemory;
    private static ALMotion motion;
    private static ALSpeechRecognition alSpeechRecognition;
    private static ALTextToSpeech tts;
    private static ALRobotPosture posture;

    public static void main(String[] args) {
        application = new Application();
        Session session = new Session();
        Future<Void> future = null;
        try {
	        future = session.connect("tcp://"+RobotIP.ip+":"+RobotIP.port);

            synchronized (future) {
                future.wait(1000);
            }

            alMemory = new ALMemory(session);
            motion = new ALMotion(session);
            alSpeechRecognition = new ALSpeechRecognition(session);
            tts = new ALTextToSpeech(session);
            posture = new ALRobotPosture(session);

            ArrayList<String> listOfWords = new ArrayList<String>();
            listOfWords.add("wake");
            listOfWords.add("come");
            listOfWords.add("stop");

            alSpeechRecognition.setVocabulary(listOfWords,false);

            alSpeechRecognition.subscribe("demo2");
            alMemory.subscribeToEvent("WordRecognized", "onWordRecognized::(m)", new Object() {
	            public void onWordRecognized(Object words) throws InterruptedException, CallError {
		            String word = (String) ((List<Object>)words).get(0);
		            System.out.println("Word "+word);

		            if(word.equals("wake") && !isAwake) {
			            tts.say("hi");
			            alSpeechRecognition.pause(true);
			            motion.wakeUp();
			            alSpeechRecognition.pause(false);
			            isAwake = true;
		            }
		            else if (word.equals("come") && isAwake) {
			            motion.moveToward(0.6f, 0f, 0f);
		            }
		            else if (word.equals("stop") && isAwake) {
			            motion.moveToward(0f, 0f, 0f);
		            }
	            }
            });
            alMemory.subscribeToEvent("MiddleTactilTouched", "onEnd::(f)", new Object() {
	            public void onEnd(Float touch) throws InterruptedException, CallError {
		            if (touch == 1.0) {
			            tts.say("Application is stopping");
			            motion.rest();
			            application.stop();
			            alSpeechRecognition.unsubscribe("demo");
		            }
	            }
            });
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
