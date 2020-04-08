package com.unicalday.gui;
import com.unicalday.core.GameManager;
import com.unicalday.input.KeyboardInput;
import com.unicalday.input.MouseInput;


public class Window {
	
	private MyFrame frame;
	private MyPanel panel;
	
	public Window(String title, int width, int heigth, int scale, KeyboardInput ki, MouseInput mi, GameManager gm) {		
		frame = new MyFrame(title);
		
		panel = new MyPanel(width, heigth, scale, gm);
		panel.addKeyListener(ki);
		panel.addMouseListener(mi);
		panel.addMouseMotionListener(mi);
		panel.addMouseWheelListener(mi);
		
		frame.addContent(panel);		
		panel.makePanelFocusable();
		
		
		
	}
	
	
	
	public void addKey(KeyboardInput ki) {
		panel.addKeyListener(ki);
		panel.makePanelFocusable();
	}
	
	public void addMouse(MouseInput mi) {
		panel.addMouseListener(mi);
		panel.makePanelFocusable();
	}
	
	
	
	
	public MyFrame getFrame() { return frame; }	
	public MyPanel getPanel() { return panel; }
	
}