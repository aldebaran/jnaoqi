package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALBasicAwareness;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 25/09/2014.
 */
//Only on real robot
public class ExBasicAwareness  {

	private static ALMemory alMemory;
	private static Application application;
	private static ALBasicAwareness awareness;
	private static ALTextToSpeech tts;
	private static ALMotion motion;

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
			awareness = new ALBasicAwareness(session);
			tts = new ALTextToSpeech(session);
			motion = new ALMotion(session);

			tts.say("hello");
			motion.wakeUp();
			awareness.setEngagementMode("SemiEngaged");
			awareness.setTrackingMode("Head");
			awareness.setStimulusDetectionEnabled("Sound", true);
			awareness.setStimulusDetectionEnabled("Movement", true);
			awareness.setStimulusDetectionEnabled("People", true);
			awareness.setStimulusDetectionEnabled("Touch", true);

			alMemory.subscribeToEvent("RearTactilTouched" , "onBackTouch::(f)", new Object() {
				public void onBackTouch(Float touch) throws InterruptedException, CallError {
					if(touch == 1.0) {
						System.out.println("touch");
						awareness.stopAwareness();
					}
				}
			});
			alMemory.subscribeToEvent("FrontTactilTouched" , "onFrontTouch::(f)", new Object() {
				public void onFrontTouch(Float touch) throws InterruptedException, CallError {
					if(touch == 1.0) {
						System.out.println("touch");
						awareness.startAwareness();
					}
				}
			});
			alMemory.subscribeToEvent("ALBasicAwareness/HumanTracked", "onHumanTracked::(i)", new Object() {
				public void onHumanTracked(Integer humanID) throws InterruptedException, CallError {
					if (humanID >= 0) {
						tts.say("I see " + humanID);
					}
				}
			});
			application.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
