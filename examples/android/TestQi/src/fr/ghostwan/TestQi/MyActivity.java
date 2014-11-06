package fr.ghostwan.TestQi;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.EmbeddedTools;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALRobotPosture;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

import java.io.File;
import java.net.InetAddress;
import java.util.Objects;
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

    private void startServiceRoutine() {

        Thread routine = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                if (ip.getText() != null && !ip.getText().toString().equals("")) {
                    session = new Session();
                    try {
                        String ipAddress = ip.getText().toString();
                        if (!ipAddress.contains(".")) {
                            InetAddress[] inets = InetAddress.getAllByName(ipAddress);
                            if (inets != null && inets.length > 0)
                                ipAddress = inets[0].getHostAddress();
                        }
                        Log.i(TAG, "Ip address : " + ipAddress);
                        session.connect("tcp://" + ipAddress + ":9559").sync(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e(TAG, "error", e);
                    }
                    alMotion = new ALMotion(session);
                    alSpeech = new ALTextToSpeech(session);
                    alSpeech.setAsynchronous(true);
                    alMemory = new ALMemory(session);
                    alPosture = new ALRobotPosture(session);
                }
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "Please enter a robot ip or a robot name", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        routine.start();
    }


    public void connect(View view) {
        startServiceRoutine();
    }

    public void testApi(View view) {
        try {
            alMemory.subscribeToEvent("ALTextToSpeech/TextStarted", "onSpeech::(i)", this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMessage(String message) {
        final String messageToDisplay = "onMessage : " + message;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(context, "message : " + messageToDisplay, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onSpeech(Integer message) {
        final String messageToDisplay = "int : " + message;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(context, "onSpeech : " + messageToDisplay, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void onOpenHand(View view) throws InterruptedException, CallError {
        alMotion.openHand("RHand");
    }

    public void onCloseHand(View view) throws InterruptedException, CallError {
        alMotion.closeHand("RHand");
    }

    public void onWake(View view) throws InterruptedException, CallError {
        alSpeech.say("Wake");
        alMotion.wakeUp();
        alPosture.goToPosture("Stand", 0.5f);
    }

    public void onRest(View view) throws InterruptedException, CallError {
        alSpeech.say("Rest");
        alMotion.rest();
    }

    private float velocityX = 0f;
    private float velocityY = 0f;

    public void onGoToFront(View view) throws InterruptedException, CallError {
        velocityX += 0.1f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onStop(View view) throws InterruptedException, CallError {
        velocityX = 0f;
        velocityY = 0f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }


    public void onGoToLeft(View view) throws InterruptedException, CallError {
        velocityY += 0.1f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToRight(View view) throws InterruptedException, CallError {
        velocityY -= 0.1f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToBack(View view) throws InterruptedException, CallError {
        velocityX -= 0.1f;
        alMotion.moveToward(velocityX, velocityY, 0f);
    }

    public void onSit(View view) throws InterruptedException, CallError {
        alPosture.goToPosture("Sit",0.5f);
    }
}
