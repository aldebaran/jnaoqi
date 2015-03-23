package com.aldebaran.example.myaldebaranapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

/**
 * Created by Thalia on 23/03/15.
 */
public class PostureTask  extends AsyncTask<View, Void, String>{
    Activity activity;
    ALRobotPosture posture;
    ProgressDialog dialog;
    Button button;

    public PostureTask(ALRobotPosture posture, Activity activity){
        this.posture = posture;
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
        try{
            button = (Button) params[0];
            if (button.getText().equals(activity.getString(R.string.sit))) {
                posture.goToPosture("Sit", 0.5f);
                return activity.getString(R.string.stand);

            }
            else {
                posture.goToPosture("Stand", 0.5f);
                return activity.getString(R.string.sit);
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
