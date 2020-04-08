package com.unicalday.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.unicalday.core.GameConfig;

public class MouseInput implements MouseListener, MouseMotionListener, MouseWheelListener {

	private int mouseX, mouseY;
	private int scroll;
	
	private final int NUM_BUTTONS = 5;
	private boolean[] buttons = new boolean[NUM_BUTTONS];
	private boolean[] buttonsLast = new boolean[NUM_BUTTONS];
	
	
	public MouseInput() {
		mouseX = 0;
		mouseY = 0;
		scroll = 0;
	}
	
	public void tick() {
		scroll = 0;
		for (int i = 0; i < NUM_BUTTONS; i++) {
			buttonsLast[i] = buttons[i];
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = (int)(e.getX() / GameConfig.SCALE);
		mouseY = (int)(e.getY() / GameConfig.SCALE);		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();

	}
	
	public boolean isButton(int buttonCode) {
		return buttons[buttonCode];
	}
	
	public boolean isButtonUp(int buttonCode) {
		return !buttons[buttonCode] && buttonsLast[buttonCode];
	}
	
	public boolean isButtonDown(int buttonCode) {
		return buttons[buttonCode] && !buttonsLast[buttonCode];
	}
	
	
	public int getX() {
		return mouseX;
	}

	public int getY() {
		return mouseY;
	}

	public int getScroll() {
		return scroll;
	}
}
