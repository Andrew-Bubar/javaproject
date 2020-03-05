package com.amath.engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener{

	private GameContainer gc;
	
	//vars
	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keysLast = new boolean[NUM_KEYS];
	
	private final int NUM_BUTTONS = 5;
	private boolean[] buttons = new boolean[NUM_BUTTONS];
	private boolean[] buttonsLast = new boolean[NUM_BUTTONS];
	
	private int mX, mY;
	private int mS;
	
	// the 'void start'
	public Input(GameContainer gc) {
		
		this.gc = gc;
		mX = 0;
		mY = 0;
		mS = 0;
		
		gc.getWin().getCanvas().addKeyListener(this);
		gc.getWin().getCanvas().addMouseMotionListener(this);
		gc.getWin().getCanvas().addMouseListener(this);
		gc.getWin().getCanvas().addMouseWheelListener(this);
	}
	
	void update() {
		
		mS = 0;
		
		for(int i = 0; i < NUM_KEYS; i++) {
			keysLast[i] = keys[i];
		}
		
		for(int i = 0; i < NUM_BUTTONS; i++) {
			buttonsLast[i] = buttons[i];
		}
	}

	//setting up the keys
	public boolean isKey(int keyCode) {
		
		return keys[keyCode];
	}
	
	public boolean isKeyUp(int keyCode) {
		
		return keys[keyCode] && keysLast[keyCode];
	}
	
	public boolean isKeyDown(int keyCode) {
		
		return keys[keyCode] && !keysLast[keyCode];
	}
	
	//setting up the buttons
	public boolean isButton(int button) {
		
		return buttons[button];
	}
	
	public boolean isButtonUp(int button) {
		
		return buttons[button] && keysLast[button];
	}
	
	public boolean isButtonDown(int button) {
		
		return keys[button] && !keysLast[button];
	}
	
	//the inputs
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		mS = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mX = (int)(e.getX() / gc.getScale());
		mY = (int)(e.getY() / gc.getScale());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mX = (int)(e.getX() / gc.getScale());
		mY = (int)(e.getY() / gc.getScale());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = false;
	}

	public int getmX() {
		return mX;
	}

	public int getmY() {
		return mY;
	}

	public int getmS() {
		return mS;
	}
	
}
