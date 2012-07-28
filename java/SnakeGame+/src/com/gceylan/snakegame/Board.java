package com.gceylan.snakegame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	private final int DOT_SIZE = 10; // Nokta boyutu
	private final int ALL_DOTS = 900;
	private final int RAND_POS = 60;
	private int DELAY = 30;
	
	private int x[] = new int[ALL_DOTS];
	private int y[] = new int[ALL_DOTS];
	
	private int dots;
	private int appleX;
	private int appleY;
	
	private boolean left = false;
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private boolean inGame = true;
	private boolean pause = false;
	
	private int score;
	
	private javax.swing.Timer timer;
	private Image ball;
	private Image apple;
	private Image head;
	
	public Board() {
		
		score = 0;
		
		addKeyListener(new MyKeyListener());
		
		setBackground(Color.black);
		
		ImageIcon imageDot = new ImageIcon("images/dot.png");
		ball = imageDot.getImage();
		
		ImageIcon imageApple = new ImageIcon("images/apple.png");
		apple = imageApple.getImage();
		
		ImageIcon imageHead = new ImageIcon("images/head.png");
		head = imageHead.getImage();

		setFocusable(true);
		initializeGame();
	}
	
	public void initializeGame() {
		
		// yýlan boyu baþlangýçta 3 nokta.
		dots = 3;
		
		for (int i = 0; i < dots; i++) {
			// dotlarýn boyutu 10 px...
			// baþlangýç noktasý.
			x[i] = 150 - i * 10;
			y[i] = 150;
		}
		
		localeApple();
		
		// animasyon hýzý diyelim...
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void localeApple() {
		int r = (int) (Math.random() * RAND_POS);
		appleX = r * DOT_SIZE;
		r = (int) (Math.random() * RAND_POS);
		appleY = r * DOT_SIZE;
	}
	
	// elmayý yersen ayvayý da yersin...
	public void checkApple() {
		// 1 elma 10 puan, 5 in katlarýnda +50 puan ve hýz artýþý...
		// apple' ý kaptýðýnda...
		if (x[0] == appleX && y[0] == appleY) {
			dots++;
			score += 10;
			if ((dots - 3) % 5 == 0) {
				score += 40;
				DELAY -= dots % 20;
			}
			localeApple();
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		
		// her 5 katta 30 puan her apple da 10 puan.
		// head ve ball larý çiz...
		if (inGame) {
			
			g.drawString("Score: " + score, WIDTH - 100, HEIGHT);
			
			g.drawImage(apple, appleX, appleY, this);
			
			for (int i = 0; i < dots; i++) {
				if (i == 0)
					g.drawImage(head, x[i], y[i], this);
				else
					g.drawImage(ball, x[i], y[i], this);
			}
			
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
			
		} else {
			gameOverMessage(g);
		}
	}
	
	public void gameOverMessage(Graphics g) {
		String message = "Game Over";
		
		g.drawRect(40, 40, 530, 530);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(message, (WIDTH - 120) / 2, HEIGHT / 3);
		
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawRect(265, HEIGHT / 2 - 15, 100, 20);
		g.drawString("Restart", (WIDTH - 20) / 2, HEIGHT / 2);
	}
	
	public void move() {
		for (int i = dots; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		
		if (left) {
			x[0] -= DOT_SIZE;
		}
		
		if (right) {
			x[0] += DOT_SIZE;
		}
		
		if (up) {
			y[0] -= DOT_SIZE;
		}
		
		if (down) {
			y[0] += DOT_SIZE;
		}
	}
	
	public void checkCollision() {

		for (int i = dots; i > 0; i--) {

            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }

		if (y[0] > HEIGHT) {
			inGame = false;
		}
		
		if (y[0] < 0) {
			inGame = false;
		}

		if (x[0] > WIDTH) {
			inGame = false;
		}

		if (x[0] < 0) {
			inGame = false;
		}
	}
	
	public void checkCollisionFree() {

		for (int i = dots; i > 0; i--) {
			// kendine çarptýn hacý...
            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
                inGame = false;
            }
        }

		if (y[0] > HEIGHT)
			y[0] = 0;
		
		if (y[0] < 0)
			y[0] = 600;

		if (x[0] > WIDTH)
			x[0] = 0;
		
		if (x[0] < 0)
			x[0] = 600;
	}

	public void actionPerformed(ActionEvent e) {
		if (inGame) {
			checkApple();
			checkCollision();
			//checkCollisionFree();
			move();
		}
		
		repaint();
	}
	
	private class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!right)) {
				left = true;
				up = false;
				down = false;
			}
			
			if ((key == KeyEvent.VK_RIGHT) && (!left)) {
				right = true;
				up = false;
				down = false;
			}

			if ((key == KeyEvent.VK_UP) && (!down)) {
				up = true;
				right = false;
				left = false;
			}

			if ((key == KeyEvent.VK_DOWN) && (!up)) {
				down = true;
				right = false;
				left = false;
			}
			if (key == KeyEvent.VK_P) {
				System.out.println(Arrays.toString(x));
				System.out.println(Arrays.toString(y));
				if (!pause) {
					timer.stop();
					pause = true;
				} else {
					timer.start();
					pause = false;
				}
			}
		}
	}
	
}
