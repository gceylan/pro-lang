package com.gceylan.snakegame;


import javax.swing.JFrame;


public class SnakeTest extends JFrame {

	private static final long serialVersionUID = 1L;


	public SnakeTest() {
		JFrame f = new JFrame();
		f.add(new Board());
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(618, 638);
		// ekraný ortala
		f.setLocationRelativeTo(null);
		f.setTitle("Gsnake");
		
		f.setResizable(false);
		f.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new SnakeTest();

	}

}
