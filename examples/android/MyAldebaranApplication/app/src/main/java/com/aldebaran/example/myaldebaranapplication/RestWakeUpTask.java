package com.aldebaran.example.myaldebaranapplication;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * Created by root on 20/03/15.
 */
public class RestWakeUpTask extends AsyncTask<View, Void, String>{
    ALMotion motion;
    ALTextToSpeech speech;
    Activity activity;
    String rest, wakeUp;
    Button button;

    public RestWakeUpTask(ALMotion motion, ALTextToSpeech speech, String rest, String wakeUp){
        this.motion = motion;
        this.speech = speech;
        this.rest = rest;
        this.wakeUp = wakeUp;
        this.activity = activity;
    }
    @Override
    protected String doInBackground(View... params) {
        button = (Button) params[0];
            try {
                if(button.getText().equals(this.rest)) {
                    if (speech != null)
                        speech.say(rest);
                    motion.rest();
                    return this.wakeUp;
                }
                else {
                    if (speech != null)
                        speech.say(wakeUp);
                    motion.wakeUp();
                    return this.rest;
                }
            } catch (CallError callError) {
                callError.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        button.setText(this.wakeUp);
    }
}