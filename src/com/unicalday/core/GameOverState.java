package com.unicalday.core;

import java.awt.Graphics;
import java.awt.event.KeyEvent;


import com.unicalday.core.GameManager;
import com.unicalday.core.GameState;

import com.unicalday.gui.Texture;


public class GameOverState extends State  {

	private Texture tex=new Texture("GameOver");
	
	
	
	public GameOverState() { 
		
		
		
		
	}
	
	
		
	
	
	@Override
	public void tick() {
		
		
		
		
			
			if (State.getKeyboardInput().isKey(KeyEvent.VK_ESCAPE)){
				
			    
				State.setState(GameManager.getMenuState());
				
			}
			
			
			
		}
	
	

	@Override
	public void render(Graphics g) {
		
		
		g.drawImage(tex.menuSheet[3], 0, 0, null);
		
	}
	
	


	



	

}
