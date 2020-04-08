package com.unicalday.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import com.unicalday.audio.AudioPlayer;
import com.unicalday.core.GameManager;
import com.unicalday.core.GameState;
import com.unicalday.core.LevelState;
import com.unicalday.core.State;




public class MyPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	GameManager gm;
	private Font font;
	private AudioPlayer bgMusic;
	
	public MyPanel(int width, int height, int scale, GameManager gm) {
		this.gm = gm;
		Dimension s = new Dimension((int)width * scale, (int) height * scale);
		font = new Font("Comic Sans Ms",Font.BOLD, 30);
		setBgMusic(new AudioPlayer("/SoundEffects/bgmusic.mp3"));
		getBgMusic().play();
		this.setPreferredSize(s);
		this.setMaximumSize(s);
		this.setMinimumSize(s);
		
	}
	

	
	
	public void makePanelFocusable() {
		this.setFocusable(true);
        this.requestFocusInWindow();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bgImage = Toolkit.getDefaultToolkit().createImage("back.jpeg");
        g.drawImage(bgImage, 0, 0, null);
		gm.render(g);
		if(State.getState()==LevelState.gameState1 || State.getState()==LevelState.gameState2 ||State.getState()==LevelState.gameState3  ) {
			g.setFont(font);
			g.setColor(Color.RED);
			String cfu=String.valueOf(GameState.cfuCounter).toString();
			  g.drawString("CFU :  /4", 550, 50);
		      g.drawString(cfu, 640, 50);
		}
		
		
		
		
	}

	public AudioPlayer getBgMusic() {
		return bgMusic;
	}

	public void setBgMusic(AudioPlayer bgMusic) {
		this.bgMusic = bgMusic;
	}
	
}
