import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class HesapMakinesi extends Applet implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private Button Topla;
	private Button Cikar;
	private Button Carp;
	private Button Bol;
	private Button Us;
	private Button Sil;
	
	private TextField kutu1;
	private TextField kutu2, kutu3;
	private Label etiket;
	
	private double sayi1;
	private double sayi2;
	private double sonuc = 0;
	
	public void init() {
		setLayout(new GridLayout(5, 2));
		
		Topla = new Button("+");
		Cikar = new Button("-");
		Carp = new Button("*");
		Bol = new Button("/");
		Us = new Button("^");
		Sil = new Button("CE");
		kutu1 = new TextField(10);
		kutu2 = new TextField(10);
		kutu3 = new TextField(10);
		etiket = new Label(" = ");
		
		add(kutu1);
		add(kutu2);
		add(Topla);
		add(Cikar);
		add(Carp);
		add(Bol);
		add(Us);
		add(Sil);
		add(etiket);
		add(kutu3);
		
		Topla.addActionListener(this);
		Cikar.addActionListener(this);
		Carp.addActionListener(this);
		Bol.addActionListener(this);
		Us.addActionListener(this);
		Sil.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		sayi1 = Double.parseDouble(kutu1.getText());
		sayi2 = Double.parseDouble(kutu2.getText());
		
		if (e.getSource() == Topla)
			sonuc = sayi1 + sayi2;
		if (e.getSource() == Cikar)
			sonuc = sayi1 - sayi2;
		if (e.getSource() == Carp)
			sonuc = sayi1 * sayi2;
		if (e.getSource() == Bol)
			sonuc = sayi1 / sayi2;
		if (e.getSource() == Us)
			sonuc = Math.pow(sayi1, sayi2);
		if (e.getSource() == Sil) {
			kutu1.setText("");
			kutu2.setText("");
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		kutu3.setText("" + sonuc);
	}
}