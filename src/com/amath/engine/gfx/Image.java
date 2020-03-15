package com.amath.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {

	private int width, height;
	private int[] p;

	public Image(String path) {

		// making sure its clean
		BufferedImage image = null;

		// grabbinjg the class
		try {
			image = ImageIO.read(Image.class.getResourceAsStream(path));
		} catch (IOException e) {

			e.printStackTrace();
		}

		// get the size
		width = image.getWidth();
		height = image.getHeight();

		// get the pixel data
		p = image.getRGB(0, 0, width, height, null, 0, width);

		image.flush();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int[] getP() {
		return p;
	}

	public void setP(int[] p) {
		this.p = p;
	}
}
