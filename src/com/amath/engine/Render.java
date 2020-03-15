package com.amath.engine;

import java.awt.image.DataBufferInt;

import com.amath.engine.gfx.Image;

public class Render {

	// vars
	private int pW, pH;
	private int[] p;

	public Render(GameContainer gc) {

		// settings the vars
		pW = gc.getWidth();
		pH = gc.getHeight();
		// gather data from the windows to use in the rendering
		p = ((DataBufferInt) gc.getWin().getImage().getRaster().getDataBuffer()).getData();
	}

	// remove all rendered stuff
	public void clear() {

		// checking for every process in the screen
		for (int i = 0; i < p.length; i++) {

			p[i] += 0;
		}
	}

	// handling pixels
	public void setPixel(int x, int y, int value) {

		if ((x < 0 || x >= pW || y < 0 || y >= pH) || value == 0xffff00ff) {
			return;
		}

		p[x + y * pW] = value;
	}

	// drawing the image
	public void drawImage(Image image, int offx, int offy) {

		for (int y = 0; y < image.getHeight(); y++) {

			for (int x = 0; x < image.getWidth(); x++) {

				setPixel(x + offx, y + offy, image.getP()[x + y * image.getWidth()]);
			}
		}
	}
}










