package com.unicalday.core;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import com.unicalday.gui.Button;
import com.unicalday.gui.Texture;


public class MenuState extends State {
	
	private final Button[] options;
	private int currentSelection = 0;
	
	private static State gameState;
	private State helpState;
	private static State Levelstate;
	private static State Editor;
	

	
	

	
	private Texture tex;
	
	public MenuState() {
		
		
		helpState=new HelpState();
		setLevelstate(new LevelState());
		
		
		
		tex = new Texture("Menu");

		options = new Button[4];
        options[0] = new Button("Play", 300 + 0 * 110, 
        		new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
        		Color.WHITE, Color.YELLOW, tex.menuSheet[1]);
        options[1] = new Button("Help", 300 + 1 * 110, 
        		new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
        		Color.WHITE, Color.YELLOW,  tex.menuSheet[1]);
        options[2] = new Button("Editor",300 + 2 * 110, 
        		new Font("Arial", Font.PLAIN, 32), new Font("Arial", Font.BOLD, 48),
        		Color.WHITE, Color.YELLOW,  tex.menuSheet[1]);
        options[3] = new Button("Exit", 300 + 3 * 110, 
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
	}
	
	private void select() {
		switch(currentSelection) {
		case 0: 
				System.out.println("Play");
				State.setState(getLevelstate());
				break;
		case 1: 
				System.out.println("HelpState");
				State.setState(helpState);
				break;
		case 2: 
				System.out.println("Editor");
				setEditor(new EditorState());
				break;
		case 3: 
				System.out.println("Exit");
				System.exit(0);
				break;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawImage(tex.menuSheet[0], 0, 0, null);

		
	
		for (int i = 0; i < options.length; i++) {
			if (i == currentSelection)
				options[i].setSelected(true);
			else
				options[i].setSelected(false);
		
			options[i].render(g);
		}
	}

	public static State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		MenuState.gameState = gameState;
	}

	public static State getEditor() {
		return Editor;
	}

	public void setEditor(State editor) {
		Editor = editor;
	}

	public static State getLevelstate() {
		return Levelstate;
	}

	public void setLevelstate(State levelstate) {
		Levelstate = levelstate;
	}



	

}
