package com.aldebaran.demo.picture;

import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

public class Util {
    private static final int HEIGHT = 640;
    private static final int WIDTH = 480;

    public static Picture toPicture(byte[] data) {
        int[] intArray;
        intArray = new int[HEIGHT * WIDTH];
        for (int i = 0; i < HEIGHT * WIDTH; i++) {
            intArray[i] = ((255 & 0xFF) << 24) | // alpha
                    ((data[i * 3 + 0] & 0xFF) << 16) | // red
                    ((data[i * 3 + 1] & 0xFF) << 8) | // green
                    ((data[i * 3 + 2] & 0xFF) << 0); // blue
        }
        BufferedImage img = new BufferedImage(HEIGHT, WIDTH,
                BufferedImage.TYPE_INT_RGB);
        img.setRGB(0, 0, HEIGHT, WIDTH, intArray, 0, HEIGHT);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        String fileName = String.format("Photo-%s.png", dateStr);
        File out = new File(fileName);
        try {
            ImageIO.write(img, "png", out);
        } catch (IOException e) {
            // nothing
        }
        return new Picture(img, fileName);
    }

}
