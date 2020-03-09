package com.amath.game;

import java.awt.event.KeyEvent;

import com.amath.engine.AbstractGame;
import com.amath.engine.GameContainer;
import com.amath.engine.Render;

public class GameManager extends AbstractGame{

	public GameManager() {
		
	}
	
	@Override
	//updates every frame
	public void update(GameContainer gc, float deltaTime) {
		
	}

	@Override
	public void render(GameContainer gc, Render r) {
		
	}
	
	public static void main(String args[]) {
		
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
}
