package com.aldebaran.example.myaldebaranapplication;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMotion;

/**
 * Created by root on 20/03/15.
 */
public class MoveTask extends AsyncTask<Float, Void, Boolean > {
    ALMotion motion;
    float velocityX, velocityY;

    public MoveTask(ALMotion motion){
        this.motion = motion;
    }

    @Override
    protected Boolean doInBackground(Float... params) {
        float velocityX = params[0];
        float velocityY = params[1];
        try {
            this.motion.moveToward(velocityX, velocityY, 0f);
            return true;
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
