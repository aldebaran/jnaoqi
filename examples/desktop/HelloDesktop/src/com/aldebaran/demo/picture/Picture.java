package com.aldebaran.demo.picture;

import java.awt.image.BufferedImage;

public class Picture {
    private BufferedImage image;
    private String filename;
    public Picture(BufferedImage image, String filename) {
        this.image = image;
        this.filename = filename;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public String getFilename() {
        return this.filename;
    }
}
