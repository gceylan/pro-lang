import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Mouse_Listener extends JFrame implements MouseMotionListener, MouseListener{

	private JLabel label = new JLabel(); 
	Graphics g;
	
	private static final long serialVersionUID = 1L;

	public Mouse_Listener() {
		super("Mouse takibi");
		this.getContentPane().add(label,BorderLayout.SOUTH);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,500);
		this.setVisible(true);

	}
	
	public void mouseClicked(MouseEvent e) {
		label.setText("Tiklanan Nokta (" + e.getX() + ", " + e.getY() + ")");
		g = getGraphics();
		g.setColor(Color.YELLOW);
		g.fillArc(e.getX()-10, e.getY()-10, 20, 20, 0, 360);
	}
	
	public void mouseDragged(MouseEvent e) {
		label.setText("Drawing (" + e.getX() + ", " + e.getY() + ")");
		g = getGraphics();
		g.setColor(Color.BLUE);
		g.fillArc(e.getX()-10, e.getY()-10, 20, 20, 0, 360);
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void mouseMoved(MouseEvent e) {
		label.setText("Moved (" + e.getX() + ", " + e.getY() + ")");
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void mouseExited(MouseEvent e) {
		repaint();
	}
	
	public static void main(String [] args) {
		new Mouse_Listener();
	}
}