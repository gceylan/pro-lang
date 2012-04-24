import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;

public class Key_Listener extends JFrame {

	/**
	 * @param args
	 */
	Container c;
	public Key_Listener() {
		c = this.getContentPane();
		SketchPanel panel = new SketchPanel();
		c.add(panel);
		this.setTitle("my key listener");
		this.setSize(400, 400);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.show();
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Key_Listener();
	}

	public class SketchPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Point2D last;
		ArrayList lines;
		
		public SketchPanel() {
			last = new Point2D.Double(50, 50);
			lines = new ArrayList();
			KeyHandler listener = new KeyHandler();
			this.addKeyListener(listener);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			for(int i = 0; i < lines.size(); i += 3)
			    g2.draw((Line2D)lines.get(i));	 
		}
		
		public boolean isFocusTraversable() {
			return true;
		}
		
		public void add(int dx, int dy) {
			Point2D end = new Point2D.Double(last.getX() + dx, last.getY() + dy);
			Line2D line = new Line2D.Double(last, end);
			lines.add(line);
			repaint();
			last = end;
		}
		
		private class KeyHandler implements KeyListener {
			public static final int LARGE_INCREMENT = 5;
			public static final int SMALL_INCREMENT = 3;
			
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				int d;
				if(e.isShiftDown())
					d = LARGE_INCREMENT;
				else
					d = SMALL_INCREMENT;
				if(keyCode == KeyEvent.VK_RIGHT)
					add(d, 0);
				else if(keyCode == KeyEvent.VK_LEFT)
					add(-d, 0);
				else if(keyCode == KeyEvent.VK_UP)
					add(0, -d);
				else if(keyCode == KeyEvent.VK_DOWN)
					add(0, d);
			}
			
			public void keyReleased(KeyEvent e) {
				// TODO
			}
			
			public void keyTyped(KeyEvent e) {
				
				char keyChar = e.getKeyChar();
				int d;
				if(Character.isUpperCase(keyChar)) {
					d = this.LARGE_INCREMENT;
					keyChar = Character.toLowerCase(keyChar);
				}
				else
					d = this.SMALL_INCREMENT;
			}
		}
	}


}
