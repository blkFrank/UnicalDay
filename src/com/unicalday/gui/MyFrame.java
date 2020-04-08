package com.unicalday.gui;



import javax.swing.JFrame;


public class MyFrame extends JFrame {	
	
	private static final long serialVersionUID = 1L;
	

	public MyFrame(String title) {
	
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(10, 10);
		this.setResizable(false);
		this.setVisible(true);
		
		
	}
	
	public void addContent(MyPanel p) {
		
		this.setContentPane(p);
		this.pack();
	}

}
