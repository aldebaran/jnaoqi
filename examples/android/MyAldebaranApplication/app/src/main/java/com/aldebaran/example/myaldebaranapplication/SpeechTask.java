package com.aldebaran.example.myaldebaranapplication;

import android.os.AsyncTask;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * Created by root on 20/03/15.
 */
public class SpeechTask extends AsyncTask<String, Void, Boolean> {
    ALTextToSpeech speech;

    public SpeechTask(ALTextToSpeech speech){
        this.speech = speech;
    }
    @Override
    protected Boolean doInBackground(String... params) {
        try {
            this.speech.say(params[0]);
            return true;
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
