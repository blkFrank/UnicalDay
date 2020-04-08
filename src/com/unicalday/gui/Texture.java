package com.unicalday.gui;

import java.awt.image.BufferedImage;



public class Texture {
	
	SpriteSheet ps, bs, es, cs, ms;
	
	public BufferedImage[] menuSheet = new BufferedImage[6];
	private BufferedImage coinSheet = null;
	private BufferedImage block= null;
	private BufferedImage block3=null;
	private BufferedImage block4=null;
	private BufferedImage sky=null;
	private BufferedImage cloud=null;
	private BufferedImage rail=null;
	private BufferedImage gameOver=null;
	private BufferedImage cube=null;
	private BufferedImage unical=null;
	private BufferedImage cfuBLock=null;
	private BufferedImage Win=null;
	
	
	
	public BufferedImage[] playerIdle = new BufferedImage[15];
	
	public BufferedImage[] cfu = new BufferedImage[3];
	public BufferedImage[] playerWalk = new BufferedImage[14];
	public BufferedImage[] playerJump = new BufferedImage[4];

	
	BufferedImageLoader loader = new BufferedImageLoader();
	
	public Texture(String id) {
		
        
           if (id == "Win") {
			
			try {
				
				menuSheet[4] = loader.loadBufferedImage("/Winback.png");
				
				

			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}  
		
		
		
		
		
		if (id == "GameOver") {
			
			try {
				
				menuSheet[3] = loader.loadBufferedImage("/gameOver.png");
				
				

			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}  
		
		
		if (id == "HelpState") {
			
			try {
				
				menuSheet[2] = loader.loadBufferedImage("/Help.jpg");
				
				

			}
			catch(Exception e) {
				e.printStackTrace();
			}
			getHelpTextures();
		}
		
		if (id == "Menu") {
			
			try {
				menuSheet[0] = loader.loadBufferedImage("/menubg.png");
				menuSheet[1] = loader.loadBufferedImage("/button.png");
				menuSheet[5] = loader.loadBufferedImage("/back.jpeg");
				
				
				
				

			}
			catch(Exception e) {
				e.printStackTrace();
			}
			getMenuTextures();
		}
		else {	
			try {

				setBlock(loader.loadBufferedImage("/Block/block_sheet.jpg"));
                setBlock3(loader.loadBufferedImage("/Block/block3.png"));
				setBlock4(loader.loadBufferedImage("/Block/block4.jpg"));
				setSky(loader.loadBufferedImage("/Block/sky.png"));
				setCloud(loader.loadBufferedImage("/Block/cloud.png"));
				setRail(loader.loadBufferedImage("/Block/rail.png"));
				setGameOver(loader.loadBufferedImage("/Block/sky.png"));
				setCube(loader.loadBufferedImage("/Block/cube.png"));
				setUnical(loader.loadBufferedImage("/Block/unical.png"));
				setCfuBLock(loader.loadBufferedImage("/Cfu/c2.png"));
				setWin(loader.loadBufferedImage("/Block/win.png"));
				
				
				
				
				
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			cs = new SpriteSheet(coinSheet);
			
			
		
			getGameTextures();
		}
	}
	private void getHelpTextures() {
		
		
	}
	private void getMenuTextures() {

	}

	private void getGameTextures() {
		//IDLERIGHT
		playerIdle[0] = loader.loadBufferedImage("/Idle/idle1.png");
		playerIdle[1] = loader.loadBufferedImage("/Idle/idle2.png");
		playerIdle[2] = loader.loadBufferedImage("/Idle/idle3.png");
		playerIdle[3] = loader.loadBufferedImage("/Idle/idle4.png");
		playerIdle[4] = loader.loadBufferedImage("/Idle/idle5.png");
		playerIdle[5] = loader.loadBufferedImage("/Idle/idle6.png");
		playerIdle[6] = loader.loadBufferedImage("/Idle/idle7.png");
		playerIdle[7] = loader.loadBufferedImage("/Idle/idle8.png");
		
	    //IDLELEFT
		playerIdle[8] = loader.loadBufferedImage("/Idle/idle9.png");
		playerIdle[9] = loader.loadBufferedImage("/Idle/idle10.png");
		playerIdle[10] = loader.loadBufferedImage("/Idle/idle11.png");
		playerIdle[11] = loader.loadBufferedImage("/Idle/idle12.png");
		playerIdle[12] = loader.loadBufferedImage("/Idle/idle13.png");
		playerIdle[13] = loader.loadBufferedImage("/Idle/idle14.png");
		playerIdle[14] = loader.loadBufferedImage("/Idle/idle15.png");
		
		
		//RIGHT
		playerWalk[0] = loader.loadBufferedImage("/WalkRight/R1.png");
		playerWalk[1] = loader.loadBufferedImage("/WalkRight/R2.png");
		playerWalk[2] = loader.loadBufferedImage("/WalkRight/R3.png");
		playerWalk[3] = loader.loadBufferedImage("/WalkRight/R4.png");
		playerWalk[4] = loader.loadBufferedImage("/WalkRight/R5.png");
		playerWalk[5] = loader.loadBufferedImage("/WalkRight/R6.png");
		playerWalk[6] = loader.loadBufferedImage("/WalkRight/R7.png");
		 
		
		//LEFT
		playerWalk[7] =loader.loadBufferedImage("/WalkLeft/S1.png");
		playerWalk[8] =loader.loadBufferedImage("/WalkLeft/S2.png");
		playerWalk[9] =loader.loadBufferedImage("/WalkLeft/S3.png");
		playerWalk[10] =loader.loadBufferedImage("/WalkLeft/S4.png"); 
		playerWalk[11] = loader.loadBufferedImage("/WalkLeft/S5.png");
		playerWalk[12] = loader.loadBufferedImage("/WalkLeft/S6.png");
		playerWalk[13] = loader.loadBufferedImage("/WalkLeft/S7.png");
		 
		 
		//JUMPRIGHT
		playerJump[0] = loader.loadBufferedImage("/JumpRight/JR1.png");
		playerJump[1] = loader.loadBufferedImage("/JumpRight/JR2.png");
		
		
		//JUMPLEFT
		playerJump[2] = loader.loadBufferedImage("/JumpLeft/JS1.png");
		playerJump[3] = loader.loadBufferedImage("/JumpLeft/JS2.png");
		
			
	}

	public BufferedImage getBlock() {
		return block;
	}

	public void setBlock(BufferedImage block) {
		this.block = block;
	}
	public BufferedImage getBlock3() {
		return block3;
	}
	public void setBlock3(BufferedImage block3) {
		this.block3 = block3;
	}
	public BufferedImage getBlock4() {
		return block4;
	}
	public void setBlock4(BufferedImage block4) {
		this.block4 = block4;
	}
	public BufferedImage getSky() {
		return sky;
	}
	public void setSky(BufferedImage sky) {
		this.sky = sky;
	}
	public BufferedImage getCloud() {
		return cloud;
	}
	public void setCloud(BufferedImage nuvola) {
		this.cloud = nuvola;
	}
	public BufferedImage getRail() {
		return rail;
	}
	public void setRail(BufferedImage rail) {
		this.rail = rail;
	}
	public BufferedImage getGameOver() {
		return gameOver;
	}
	public void setGameOver(BufferedImage gameOver) {
		this.gameOver = gameOver;
	}
	public BufferedImage getCube() {
		return cube;
	}
	public void setCube(BufferedImage cube) {
		this.cube = cube;
	}
	public BufferedImage getUnical() {
		return unical;
	}
	public void setUnical(BufferedImage unical) {
		this.unical = unical;
	}
	public BufferedImage getCfuBLock() {
		return cfuBLock;
	}
	public void setCfuBLock(BufferedImage cfuBLock) {
		this.cfuBLock = cfuBLock;
	}
	public BufferedImage getWin() {
		return Win;
	}
	public void setWin(BufferedImage win) {
		Win = win;
	}
	

	
	
}
