package com.unicalday.editor;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

import com.unicalday.gui.BufferedImageLoader;



@SuppressWarnings("serial")
public class ToolsPanel extends JPanel implements ActionListener {

	public JButton getB1() {
		return b1;
	}

	public void setB1(JButton b1) {
		this.b1 = b1;
	}

	public JButton getB2() {
		return b2;
	}

	public void setB2(JButton b2) {
		this.b2 = b2;
	}

	public JButton getB3() {
		return b3;
	}

	public void setB3(JButton b3) {
		this.b3 = b3;
	}

	public JButton getB4() {
		return b4;
	}

	public void setB4(JButton b4) {
		this.b4 = b4;
	}

	private PreviewPanel pp = new PreviewPanel();
	private JButton b1 = new JButton(); //block 1
	private JButton b2 = new JButton(); //block 2
	private JButton b3 = new JButton(); //cfu
	private JButton b4 = new JButton(); //sky
	
	private JFileChooser fc = new JFileChooser();
	private JButton saveFileChooser = new JButton("Salva Livello");
	private JTextArea textArea = new JTextArea();
	
	private static int height=15;
	private static int width=95;
	
	public ToolsPanel(PreviewPanel pp){
		super();
	
		this.pp = pp;
	
		
		b1.addActionListener(this);
		b1.setIcon(new ImageIcon(pp.getB1Image().getScaledInstance(32, 32, 0)));
		add(b1);
		b2.addActionListener(this);
		b2.setIcon(new ImageIcon(pp.getB2Image().getScaledInstance(32, 32, 0)));
		add(b2);
		b3.addActionListener(this);
		b3.setIcon(new ImageIcon(pp.getB3Image().getScaledInstance(32, 32, 0)));
		add(b3);
		b4.addActionListener(this);
		b4.setIcon(new ImageIcon(pp.getB4Image().getScaledInstance(32, 32, 0)));
		add(b4);
		
		saveFileChooser.addActionListener(new SaveFileChooser());
		add(saveFileChooser);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			pp.paintImage =  pp.getB1Image();
		}
		else if (e.getSource() == b2){
			pp.paintImage =  pp.getB2Image();
		}
        else if (e.getSource() == b3){
			pp.paintImage =  pp.getB3Image();
		}
        else if (e.getSource() == b4){
			pp.paintImage = pp.getB4Image();
		}
		
	}
	
	private void castMatrixToTextArea(int [][]m) {
		textArea.append("95" + "\n" + "15" +"\n");
		for (int i=0; i<15; i++) {
			for (int j=0; j<95; j++) {
				if (j < 94)
					textArea.append("" + m[i][j] + " ");
				else if (j == 95)
					textArea.append("" + m[i][j]);
				else textArea.append("" + m[i][j] + "\n");
			}
		}
	}
	
	
	 private class SaveFileChooser implements ActionListener{
		 public void actionPerformed(ActionEvent e){
			 try{
				 JFileChooser fileChooser = new JFileChooser();
				 fileChooser.setFileFilter(new TxtFileFilter());
				 int n = fileChooser.showSaveDialog(ToolsPanel.this);
				 if (n == JFileChooser.APPROVE_OPTION) {
					 File f = fileChooser.getSelectedFile();
					 BufferedWriter write = new BufferedWriter(new FileWriter(f));
					 castMatrixToTextArea(pp.getGrid());
					 write.append(textArea.getText());
					 write.flush();
					 write.close();
				 }
			 }catch (Exception ex){}
		 }
	 }
	 
	 private class TxtFileFilter extends FileFilter{
		 public boolean accept(File file){
			 if (file.isDirectory()) return true;
			 String fname = file.getName().toLowerCase();
			 return fname.endsWith("txt");
		 }
		 public String getDescription(){
			 return "File di testo";
		 }
	 }

}

