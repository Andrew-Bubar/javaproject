package com.amath.engine;

public class GameContainer implements Runnable {
	
	//Variables
	private Thread thread;
	private boolean running = false;
	private final double UPDATE_CAP = 1.0/60.0;

	//initialize gc do the following
	public GameContainer() {
		
	}
	
	public void start() {
		
		//setting the new thread
		thread = new Thread(this);
		thread.run();
	}
	
	public void stop() {
		
	}
	
	public void run() {
		
		//setting varables
		running = true;
		boolean render = false;
			//the doubles
		double fTime = 0;
		double lTime = System.nanoTime() / 1000000000.0; //thats 9 zeros (or should be)
		double pTime = 0;
		double uTime = 0;
		
		//when running
		while(running) {
			
			//sees the passing of time
			fTime = System.nanoTime() / 1000000000.0;
			pTime = fTime - lTime;
			lTime = fTime;
			
			uTime += pTime;
			
			while(uTime >= UPDATE_CAP) {
				
				uTime -= UPDATE_CAP;
				//render / update at a set framerate
				render = true;
				//TODO: update game
				
				if(render) {
					//TODO: update game
				}
				
				else {
					
					try {
						
						Thread.sleep(1);
					} 
					catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void dispose() {
		
	}
}
