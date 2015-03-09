package com.aldebaran.example.myaldebaranapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.ALInterface;
import com.aldebaran.qi.helper.ALProxy;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * This example shows how to control NAO from an Android application. The robot can say something by
 * using the ALTextToSpeech class, it can move by using the ALMotion class  and sit-down and
 * stand-up with ALRobotPosture class. First, you need to connect to your robot by given its IP address.
 * The class implements ALInterface in order to be able to know if a given ALProxy could be correctly
 * created with the given session.
 */
public class MainActivity extends FragmentActivity implements ALInterface{

    private static final String TAG = "MyActivity";
    private Session session;
    private ALMotion motion;
    private ALTextToSpeech speech;
    private ALRobotPosture posture;
    private PlaceholderFragment placeholderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.connect_container, new ConnectionFragment())
                    .commit();
            this.placeholderFragment = new PlaceholderFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, this.placeholderFragment)
                    .commit();
            getSupportFragmentManager().beginTransaction().hide(this.placeholderFragment).commit();
        }
    }

    public void showPlaceHolderFragment(){
        if (session != null) {
            Log.i(TAG, "showing fragment");
            // Call onProxyReady when a ALProxy is correctly initiated, or onProxyException otherwise.
            ALProxy.alInterface = this;
            // Create an instance of the needed ALProxy: ALMotion, ALTextToSpeech and ALRobotPosture
            motion = new ALMotion(session);
            // Calls should be done in asynchronous, by default this is false.
            motion.setAsynchronous(true);
            speech = new ALTextToSpeech(session);
            speech.setAsynchronous(true);
            posture = new ALRobotPosture(session);
            posture.setAsynchronous(true);
            getSupportFragmentManager().beginTransaction().show(this.placeholderFragment).commit();

            try {
                setButtonsLabels();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void setButtonsLabels() throws Exception{
        if (motion.robotIsWakeUp() == true)
            ((Button) findViewById(R.id.rest_wake_button)).setText(getString(R.string.rest));
        else
            ((Button) findViewById(R.id.rest_wake_button)).setText(getString(R.string.wake));
        if (posture.getPosture() == "Stand")
            ((Button) findViewById(R.id.sit_stand_button)).setText(getString(R.string.sit));
        else
            ((Button) findViewById(R.id.sit_stand_button)).setText(getString(R.string.stand));
    }

    public void hidePlaceHolderFragment(){
        getSupportFragmentManager().beginTransaction()
                .hide(this.placeholderFragment)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void connect(View view) {
        Button button = (Button) view;
        if (button.getText() == getString(R.string.connect)) {
            EditText ip = (EditText) findViewById(R.id.robot_ip);
            String robotIp = ip.getText().toString();
            if (robotIp != null)
                new ConnectionTask(this).execute(robotIp);
        }
        else{
            onDisconnected("Disconnection asked.");
        }
    }

    public void onHandController(View view){
        try{
            Button button = (Button) view;
            if (button.getText().equals(getString(R.string.open_hand))) {
                motion.openHand("RHand");
                motion.openHand("LHand");
                button.setText(getString(R.string.close_hand));
            }
            else {
                motion.closeHand("RHand");
                motion.closeHand("LHand");
                button.setText(getString(R.string.open_hand));

            }
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onRestController(View view){
        try{
            Button button = (Button) view;
            if(button.getText().equals(getString(R.string.rest))) {
                if (speech != null)
                    speech.say(getString(R.string.rest));
                    motion.rest();

                button.setText(getString(R.string.wake));
            }
            else {
                if (speech != null)
                    speech.say(getString(R.string.wake));
                motion.wakeUp();
                button.setText(getString(R.string.rest));
            }
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onSitController(View view){
        try{
            Button button = (Button) view;
            if (button.getText().equals(getString(R.string.sit))) {
                posture.goToPosture("Sit", 0.5f);
                button.setText(getString(R.string.stand));
            }
            else {
                posture.goToPosture("Stand", 0.5f);
                button.setText(getString(R.string.sit));
            }
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private float velocityX = 0f;
    private float velocityY = 0f;

    public void onGoToFront(View view) throws InterruptedException, CallError {
        velocityX += 0.2f;
        motion.moveToward(velocityX, velocityY, 0f);
    }

    public void onStop(View view) throws InterruptedException, CallError {
        velocityX = 0f;
        velocityY = 0f;
        motion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToLeft(View view) throws InterruptedException, CallError {
        velocityY += 0.2f;
        motion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToRight(View view) throws InterruptedException, CallError {
        velocityY -= 0.2f;
        motion.moveToward(velocityX, velocityY, 0f);
    }

    public void onGoToBack(View view) throws InterruptedException, CallError {
        velocityX -= 0.2f;
        motion.moveToward(velocityX, velocityY, 0f);
    }


    public void say(View view) throws InterruptedException, CallError {
        String text = ((EditText)findViewById(R.id.text_to_say)).getText().toString();
        speech.say(text);
    }

    @Override
    public void onProxyReady(String name) {

        Log.i(TAG, "Ready " + name);
        if (name.equals("ALMotion")){
            findViewById(R.id.moving_layout).setVisibility(View.VISIBLE);
            findViewById(R.id.motion_layout).setVisibility(View.VISIBLE);
        }
        else if (name.equals("ALTextToSpeech")){
            findViewById(R.id.tts_layout).setVisibility(View.VISIBLE);
        }
        else if (name.equals("ALRobotPosture")){
            findViewById(R.id.sit_stand_button).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onProxyException(String name, Exception e) {
        Log.e(TAG, "error " + name, e);
        if (name == "ALTextToSpeech"){
            speech = null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    public static class ConnectionFragment extends Fragment {

        public ConnectionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_connection, container, false);
            return rootView;
        }
    }
    // A callback to do something if the session disconnects.
    public void onDisconnected(String message){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hidePlaceHolderFragment();
                ((Button) findViewById(R.id.connect_button)).setText(getString(R.string.connect));
                findViewById(R.id.robot_ip).setEnabled(true);
                Toast.makeText(getApplicationContext(), getString(R.string.connection_lost), Toast.LENGTH_LONG).show();
            }
        });
    }

    private class ConnectionTask extends AsyncTask<String, Integer, Session>{

        private ProgressDialog dialog;
        private Activity myActivity;

        public ConnectionTask(Activity activity){
            myActivity = activity;
            dialog = new ProgressDialog(activity);
        }

        @Override
        protected void onPreExecute() {
            this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            this.dialog.setMessage(getString(R.string.connecting_message));
            this.dialog.show();
        }

        protected Session doInBackground(String... url) {
            try {
                // Create a new Session
                session = new Session();
                // Connect to the robot in the given IP address
                session.connect(url[0]).get();
                // Set the callback method in case connection is lost.
                session.onDisconnected("onDisconnected", myActivity);
            }
            catch (Exception e){
                session = null;
                e.printStackTrace();
            }
            return session;
        }

        protected void onPostExecute(Session createdSession) {
            String message = getString(R.string.not_connected);
            if (createdSession != null) {
                message = getString(R.string.connected);
                ((Button) findViewById(R.id.connect_button)).setText(getString(R.string.disconnect));
                findViewById(R.id.robot_ip).setEnabled(false);
                ((MainActivity) myActivity).showPlaceHolderFragment();
            }
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
            toast.show();
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }


    }
}