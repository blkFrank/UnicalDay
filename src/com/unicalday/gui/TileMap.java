package com.unicalday.gui;

import java.io.BufferedReader;
import java.io.FileReader;

import com.unicalday.core.Handler;
import com.unicalday.logic.abstrclass.Direction;
import com.unicalday.logic.abstrclass.ObjectID;
import com.unicalday.logic.entity.Block;
import com.unicalday.logic.entity.Player;

public class TileMap {
	
	private int tileSize;
	private int[][] map;
	private int mapWidth;
	private int mapHeight;
	private BufferedReader br;
	
	public TileMap(String s, int tileSize) {
		this.tileSize = tileSize;
		try {
			br = new BufferedReader(new FileReader(s));
			mapWidth = Integer.parseInt(br.readLine());
			mapHeight = Integer.parseInt(br.readLine());
			map = new int [mapHeight][mapWidth];
			
			String delimiters = " ";
			for (int row = 0; row < mapHeight; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delimiters);
				for (int col = 0; col < mapWidth; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int[][] getMap() { return map; }	
	public int getWidth() { return mapWidth; }
	public int getHeight() { return mapHeight; }
	
	public Player loadLevel(Handler handler, Player p) {
		for (int row = 0; row < mapHeight; row++) {
			for (int col = 0; col < mapWidth; col++) {
				int rc = map[row][col];
				//BLOCK 
				if (rc == 1 || rc==2 || rc==3 || rc==4 || rc==7 || rc==10 || rc==11) { 
					handler.addBlockObject(new Block(col * tileSize, row * tileSize, 128, 128, ObjectID.Block, rc));
				}
				
				//PLAYER
				if (rc == -1) {
					p = new Player(col * 84, row * 128, 84, 128, ObjectID.Player, Direction.IDLERIGHT);
				}
			}	
		}
		return p;
	}
	





}





