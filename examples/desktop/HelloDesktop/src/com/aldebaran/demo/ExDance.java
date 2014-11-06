package com.aldebaran.demo;

import com.aldebaran.qimessaging.*;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

import java.lang.Object;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by epinault on 26/09/2014.
 */
public class ExDance {

	private static String ROBOT_IP = RobotIP.ip;
	private static final String ROBOT_PORT = RobotIP.port;

	public static ArrayList<Float> LARM_STRETCHED;
	public static ArrayList<Float> LARM_UP;
	public static ArrayList<Float> LARM_FRONT;
	public static ArrayList<Float> LARM_HIP;

	public static ArrayList<Float> RARM_STRETCHED;
	public static ArrayList<Float> RARM_UP;
	public static ArrayList<Float> RARM_FRONT;
	public static ArrayList<Float> RARM_HIP;

	private static ALMemory alMemory;
	private static ALTextToSpeech tts;
	private com.aldebaran.qimessaging.Object memory;
	private static ALMotion motion;
	private static Application application;
	private boolean running = false;

	public static void main(String[] args) {
		Float[] Lstretched = {0.2111847996711731f, 1.3107420206069946f, -1.284562587738037f, -0.03490659222006798f, -1.8238688707351685f, 0.5400000214576721f};
		Float[] Lup = {-1.4800336360931396f, 0.08084873855113983f, 0.44161051511764526f, -0.03490658476948738f, -1.787217378616333f, 0.5400000214576721f};
		Float[] Lfront = {2.802596928649634e-45f, -0.174532949924469f, 2.00189208984375f, -0.03490659222006798f, -1.787217378616333f, 0.5400000214576721f};
		Float[] Lhip = {1.1889886856079102f, 0.7981850504875183f, 0.3110186457633972f, -1.230137586593628f, -1.787217378616333f, 0.0f};

		Float[] Rstretched = {0.15184366703f, -1.31074202061f, 1.20078623295f, 0.076794475317f, 1.82386887074f, 0.589999973774f};
		Float[] Rup =  {-1.6335183382f, -0.00976557750255f, -0.232178241014f, 0.0730158835649f, 1.82386887074f, 0.0f};
		Float[] Rfront = {-0.0907571017742f, 0.0209439471364f, -1.70693230629f, 0.076794475317f, 1.82386887074f, 0.0f};
		Float[] Rhip = {1.51965844631f, -0.880720674992f, 0.0393116399646f, 1.50638234615f, 1.82386887074f, 0.0f};

		LARM_STRETCHED = new ArrayList<Float>(Arrays.asList(Lstretched));
		LARM_UP = new ArrayList<Float>(Arrays.asList(Lup));
		LARM_FRONT = new ArrayList<Float>(Arrays.asList(Lfront));
		LARM_HIP = new ArrayList<Float>(Arrays.asList(Lhip));

		RARM_STRETCHED = new ArrayList<Float>(Arrays.asList(Rstretched));
		RARM_UP = new ArrayList<Float>(Arrays.asList(Rup));
		RARM_FRONT = new ArrayList<Float>(Arrays.asList(Rfront));
		RARM_HIP = new ArrayList<Float>(Arrays.asList(Rhip));

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
						tts.say("Let's go!");
						motion.wakeUp();
						boolean running = true;
						float speed = 0.5f;
						ArrayList<ArrayList<Float>> movesL = new ArrayList<ArrayList<Float>>();
						movesL.add(LARM_HIP);
						movesL.add(LARM_STRETCHED);
						movesL.add(LARM_HIP);
						movesL.add(LARM_STRETCHED);
						ArrayList<ArrayList<Float>> movesR = new ArrayList<ArrayList<Float>>();
						movesR.add(RARM_HIP);
						movesR.add(RARM_STRETCHED);
						movesR.add(RARM_HIP);
						movesR.add(RARM_STRETCHED);
						ArrayList<Float> destL = movesL.remove(0);
						ArrayList<Float> destR = movesR.remove(0);
						while (running) {
							motion.setAngles("LArm", destL, speed);
							motion.setAngles("RArm", destR, speed);
							Thread.sleep(50);
							float dist = measureDistance("LArm", destR);
							if (dist < 0.1) {
								if (movesL.size() > 0) {
									destL = movesL.remove(0);
									destR = movesR.remove(0);
								}
								else {
									break;
								}
							}
						}
					}
				}
			});
			alMemory.subscribeToEvent("RearTactilTouched" , "onEnd::(f)", new Object() {
				public void onEnd(Float touch) throws InterruptedException, CallError {
					if(touch == 1.0) {
						tts.say("Done");
						motion.rest();
						application.stop();
					}
				}
			});
			application.run();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static float measureDistance(String joint, ArrayList<Float> desired) {
		float distanceSum = 0.0f;
		try {
			ArrayList<Float> angles = (ArrayList<Float>) motion.getAngles(joint, true);
			if ((desired.size() <= 0) || (desired.size() != angles.size())) {
				return 0f; // Could print a warning too, or even assert
			}
			for (int i = 0; i < angles.size(); i++) {
				distanceSum += Math.abs(desired.get(i) - angles.get(i));
			}
			return distanceSum / desired.size();
		} catch (CallError callError) {
			callError.printStackTrace();
			return 0f;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return 0f;
		}
	}


}
