package com.unicalday.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import javax.swing.JPanel;

import com.unicalday.gui.BufferedImageLoader;

public class PreviewPanel extends JPanel implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	
	private static int height = 480;
	private static int width = 3040;
	private Vector<ColoredPoint> points = new Vector<ColoredPoint>();
	private Color paintColor = Color.yellow;
	
	private int [][] grid = new int[height/32][width/32];
	
	private BufferedImageLoader loader = new BufferedImageLoader();
	private BufferedImage b1Image = loader.loadBufferedImage("/Block/block_sheet.jpg");
	private BufferedImage b2Image = loader.loadBufferedImage("/Block/block3.png");
	private BufferedImage b3Image = loader.loadBufferedImage("/Cfu/c2.png");
	private BufferedImage b4Image = loader.loadBufferedImage("/Block/sky.png");
	public BufferedImage paintImage = b1Image;
	
	public PreviewPanel(){
		super();

		for (int i=0; i<15; i++) {
			for(int j=0; j<95; j++) {
				if (i<12)
					grid[i][j] = 0;
				else
					grid[i][j] = 1;
			}
		}
		
							
	
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}

	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		for(int i = 0; i < 14*32; i=i+32)
			for (int j=0; j < 94*32; j=j+32)
				g.drawImage(getB4Image(), j*32, i*32, null);
		
		for(int i = 12*32; i < height-32; i=i+32)
			for (int j=0; j<width-32; j=j+32)
				g.drawImage(getB1Image(), j*32, i*32, null);
							
	
		
		for(int i = 0; i < points.size();i++){
			ColoredPoint tmp = points.get(i);
			//g.setColor(tmp.getColor());
			//g.fillRect(tmp.getPoint().x*32, tmp.getPoint().y*32, 32, 32);
			g.drawImage(tmp.getImage(), tmp.getPoint().x*32, tmp.getPoint().y*32, 32, 32, null);
		}
		
	}

	public void mouseDragged(MouseEvent e) {
		mousePressed(e);
	}
	
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Point p = clickToGrid(x,y);
		ColoredPoint cp = new ColoredPoint(p,paintColor, paintImage);
		removeDuplicate(p);
		points.add(cp);
		repaint();
		System.out.println("Size: "+points.size());
		if (paintImage == b1Image)
			grid[(int) p.getY()][(int) p.getX()] = 1;
		else if (paintImage == b2Image)
			grid[(int) p.getY()][(int) p.getX()] = 3;
		else if (paintImage == b3Image)
			grid[(int) p.getY()][(int) p.getX()] = 10;
		else if (paintImage == b4Image)
			grid[(int) p.getY()][(int) p.getX()] = 0;
	}
	
	private Point clickToGrid(int x, int y){
		int px = x ;
		int py = y ;
		px = px / 32;
		py = py / 32;
		//System.out.println("Grid coord --- x: "+px+" y: "+py);
		return new Point(px,py);
	}
	
	private void removeDuplicate(Point p){
		for(int i = 0; i < points.size();i++){
			ColoredPoint tmp = points.get(i);
			if (tmp.getPoint().equals(p)){
				points.remove(i);
				return;
			}
		}
	}
	
	public void setPaintColor(Color color){
		this.paintColor = color;
	}
	
	
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {		
	}

	public void mouseEntered(MouseEvent e) {		
	}

	public void mouseExited(MouseEvent e) {
	}


	public int[][] getGrid() {
		return grid;
	}


	public void setGridEl(int x, int y, int el) {
		this.grid[x][y] = el;
	}


	public BufferedImage getB1Image() {
		return b1Image;
	}


	public void setB1Image(BufferedImage b1Image) {
		this.b1Image = b1Image;
	}


	public BufferedImage getB2Image() {
		return b2Image;
	}


	public void setB2Image(BufferedImage b2Image) {
		this.b2Image = b2Image;
	}


	public BufferedImage getB3Image() {
		return b3Image;
	}


	public void setB3Image(BufferedImage b3Image) {
		this.b3Image = b3Image;
	}


	public BufferedImage getB4Image() {
		return b4Image;
	}


	public void setB4Image(BufferedImage b4Image) {
		this.b4Image = b4Image;
	}

}
