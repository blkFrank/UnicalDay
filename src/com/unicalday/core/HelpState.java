package com.unicalday.core;



import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.unicalday.gui.Texture;
import com.unicalday.core.GameManager;

public class HelpState extends State  {

	

	private Texture tex=new Texture("HelpState");
	
	public HelpState() {  
		
		
	}
	
	@Override
	public void tick() {
		
    if (State.getKeyboardInput().isKey(KeyEvent.VK_ESCAPE)){
			
			State.setState(GameManager.getMenuState());
			
		}
		
	
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(tex.menuSheet[2], 0, 0, null);
		
	}
	
	


	



	

}