package com.unicalday.core;

import java.awt.Graphics;

import com.unicalday.input.KeyboardInput;
import com.unicalday.input.MouseInput;

public abstract class State {

	private static KeyboardInput ki;
	private static MouseInput mi;	
	
	private static State currentState = null;
	
	public State() {
		ki = new KeyboardInput();
		mi = new MouseInput();
	}
	
	public static void setState(State state) {
		currentState = state;
		
	}
	
	public static KeyboardInput getKeyboardInput() { return ki; }
	public static MouseInput getMouseInput() { return mi; }
	
	public static State getState() { return currentState; }
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
