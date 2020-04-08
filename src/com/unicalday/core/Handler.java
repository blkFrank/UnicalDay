package com.unicalday.core;

import java.awt.Graphics;
import java.util.LinkedList;

import com.unicalday.audio.AudioPlayer;
import com.unicalday.logic.abstrclass.AbstractStaticObject;


import com.unicalday.logic.entity.Player;

public class Handler {
	
	private AudioPlayer cfx; 
	
	//BLOCK
	public LinkedList<AbstractStaticObject> blockList = new LinkedList<AbstractStaticObject>();
	
	
	//PLAYER
	private Player player;
	private State GameOver=new GameOverState();
	private State Win=new WinState();
	
	private AudioPlayer gameOver=new AudioPlayer("/SoundEffects/gameover.wav");
	private AudioPlayer winSound=new AudioPlayer("/SoundEffects/winsound.wav");
	
	
    public Handler() { }
	
	public LinkedList<AbstractStaticObject> getBlockList() { return blockList; }
	
	
	public void setPlayer(Player player) { player.restorePosition(); this.player = player;  }
	
	public void tick() {
		
		cfx=new AudioPlayer("/SoundEffects/coinsound.wav");
		
		player.tick();
		
		//COLLISIONE DEL PLAYER CON I BLOCK
		for(int i = 0; i < blockList.size(); i++) {					
			
			if(blockList.get(i).getCode()!=0 && blockList.get(i).getCode()!=6 && blockList.get(i).getCode()!=5 && blockList.get(i).getCode()!=7 && blockList.get(i).getCode()!=8 && blockList.get(i).getCode()!=9 && blockList.get(i).getCode()!=10 && blockList.get(i).getCode()!=11 ) {
			
				if (player.getBounds().intersects(blockList.get(i).getBounds())) {
						player.setY(blockList.get(i).getY() - player.getHeight());
						player.setVelY(0);
						player.setFalling(false);
						player.setJumping(false);
				}
					else {
						player.setFalling(true); 
						}
					if (player.getBoundsTop().intersects(blockList.get(i).getBounds())) {
						player.setY(blockList.get(i).getY() + blockList.get(i).getHeight());
						player.setVelY(0);
				
					}
					if (player.getBoundsRight().intersects(blockList.get(i).getBounds())) {
						player.setX(blockList.get(i).getX() - player.getWidth());
					}
					if (player.getBoundsLeft().intersects(blockList.get(i).getBounds())) {
						player.setX(blockList.get(i).getX() + blockList.get(i).getWidth() + 3);
					}
					
				
			}
			
		
			if(blockList.get(i).getCode()==7)
			{
				if (player.getBounds().intersects(blockList.get(i).getBounds())) {
					player.restorePosition();
					State.setState(GameOver);
					gameOver.play();
			}
				else {
					player.setFalling(true); 
					}
				if (player.getBoundsTop().intersects(blockList.get(i).getBounds())) {
					player.restorePosition();
					State.setState(GameOver);
					
					gameOver.play();
			
				}
				if (player.getBoundsRight().intersects(blockList.get(i).getBounds())) {
					player.restorePosition();
					State.setState(GameOver);
					gameOver.play();
				}
				if (player.getBoundsLeft().intersects(blockList.get(i).getBounds())) {
					player.restorePosition();
					State.setState(GameOver);
					gameOver.play();
				}
				
			}
			if(blockList.get(i).getCode()==10)
			{
				if (player.getBounds().intersects(blockList.get(i).getBounds())) {
					
					removeBlockObject(blockList.get(i));
					cfx.play();
					GameState.cfuCounter++;
			}
			else {
					player.setFalling(true); 
					}
			if (player.getBoundsTop().intersects(blockList.get(i).getBounds())) {
					removeBlockObject(blockList.get(i));
					removeBlockObject(blockList.get(i));
					cfx.play();
					GameState.cfuCounter++;
			
				}
				if (player.getBoundsRight().intersects(blockList.get(i).getBounds())) {
					
					removeBlockObject(blockList.get(i));
					cfx.play();
					GameState.cfuCounter++;
				}
				if (player.getBoundsLeft().intersects(blockList.get(i).getBounds())) {
					
					removeBlockObject(blockList.get(i));
					cfx.play();
					GameState.cfuCounter++;
				}
				
			}
				
				
				if(blockList.get(i).getCode()==11)
				{
					if (player.getBounds().intersects(blockList.get(i).getBounds())) {
						
						if(GameState.cfuCounter==4) {
						player.restorePosition();
						State.setState(Win);
						winSound.play();}
				}
					else {
						player.setFalling(true); 
						}
					if (player.getBoundsTop().intersects(blockList.get(i).getBounds())) {
						
						if(GameState.cfuCounter==4) {
							player.restorePosition();
							State.setState(Win);
							winSound.play();}
				
					}
					if (player.getBoundsRight().intersects(blockList.get(i).getBounds())) {
						
						if(GameState.cfuCounter==4) {
							player.restorePosition();
							State.setState(Win);
							winSound.play();}
					}
					if (player.getBoundsLeft().intersects(blockList.get(i).getBounds())) {
						
						if(GameState.cfuCounter==4) {
							player.restorePosition();
							State.setState(Win);
							winSound.play();}
					}
					
				}
				
			}
		
	
	
	
	
	
}
			
		
		
		
		
		
	
	
	
	
	
	

	public void render(Graphics g) {
		
		
		
		
			
	
		}
		
	public void addBlockObject(AbstractStaticObject object) {
		this.blockList.add(object);
	}
	

	public void removeBlockObject(AbstractStaticObject object) {
		this.blockList.remove(object);
		
	}
	

	
	
	

	
	
	
}
