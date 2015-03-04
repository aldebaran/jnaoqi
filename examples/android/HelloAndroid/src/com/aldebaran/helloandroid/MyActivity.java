package com.aldebaran.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.EmbeddedTools;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MyActivity extends Activity {
    private static final String TAG = "MyActivity";
    private ALMotion alMotion;
    private ALTextToSpeech alSpeech;
    private ALMemory alMemory;
    private Session session;
    private EditText ip;
    private Context context;
    private ALRobotPosture alPosture;
	private Thread routine;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.main);
        ip = (EditText) findViewById(R.id.robot_ip_edit);

        EmbeddedTools ebt = new EmbeddedTools();
        File cacheDir = getApplicationContext().getCacheDir();
        ebt.overrideTempDirectory(cacheDir);
        ebt.loadEmbeddedLibraries();
    }

    private void startServiceRoutine(final String ipAddress) {

	   routine = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                    session = new Session();
	                session.onDisconnected("onDisconnected", this);
                    try {
	                    Log.i(TAG, "Ip address : " + ipAddress);
                        session.connect("tcp://" + ipAddress + ":9559").get(500, TimeUnit.MILLISECONDS);
	                    alMotion = new ALMotion(session);
	                    alMotion.setAsynchronous(true);
	                    alSpeech = new ALTextToSpeech(session);
	                    alSpeech.setAsynchronous(true);
	                    alMemory = new ALMemory(session);
	                    alPosture = new ALRobotPosture(session);
	                    alPosture.setAsynchronous(true);
	                    setButtonVisible(true);
                    } catch (Exception e) {
	                    setButtonVisible(false);
	                    runOnUiThread(new Runnable() {
		                    @Override
		                    public void run() {
			                    Toast.makeText(context, "The robot is unreachable", Toast.LENGTH_SHORT).show();
	                    }
                    });
                }
            }

	        public void onDisconnected(String message) {
		        runOnUiThread(new Runnable() {
			        @Override
			        public void run() {
				        Toast.makeText(context, "Connection lost", Toast.LENGTH_SHORT).show();
				        setButtonVisible(false);
			        }
		        });
	        }
        });
        routine.start();
    }


	private void setButtonVisible(final boolean isVisible) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				findViewById(R.id.command1).setVisibility(isVisible ? View.VISIBLE : View.GONE);
				findViewById(R.id.command2).setVisibility(isVisible ? View.VISIBLE : View.GONE);
				findViewById(R.id.command3).setVisibility(isVisible ? View.VISIBLE : View.GONE);
				if(isVisible) {
					((Button)findViewById(R.id.connectButton)).setText("Disconnect");
				}
				else {
					((Button)findViewById(R.id.connectButton)).setText("Connect");
				}
			}
		});
	}


	public void connect(View view) {
		Button button = (Button) view;
		if (button.getText().equals("Connect")) {
			if (ip.getText() != null
					&& !ip.getText().toString().equals("")) {

				String address = ip.getText().toString();
				startServiceRoutine(address);
			}
			else {
				Toast.makeText(context, "Please enter a robot ip or a robot name", Toast.LENGTH_SHORT).show();
			}
		}
		else {
			session.close();
		}
    }

    public void onHandController(View view) throws InterruptedException, CallError {
	    Button button = (Button) view;
	    if (button.getText().equals("Open Hand")) {
            alMotion.openHand("RHand");
            alMotion.openHand("LHand");
		    button.setText("Close Hand");
	    }
	    else {
            alMotion.closeHand("RHand");
            alMotion.closeHand("LHand");
		    button.setText("Open Hand");

	    }
    }

    public void onRestController(View view) throws InterruptedException, CallError {
	    Button button = (Button) view;
	    if(button.getText().equals("Rest")) {
            alSpeech.say("Rest");
            alMotion.rest();
		    button.setText("WakeUp");
	    }
	    else {
		    alSpeech.say("Wake");
		    alMotion.wakeUp();
		    button.setText("Rest");
	    }
    }

	public void onSitController(View view) throws InterruptedException, CallError {
		Button button = (Button) view;
		if (button.getText().equals("Sit")) {
			alPosture.goToPosture("Sit", 0.5f);
		    button.setText("Stand");
		}
		else {
			alPosture.goToPosture("Stand", 0.5f);
		    button.setText("Sit");
		}
	}

    private float velocityX = 0f;
    private float velocityY = 0f;

    public void onGoToFront(View view) throws InterruptedException, CallError {
        velocityX += 0.2f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onStop(View view) throws InterruptedException, CallError {
        velocityX = 0f;
        velocityY = 0f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }


    public void onGoToLeft(View view) throws InterruptedException, CallError {
        velocityY += 0.2f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToRight(View view) throws InterruptedException, CallError {
        velocityY -= 0.2f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToBack(View view) throws InterruptedException, CallError {
        velocityX -= 0.2f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }


	public void say(View view) throws InterruptedException, CallError {
		String text = ((EditText)findViewById(R.id.say_edit)).getText().toString();
		alSpeech.say(text);
	}
}
