package com.unicalday.core;

import com.unicalday.logic.entity.Player;


public class Camera {
	
	private float x;
	private float y;
	
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() { return x; }
	public float getY() { return y; }
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }

	public void tick(Player player) {
		x = (GameConfig.HEIGHT * GameConfig.SCALE) / 2 - player.getX() + GameConfig.SCALE * 50 -500 ;
		y = (GameConfig.WIDTH * GameConfig.SCALE) / 2 - player.getY() - (GameConfig.WIDTH * 2) +100 ;
	}
	
}