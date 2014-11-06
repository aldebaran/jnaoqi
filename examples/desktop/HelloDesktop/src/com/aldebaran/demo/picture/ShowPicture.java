package com.aldebaran.demo.picture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;

public class ShowPicture extends Frame {
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 640;
	private static final int WIDTH = 480;

	private BufferedImage image;

	@SuppressWarnings("serial")
	class PicturePanel extends Panel {
		private BufferedImage image;

		public PicturePanel(BufferedImage image) {
			this.image = image;
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);

			int w = getWidth();
			int h = getHeight();
			int imageWidth = image.getWidth(this);
			int imageHeight = image.getHeight(this);
			int x = (w - imageWidth) / 2;
			int y = (h - imageHeight) / 2;
			g.drawImage(image, x, y, this);
		}

	}


	public ShowPicture(Picture picture) {
		super("image frame");
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		image = picture.getImage();
		PicturePanel picturePanel = new PicturePanel(image);
		add(picturePanel);
		Dimension preferredSize = new Dimension(WIDTH, HEIGHT);
		picturePanel.setPreferredSize(preferredSize);
		Font font = new Font("Cantarell", Font.PLAIN, 22);
		Label caption = new Label("Hello Java One");
		caption.setAlignment(Label.CENTER);
		caption.setFont(font);
		caption.setBackground(Color.WHITE);
		caption.setBounds(0, HEIGHT - 22, WIDTH, HEIGHT);
		add(caption);
		setSize(HEIGHT, WIDTH + 30);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}


	public static void main(String[] args) throws Exception {
		FileInputStream input = new FileInputStream("out.bmp");
		byte[] rawData = new byte[3 * HEIGHT * WIDTH];
		input.read(rawData);
		input.close();

        Picture picture = Util.toPicture(rawData);
		new ShowPicture(picture);
	}
}
