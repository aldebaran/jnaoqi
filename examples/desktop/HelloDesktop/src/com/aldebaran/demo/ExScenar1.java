package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by epinault on 26/09/2014.
 */
public class ExScenar1 {

	private static final int STEP_STARTUP = 0;
	private static final int STEP_WAKE_UP = 1;
	private static final int STEP_MOVING_ARROUND = 2;
	private static final int STEP_JOKES = 3;
	private static final int STEP_DIALOG = 4;
	private static final int STEP_DETECT_SMILE = 5;
	private static final int STEP_END = 10;


	private static String APP_NAME = "scenar1_1";

	private static int currentStep = 0;
	private static Session session;


	private static float x = 0f;
	private static float y = 0f;
	private static float teta = 0f;

	private static ALBasicAwareness awareness;
	private static ALSpeechRecognition alSpeechRecognition;
	private static ALAnimatedSpeech alAnimatedSpeech;
	private static Application application;
	private static ALMemory alMemory;
	private static ALTextToSpeech tts;
	private static ALMotion motion;
	private static ALDialog dialog;
	private static ALFaceCharacteristics faceCharac;
	private static int next_step = STEP_MOVING_ARROUND;
	// Maintain the connection with naoqi

	public static void main(String[] args) {
		APP_NAME = APP_NAME + System.currentTimeMillis();
		// Connect to the robot
		application = new Application();
		session = new Session();
		Future<Void> future = null;
		try {
			System.out.printf("Connect to " + RobotIP.port);
			future = session.connect("tcp://"+RobotIP.ip+":"+RobotIP.port);

			synchronized (future) {
				future.wait(1000);
			}
			tts = new ALTextToSpeech(session);
			alMemory = new ALMemory(session);
			motion = new ALMotion(session);
			alAnimatedSpeech = new ALAnimatedSpeech(session);
			awareness = new ALBasicAwareness(session);
			alSpeechRecognition = new ALSpeechRecognition(session);
			dialog = new ALDialog(session);
			faceCharac = new ALFaceCharacteristics(session);

			alMemory.subscribeToEvent("RearTactilTouched", "onTouchEnd::(f)", new Object() {
				public void onTouchEnd(Float value) {
					System.out.println(APP_NAME + " : Touch " + value);
					if (value == 1.0) {
						stateMachine(STEP_END);
					}
				}
			});
			stateMachine(STEP_STARTUP);
//			tts.say("hello world!");
			application.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void stateMachine(int step) {
		currentStep = step;
		System.out.println("STEP : " + step);
		try {
			switch (currentStep) {

				// At Startup
				case STEP_STARTUP:
					// Create a proxy to listen for head touch events
					alMemory.subscribeToEvent("MiddleTactilTouched", "onHeadTouch::(f)", new Object() {
						public void onHeadTouch(Float value) {
							System.out.println(APP_NAME + " : Touch " + value);
							if (value == 1.0) {
								switch (currentStep) {
									case STEP_STARTUP:
										stateMachine(STEP_WAKE_UP);
										break;
								}
							}
						}
					});
					tts.say("hello world!");
					break;

				//On touch
				case STEP_WAKE_UP:
					//Wake the robot

					motion.wakeUp();

					//Configure the awareness of the robot

					awareness.setEngagementMode("SemiEngaged");
					awareness.setTrackingMode("Head");
					awareness.setStimulusDetectionEnabled("Sound", true);
					awareness.setStimulusDetectionEnabled("Movement", true);
					awareness.setStimulusDetectionEnabled("People", true);
					awareness.setStimulusDetectionEnabled("Touch", true);

					alMemory.subscribeToEvent("ALBasicAwareness/HumanTracked", "onHumanTracked::(i)", new Object() {

						public void onHumanTracked(Integer humanID) {
							if (humanID >= 0) {
								switch (currentStep) {
									case STEP_WAKE_UP:
										stateMachine(next_step);
										break;
								}
							}
						}
					});
					awareness.startAwareness();

					//Now we wait for the robot to see us and send an event Human Track
					break;

				// On seeing someone
				case STEP_MOVING_ARROUND:
					// Ask the human where to go

					tts.say("Where do you want me to go ?");

					//List of words that the robot will recognize
					ArrayList<String> words1 = new ArrayList<String>();
					words1.add("forward");
					words1.add("left");
					words1.add("right");
					words1.add("stop");
					words1.add("faster");
					words1.add("slower");
					words1.add("next");

					alSpeechRecognition.setVocabulary(words1, false);
					alSpeechRecognition.subscribe(APP_NAME);
					alMemory.subscribeToEvent("WordRecognized", "onWordRecognizedForMoving::(m)", new Object() {
						public void onWordRecognizedForMoving(Object words) throws InterruptedException, CallError {

							alSpeechRecognition.pause(true);

							String word = (String) ((List<Object>) words).get(0);
							System.out.println("Word " + word);


							if (word.equals("next")) {
								x = 0;
								y = 0;
								teta = 0;
								motion.moveToward(x, y, teta);
								alMemory.unsubscribeToEvent("WordRecognized", "onWordRecognizedForMoving::(m)");
								alSpeechRecognition.unsubscribe(APP_NAME);
								stateMachine(STEP_JOKES);

							} else {
								if (word.equals("forward")) {
									x = 0.6f;
								} else if (word.equals("left")) {
									teta = 0.4f;
								} else if (word.equals("right")) {
									teta = -0.4f;
								} else if (word.equals("stop")) {
									x = 0f;
									y = 0f;
									teta = 0f;
								} else if (word.equals("faster")) {
									if (x > 0)
										x += 0.2;
									else
										x -= 0.2;
								} else if (word.equals("slower")) {
									if (x < 0)
										x += 0.2;
									else
										x -= 0.2;
								}

								motion.moveToward(x, y, teta);
								Thread.sleep(3000);
								tts.say("What now ?");
								alSpeechRecognition.pause(false);
							}

						}
					});
					break;

				//At the end motions
				case STEP_JOKES:
					tts.say("What is a witch in a desert ? ");

					ArrayList<String> words2 = new ArrayList<String>();
					words2.add("I don't know");
					words2.add("a sandwich");

					alSpeechRecognition.setVocabulary(words2, false);
					alSpeechRecognition.subscribe(APP_NAME);
					alMemory.subscribeToEvent("WordRecognized", "onWordRecognizedJokes::(m)", new Object() {

						public void onWordRecognizedJokes(Object words) throws InterruptedException, CallError {
							alSpeechRecognition.pause(true);
							String word = (String) ((List<Object>) words).get(0);
							System.out.println("Word " + word);


							if (word.equals("I don't know")) {
								//TODO change animation
								alAnimatedSpeech.say("^start(animations/Stand/Emotions/Negative/Angry_4) A sandwich !! ");
							} else if (word.equals("sandwich")) {
								alAnimatedSpeech.say("^start(animations/Stand/Emotions/Positive/Winner_1) Yeah you win !! ");
							}
							stateMachine(STEP_END);
						}
					});
					break;

				case STEP_DIALOG:
					//#create a dialog data file
					String dialogString = "topic: ~myTopic () \n	language: enu \n u:(hello) hello \n ";

					File file = new File("myDialog.top");
//					StringBuffer
					//Path on the robot
//					file = open("path/to/myDialog.top","w")
//					file.write(dialogString)
//					file.close()

					//# load topic
					dialog.setLanguage("English");
					String topic = dialog.loadTopic("myDialog.top");
					// start dialog
					dialog.subscribe("myModule");
					// activate dialog
					dialog.activateTopic(topic);
					break;

				case STEP_DETECT_SMILE:

					float threshNeutralEmotion = 0.45f;
					float threshHappyEmotion = 0.35f;
					float threshSurprisedEmotion = 0.45f;
					float threshAngryEmotion = 0.7f;
					float threshSadEmotion = 0.55f;
					float threshScaredEmotion = 0.3f;

					// #activate the output of the box
					float[] tabProperties = new float[5];
					int counter = 0;
					boolean isRunning = true;

					while (isRunning) {
						System.out.println("Loop");
						if (counter < 3) {
							ArrayList<Integer> ids = (ArrayList<Integer>) alMemory.getData("PeoplePerception/PeopleList");
							if (ids.size() > 0) {
								faceCharac.analyzeFaceCharacteristics(ids.get(0));
								Thread.sleep(400);
								try {
									ArrayList<Float> properties = (ArrayList<Float>) alMemory.getData("PeoplePerception/Person/" + ids.get(0) + "/ExpressionProperties");
									tabProperties[0] += properties.get(0);
									tabProperties[1] += properties.get(1);
									tabProperties[2] += properties.get(2);
									tabProperties[3] += properties.get(3);
									tabProperties[4] += properties.get(4);
									counter += 1;
								} catch (Exception e) {

								}
							} else {
								isRunning = false;
								tts.say("I am all alone now");
							}
						} else {
							tabProperties[0] /= 3;
							tabProperties[1] /= 3;
							tabProperties[2] /= 3;
							tabProperties[3] /= 3;
							tabProperties[4] /= 3;

							if (tabProperties[1] > threshHappyEmotion) {
								tts.say("You are smiling ");
							} else if (tabProperties[2] > threshSurprisedEmotion) {
								tts.say("You are surprised ");
							} else if (tabProperties[3] > threshAngryEmotion) {
								tts.say("You are angry ");
							} else if (tabProperties[4] > threshSadEmotion) {
								tts.say("You are sad ");
							}
							counter = 0;
						}
					}

					break;


				//TODO : continuer les scénarios pour montrer d'autre chose interessante
				case STEP_END:
					tts.say("Application is stopping");
					awareness.stopAwareness();

					motion.rest();

					application.stop();
					break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
