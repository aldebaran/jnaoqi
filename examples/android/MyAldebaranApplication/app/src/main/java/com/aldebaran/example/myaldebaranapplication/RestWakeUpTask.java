package com.aldebaran.example.myaldebaranapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * Created by Thalia on 20/03/15.
 */
public class RestWakeUpTask extends AsyncTask<View, Void, String>{
    ALMotion motion;
    ALTextToSpeech speech;
    Activity activity;
    Button button;
    ProgressDialog dialog;

    public RestWakeUpTask(ALMotion motion, ALTextToSpeech speech, Activity activity){
        this.motion = motion;
        this.speech = speech;
        this.activity = activity;
        dialog = new ProgressDialog(activity);
    }

    @Override
    protected void onPreExecute() {
        this.dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        this.dialog.setMessage(activity.getString(R.string.wait_message));
        this.dialog.show();
    }
    @Override
    protected String doInBackground(View... params) {
        button = (Button) params[0];
            try {
                if(button.getText().equals(activity.getString(R.string.rest))) {
                    if (speech != null)
                        speech.say(activity.getString(R.string.rest));
                    motion.rest();
                    return activity.getString(R.string.wake);
                }
                else {
                    if (speech != null)
                        speech.say(activity.getString(R.string.wake));
                    motion.wakeUp();
                    return activity.getString(R.string.rest);
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
        if (result != null)
            button.setText(result);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}