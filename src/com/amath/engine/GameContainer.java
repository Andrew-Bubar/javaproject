package com.amath.engine;

import java.awt.event.KeyEvent;

public class GameContainer implements Runnable {

	// Variables
	private Thread thread;
	private boolean running = false;
	private final double UPDATE_CAP = 1.0 / 60.0;
	private int width = 320, height = 240;
	private float scale = 3f;
	private String title = "amathEngine";

	// calling my classes
	private Window win;
	private Render ren;
	private Input input;
	private AbstractGame game;

	// initialize gc do the following
	public GameContainer(AbstractGame game) {
		this.game = game;
	}

	public void start() {

		win = new Window(this);
		ren = new Render(this);
		input = new Input(this);

		// setting the new thread
		thread = new Thread(this);
		thread.run();
	}

	public void stop() {

	}

	public void run() {

		// setting varables
		running = true;
		boolean render = false;
		// the doubles
		double fTime = 0;
		double lTime = System.nanoTime() / 1000000000.0; // thats 9 zeros (or should be)
		double pTime = 0;
		double uTime = 0;

		// the fps
		double frTime = 0;
		int frames = 0;
		int fps = 0;

		// when running
		while (running) {

			render = false;

			// sees the passing of time
			fTime = System.nanoTime() / 1000000000.0;
			pTime = fTime - lTime;
			lTime = fTime;

			uTime += pTime;
			frTime += pTime;

			while (uTime >= UPDATE_CAP) {

				uTime -= UPDATE_CAP;
				// render / update at a set framerate
				render = true;

				// TODO: update game
				game.update(this, (float) UPDATE_CAP);

				// calculating FPS
				if (frTime >= 1.0) {

					frTime = 0;
					fps = frames;
					frames = 0;
					System.out.println("FPS: " + fps);
				}

				if (render) {
					game.render(this, ren);
					ren.clear();
					win.update();

					// fps calculation
					frames++;
				}

				else {

					try {

						Thread.sleep(1);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		}
		dispose();
	}

	public void dispose() {

	}

	public static void main(String args[]) {

		// calling gc
		// GameContainer gc = new GameContainer();
		// gc.start();
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

	public float getScale() {
		return scale;
	}

	public void setScale(float scale) {
		this.scale = scale;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Window getWin() {
		return win;
	}

	public Input getInput() {
		return input;
	}

	public void print(String s) {
		System.out.println(s);
	}
}
