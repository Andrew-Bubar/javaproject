package com.amath.engine;

import java.awt.image.DataBufferInt;

public class Render {
	
	//vars
	private int pW, pH;
	private int[] p;

	public Render(GameContainer gc){
		
		//settings the vars
		pW = gc.getWidth();
		pH = gc.getHeight();
			//gather data from the windows to use in the rendering
		p = ((DataBufferInt)gc.getWin().getImage().getRaster().getDataBuffer()).getData();
	}
	
	//remove all rendered stuff
	public void clear() {
		
		//checking for every process in the screen
		for(int i = 0; i < p.length; i++) {
			
			p[i] += 0;
		}
	}
}
