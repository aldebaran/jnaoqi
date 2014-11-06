package com.aldebaran.helloandroid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALVideoDevice;

import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.List;

public class VideoActivity extends Activity {

    private static final int HEIGHT = 480;
    private static final int WIDTH = 640;
    private static final String ROBOT_NAME = "169.254.61.216";
    private ALVideoDevice video;
    private Application application;
    private String moduleName;
    private Handler handler;
    private ImageView image;

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);

        int topCamera = 0;
        int resolution = 2; // 640 x 480
        int colorspace = 11; // RGB
        int frameRate = 10; // FPS

        handler = new Handler();

        Session session = new Session();
        application = new Application();
        Future<Void> future = null;
        try {

            InetAddress[] inets = InetAddress.getAllByName(ROBOT_NAME);

            String robotIp = "wao";

            if(inets != null && inets.length > 0)
                robotIp = inets[0].getHostAddress();
            else
                robotIp = ROBOT_NAME;

            future = session.connect("tcp://"+robotIp+":9559");

            synchronized (future) {
                future.wait(1000);
            }

            video = new ALVideoDevice(session);
            moduleName = video.subscribeCamera("demoAndroid", topCamera, resolution, colorspace, frameRate);
            System.out.format("subscribed with id: %s", moduleName);
//            getVideo();
            image = (ImageView) findViewById(R.id.image_view);

            handler.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        image.setImageBitmap(getVideo());
                        handler.postDelayed(this, 100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Bitmap getVideo() throws Exception {
        List<Object> image = (List<Object>) video.getImageRemote(moduleName);
        ByteBuffer buffer = (ByteBuffer)image.get(6);
        byte[] rawData = buffer.array();

        int[] intArray = new int[HEIGHT * WIDTH];
        for (int i = 0; i < HEIGHT * WIDTH; i++) {
//            ((255 & 0xFF) << 24) | // alpha
            intArray[i] =
                    ((rawData[(i * 3)] & 0xFF) << 16) | // red
                    ((rawData[i * 3 + 1] & 0xFF) << 8) | // green
                    ((rawData[i * 3 + 2] & 0xFF)); // blue
        }

        Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.RGB_565);
        bitmap.setPixels(intArray, 0, WIDTH, 0, 0, WIDTH, HEIGHT);
        return bitmap;
//        return null;
    }


    @Override
    protected void onDestroy() {
        try {
            video.unsubscribe(moduleName);
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        application.stop();
        super.onDestroy();
    }
}
