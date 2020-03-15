package com.amath.game;

import com.amath.engine.AbstractGame;
import com.amath.engine.GameContainer;
import com.amath.engine.Render;
import com.amath.engine.gfx.Image;

public class GameManager extends AbstractGame {
	
	//varables
	private Image img;

	public GameManager() {

		img = new Image("/test.PNG");
	}

	@Override
	// updates every frame
	public void update(GameContainer gc, float deltaTime) {

	}

	@Override
	public void render(GameContainer gc, Render r) {

		r.drawImage(
				img, gc.getInput().getmX(), gc.getInput().getmY()
				);
	}

	public static void main(String args[]) {

		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}
}
