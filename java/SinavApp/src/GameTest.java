import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameTest extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JTextField text;
	JButton button;
	Game g;
	Dinleyici d;
	
	public void go() {
		JFrame frame = new JFrame("TheGame");
		frame.setLayout(new FlowLayout());
		
		g = new Game();
		
		button = new JButton("tahmin?");
		text = new JTextField(10);
		
		d = new Dinleyici();
		button.addActionListener(d);
		text.addActionListener(d);
		
		frame.add(text);
		frame.add(button);
		
		frame.setBounds(100, 100, 300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	public class Dinleyici implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				int tahmin = Integer.valueOf(text.getText());
				int fark = g.sayiyiKarsilastir(tahmin);
				
				if (fark == 0)
					JOptionPane.showMessageDialog(null, "Tebrikler. Doðru tahmin");
				else if (fark > 0)
					JOptionPane.showMessageDialog(null, "sayiyi büyültün");
				else
					JOptionPane.showMessageDialog(null, "sayiyi küçültün");
			}
		}
	}
	
	public static void main(String[] args) {
		GameTest gui = new GameTest();
		gui.go();
	}

}
