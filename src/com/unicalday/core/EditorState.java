package com.unicalday.core;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;



import com.unicalday.editor.PreviewPanel;
import com.unicalday.editor.ToolsPanel;
import com.unicalday.gui.MyFrame;

public class EditorState extends State  {

	
		
		public EditorState() {  
			
			MyFrame frame = new MyFrame("Level Editor");
			PreviewPanel panel = new PreviewPanel();
			ToolsPanel tools = new ToolsPanel(panel);
			Container contentPane = frame.getContentPane();
			panel.setPreferredSize(new Dimension(3040,480));
			tools.setPreferredSize(new Dimension(300,480));
			
			contentPane.setLayout(new FlowLayout());
			contentPane.add(panel, BorderLayout.EAST);
			contentPane.add(tools, BorderLayout.WEST);
			
		
			frame.setResizable(false);
			
			frame.pack();
			frame.setLocationRelativeTo(null);
			
			frame.addMouseWheelListener(new MouseWheelListener() {

	            @Override
	            public void mouseWheelMoved(MouseWheelEvent event) {
	                if (event.isShiftDown()) {
	                    System.err.println("Horizontal " + event.getWheelRotation());
	                } else {
	                    System.err.println("Vertical " + event.getWheelRotation());                    
	                }
	            }
	        });
			
			
			
			frame.setVisible(true);
			
			
		}
		

		@Override
		public void tick() {
			
			if (State.getKeyboardInput().isKey(KeyEvent.VK_ESCAPE)){
				
				State.setState(GameManager.getMenuState());
				
			}

				
			
		}

		@Override
		public void render(Graphics g) {
			// TODO Auto-generated method stub
			
		}

}
