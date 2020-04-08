package com.unicalday.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardInput implements KeyListener {

	private final int NUM_KEYS = 256;
	private boolean[] keys = new boolean[NUM_KEYS];
	private boolean[] keysLast = new boolean[NUM_KEYS];
	
	public KeyboardInput() {
		for (int i = 0; i < NUM_KEYS; i++) {
			keys[i] = false;
			keysLast[i] = false;
		}
	}

	public void tick() {
		for (int i = 0; i < NUM_KEYS; i++) {
			keysLast[i] = keys[i];
		}
//		for (int i = 0; i < NUM_BUTTONS; i++) {
//			buttonsLast[i] = buttons[i];
//		}
	}
	
	public boolean isKey(int keyCode) { return keys[keyCode]; }
	
	public boolean isKeyUp(int keyCode) {
		return !keys[keyCode] && keysLast[keyCode];
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode] && !keysLast[keyCode];
	}
	
	
//	public boolean isButton(int buttonCode) {
//		return buttons[buttonCode];
//	}
//	
//	public boolean isButtonUp(int buttonCode) {
//		return !buttons[buttonCode] && buttonsLast[buttonCode];
//	}
//	
//	public boolean isButtonDown(int buttonCode) {
//		return buttons[buttonCode] && !buttonsLast[buttonCode];
//	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() >= 0 && e.getKeyCode() <= 256) {
			keys[e.getKeyCode()] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() >= 0 && e.getKeyCode() <= 256) {
			keys[e.getKeyCode()] = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) { }
	
}