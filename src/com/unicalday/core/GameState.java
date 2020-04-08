package com.unicalday.core;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import com.unicalday.gui.Animation;
import com.unicalday.audio.AudioPlayer;

import com.unicalday.gui.Texture;
import com.unicalday.gui.TileMap;
import com.unicalday.logic.abstrclass.Direction;
import com.unicalday.logic.entity.Player;

public class GameState extends State {
		
	private Texture tex;
	
	
	private Animation playerIdleRight;
	private Animation playerIdleLeft;
	private Animation playerWalkRight;
	private Animation playerWalkLeft;
	private Animation playerJumpRight;
	private Animation playerJumpLeft;
	
	
	public static int cfuCounter;
	private Animation cfu;
	
	private TileMap tileMap;
	private Handler handler;

	private Player player;
	
	private Camera camera;

	private static AudioPlayer bgMusic;
	private AudioPlayer sfx;
	
	private String levelPath;
	
	public GameState(String path) {
		
		levelPath = path;
		
		//CREO LE TEXTURE
		tex = new Texture("Game");
		
		
		//CREO LE ANIMATIONS
		playerIdleRight = new Animation(3, tex.playerIdle[0],tex.playerIdle[1],tex.playerIdle[2],tex.playerIdle[3],tex.playerIdle[4],tex.playerIdle[5],tex.playerIdle[6],tex.playerIdle[7]);
		playerIdleLeft = new Animation(3, tex.playerIdle[8],tex.playerIdle[9],tex.playerIdle[10],tex.playerIdle[11],tex.playerIdle[12],tex.playerIdle[13],tex.playerIdle[14]);
		
		playerWalkRight = new Animation(3, tex.playerWalk[0], tex.playerWalk[1], tex.playerWalk[2], tex.playerWalk[3], tex.playerWalk[4], tex.playerWalk[5], tex.playerWalk[6]);
		playerWalkLeft = new Animation(3, tex.playerWalk[7], tex.playerWalk[8], tex.playerWalk[9], tex.playerWalk[10], tex.playerWalk[11], tex.playerWalk[12],  tex.playerWalk[13]);
		
		playerJumpRight = new Animation(6, tex.playerJump[0], tex.playerJump[1]);
		playerJumpLeft = new Animation(6, tex.playerJump[2], tex.playerJump[3]);
		
		 

		cfu = new Animation(5, tex.cfu[0], tex.cfu[1], tex.cfu[2]);
		
		
		tileMap = new TileMap(levelPath, 128);
		handler = new Handler();
		player = tileMap.loadLevel(handler, player);

		handler.setPlayer(player);
		
		
		sfx=new AudioPlayer("/SoundEffects/jump.wav");
		
		camera = new Camera(player.getX(), player.getY());
		
	
			

	}

	@Override
	public void tick() {
		
		
		playerIdleRight.runAnimnation();
		playerIdleLeft.runAnimnation();
		playerWalkRight.runAnimnation();
		playerWalkLeft.runAnimnation();
		playerJumpRight.runAnimnation();
		playerJumpLeft.runAnimnation();
	
		
		
		cfu.runAnimnation();
	    
		camera.tick(player);
		
	    
		handler.tick();
		
		//COMANDI DA TASTIERA
		if (State.getKeyboardInput().isKey(KeyEvent.VK_RIGHT) ) {
			player.setVelX(5);
		}
		else if (State.getKeyboardInput().isKey(KeyEvent.VK_LEFT)) {
			player.setVelX(-5);
		}
		else {
			player.setVelX(0);
		}
		if (State.getKeyboardInput().isKey(KeyEvent.VK_UP) && !player.isJumping() && player.getVelY() == 0)
		{
			sfx.play();
			player.setJumping(true);
			player.setVelY(-10);
		}
	}
	
	@Override
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(camera.getX(), camera.getY());
		;
		
		//RENDER DEI BLOCK
			boolean blockRender = false;
			if (blockRender == false) {
				for (int row = 0; row < tileMap.getHeight(); row++) {
					for (int col = 0; col < tileMap.getWidth(); col++) {
						int rc = tileMap.getMap()[row][col];
						if (rc == 1 ) {
							g.drawImage(tex.getBlock(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 3 ) {
							g.drawImage(tex.getBlock3(), col * 128, row * 128, 130, 130, null); 
						}
						if (rc == 4 ) {
							g.drawImage(tex.getBlock4(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 0   ) {
							g.drawImage(tex.getSky(), col * 128, row * 128, 130, 130, null); 
						}
						if (rc == 5 ) {
							g.drawImage(tex.getCloud(), col * 128, row * 128, 129, 129, null); 
						}
						if (rc == 6 ) {
							g.drawImage(tex.getRail(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 7 ) {
							g.drawImage(tex.getGameOver(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 8 ) {
							g.drawImage(tex.getCube(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 9 ) {
							g.drawImage(tex.getUnical(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 10 ) {
							g.drawImage(tex.getCfuBLock(), col * 128, row * 128, 128, 128, null); 
						}
						if (rc == 11 ) {
							g.drawImage(tex.getWin(), col * 128, row * 128, 128, 128, null); 
						}
						
						
						
					}
				}
				blockRender = true;
			}
		
			
				//RENDER DEL PLAYER
			
			if (player.isJumping() == true) {
				if (player.getDirection() == Direction.IDLERIGHT)
					playerJumpRight.drawAnimation(g, (int) player.getX(), (int) player.getY());
				else if (player.getDirection() == Direction.IDLELEFT)
					playerJumpLeft.drawAnimation(g, (int) player.getX(), (int) player.getY());
			}	
			else {
				if (player.getVelX() != 0) {
					if (player.getDirection() == Direction.IDLERIGHT)
						playerWalkRight.drawAnimation(g, (int) player.getX(), (int) player.getY());
					else
						playerWalkLeft.drawAnimation(g, (int) player.getX(), (int) player.getY());
				}
				else {
					if (player.getDirection() == Direction.IDLERIGHT)
						playerIdleRight.drawAnimation(g, (int) player.getX(), (int) player.getY());
					else if (player.getDirection() == Direction.IDLELEFT)
						playerIdleLeft.drawAnimation(g, (int) player.getX(), (int) player.getY());
				}	
			}
		
			//g.drawRect((int)player.getX(), (int) player.getY(), 84, 128);
			
			
			
		
			
			
			
			
		g2d.translate(-camera.getX(),-camera.getY());
	}

	public static AudioPlayer getBgMusic() {
		return bgMusic;
	}

	public void setBgMusic(AudioPlayer bgMusic) {
		GameState.bgMusic = bgMusic;
	}
	
}
