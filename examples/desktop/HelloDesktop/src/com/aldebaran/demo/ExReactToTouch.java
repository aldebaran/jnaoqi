package com.aldebaran.demo;

import com.aldebaran.qimessaging.*;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

import java.lang.Object;

/**
 * Created by epinault on 11/05/2014.
 */
public class ExReactToTouch {


    private static ALMemory alMemory;
    private static ALTextToSpeech tts;
    private static ALMotion motion;
    private static Application application;

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
            tts = new ALTextToSpeech(session);
            motion = new ALMotion(session);

            alMemory.subscribeToEvent("FrontTactilTouched" , "onTouchFront::(f)", new Object() {
	            public void onTouchFront(Float touch) throws InterruptedException, CallError {
		            if(touch == 1.0) {
			            tts.say("Hi");
			            motion.wakeUp();
		            }
		            else {
			            tts.say("Thank's you!");
		            }
	            }
            });
            alMemory.subscribeToEvent("MiddleTactilTouched" , "onTouchSynch::(f)", new Object() {
	            public void onTouchAsynch(Float touch) throws InterruptedException, CallError {
		            if(touch == 1.0) {
			            tts.setAsynchronous(true);
			            tts.say("Now I'm gonna rest because I'm really tired");
			            motion.rest();
		            }
	            }
            });
            alMemory.subscribeToEvent("RearTactilTouched" , "onTouchAsynch::(f)", new Object() {
	            public void onTouchSynch(Float touch) throws InterruptedException, CallError {
		            if(touch == 1.0) {
			            tts.say("Now I'm gonna rest because I'm really tired");
			            motion.rest();
		            }
	            }
            });
            alMemory.subscribeToEvent("LeftBumperPressed" , "onEnd::(f)", new Object() {
	            public void onEnd(Float touch) throws InterruptedException, CallError {
		            if(touch == 1.0) {
			            tts.say("Application is stopping");
			            motion.rest();
			            application.stop();
		            }
	            }
            });

	        tts.say("I am ready");
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
