import java.awt.Graphics;
import javax.swing.JApplet;


public class RuzgarGulu extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
		int x = 0, y = 45;
		
		for (int i = 0; i < 12; i++) {
			g.fillArc(50, 50, 100, 100, x, y);
			x += 90;
		}
		g.drawString("---Rüzgar gülü---", 60, 170);
	}
}