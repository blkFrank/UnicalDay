package com.unicalday.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import com.unicalday.core.GameConfig;

public class Fonts {

	
	public static void drawString(Graphics g, Font f, Color c, String text, int x, int y) {
		g.setColor(c);
		g.setFont(f);
		g.drawString(text, x, y);
	}
	
	public static void drawString(Graphics g, Font f, Color c, String text) {
		FontMetrics fm = g.getFontMetrics(f); 
		int x = (GameConfig.WIDTH * GameConfig.SCALE) - fm.stringWidth(text) / 2;
		int y = (((GameConfig.HEIGHT * GameConfig.SCALE) - fm.getHeight()) / 2) + fm.getAscent();
		drawString(g, f, c, text, x, y);
		
	}

	public static void drawString(Graphics g, Font f, Color c, String text, double x) {
		FontMetrics fm = g.getFontMetrics(f); 
		int y = (((GameConfig.HEIGHT * GameConfig.SCALE) - fm.getHeight()) / 2) + fm.getAscent();
		drawString(g, f, c, text, y);
		
	}
	
	public static void drawString(Graphics g, Font f, Color c, String text, int y) {
		FontMetrics fm = g.getFontMetrics(f); 
		int x = (GameConfig.HEIGHT + 620) - fm.stringWidth(text) / 2;
		drawString(g, f, c, text, x, y);
		
	}
	
}