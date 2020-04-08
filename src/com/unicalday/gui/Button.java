package com.unicalday.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.unicalday.core.GameConfig;


@SuppressWarnings("serial")
public class Button extends Rectangle {
	
	private Font font, selectedFont;
	private Color color, selectedColor;
	private boolean selected;
	private String text;
	private int textY;
	private BufferedImage image;
	
	public Button(String text, int textY, Font font, Font selectedFont,  Color color, Color selectedColor, BufferedImage img) {
		this.text = text;
		this.textY = textY;
		this.font = font;
		this.selectedFont = selectedFont;
		this.color = color;
		this.selectedColor = selectedColor;
		this.image = img;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void render(Graphics g) {
		@SuppressWarnings("unused")
		FontMetrics fm = g.getFontMetrics();
		this.x = (GameConfig.WIDTH * GameConfig.SCALE) / 2 - 138;
		this.y = textY;
		this.width = 276;
		this.height = 100;
		
		g.drawImage(image, x, y, null);
		
		if (selected)
			Fonts.drawString(g, selectedFont, selectedColor, text, textY + 75);
		else
			Fonts.drawString(g, font, color, text, textY + 75);
		
		
	//g.drawRect(x, y, width, height);
	}
	
}
