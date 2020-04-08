package com.unicalday.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.unicalday.gui.Button;
import com.unicalday.gui.Texture;

public class LevelState extends State {
	
	private final Button[] options;
	private int currentSelection = 0;
	
	public static State gameState1;
	public static State gameState2;
	public static State gameState3;

	
	

	
	private Texture tex;
	
	public LevelState() {
		
		gameState1=new GameState("level1.txt");
		gameState2=new GameState("level2.txt");
		gameState3=new GameState("level3.txt");
		
		
	
		
		
		tex = new Texture("Menu");

		options = new Button[3];
        options[0] = new Button("LEVEL 1", 50 + 0 * 110, 
        		new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
        		Color.WHITE, Color.YELLOW, tex.menuSheet[1]);
        options[1] = new Button("LEVEL2", 80 + 1 * 110, 
        		new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
        		Color.WHITE, Color.YELLOW,  tex.menuSheet[1]);
        options[2] = new Button("LEVEL3",300 + 2 * 110, 
        		new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
        		Color.WHITE, Color.YELLOW,  tex.menuSheet[1]);
       
	}
	
	@Override
	public void tick() {
		boolean clicked = false;
		for (int i = 0; i < options.length; i++) {
			if (options[i].intersects(new Rectangle(State.getMouseInput().getX(), State.getMouseInput().getY(), 10, 10))) {
				currentSelection = i;
				clicked = State.getMouseInput().isButton(MouseEvent.BUTTON1);
			}
		}
		
		if (clicked)
			select();
		
        if (State.getKeyboardInput().isKey(KeyEvent.VK_ESCAPE)){
			
			State.setState(GameManager.getMenuState());
			
		}
	}
	
	private void select() {
		switch(currentSelection) {
		case 0: 
				System.out.println("Level1");
				GameState.cfuCounter=0;
				State.setState(gameState1);
				break;
		case 1: 
				System.out.println("Level2");
				GameState.cfuCounter=0;
				State.setState(gameState2);
				break;
		case 2: 
				System.out.println("Level3");
				GameState.cfuCounter=0;
				State.setState(gameState3);
				break;
		
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(tex.menuSheet[5], 0, 0, null);

		
	
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection)
				options[i].setSelected(true);
			else
				options[i].setSelected(false);
		
			options[i].render(g);
		}
	}

	

	

}
