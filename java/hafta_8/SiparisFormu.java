import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SiparisFormu extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String yiyecekler[] = {
			"Mercimek �orbas�", "Karn�yar�k", "Pilav", "Sigara B�re�i",
			"Etimekli yo�urtlu salata", "Zeytinya�l� taze fas�lye",
			"Mevsim salatas�", "B���rtlenli pasta", "Makarna", "Kuru Fas�lye",
			"Nohut"
	};
	
	Double yiyecek_fiyalari[] = {
			1.50, 2.00, 2.00, 1.00,
			5.00, 4.00,
			8.00, 4.00, 3.00, 3.00,
			2.00 
	};
	
	String icecekler[] = {
			"Ayran", "Coca Cola", "Vi�ne Suyu", "Soda", "Nektari", "Kahve",
			"Nescafe", "                                            "
	};
	
	Double icecek_fiyatlari[] =  {
			1.00, 2.00, 2.00, 1.00, 1.00, 1.50, 1.00
	};
	
	String adet[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
	
	JPanel yiyeceklerPaneli, yiyecekAdetPaneli, siparislerPaneli, iceceklerPaneli, icecekAdetPaneli, toplamPanel;
	JComboBox yiyecekAdediComboBox, icecekAdediComboBox;
	JList yiyeceklerListBox, iceceklerListBox;
	JTextArea ekran;
	JTextField toplam;
	JButton yiyecekleriEkle, icecekleriEkle;
	JScrollPane scroll1, scroll2, scroll3;
	ButonDinleyici dinleyici1;
	int i = 1;
	double toplamTutar = 0;
	
	public void go() {
		JFrame frame = new JFrame("Sipari� Formu");
		frame.setLayout(new FlowLayout(20, 20, 20));
		
		yiyeceklerPaneli = new JPanel(new BorderLayout(5, 5));
		yiyeceklerListBox = new JList(yiyecekler);
		yiyeceklerListBox.setVisibleRowCount(9);
		yiyeceklerListBox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		yiyeceklerPaneli.add(new JLabel("Yiyecekler"), BorderLayout.NORTH);
		yiyeceklerPaneli.add(yiyeceklerListBox, BorderLayout.CENTER);
		scroll1 = new JScrollPane(yiyeceklerListBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		yiyeceklerPaneli.add(scroll1);

		
		yiyecekAdetPaneli = new JPanel(new BorderLayout(5, 5));
		yiyecekAdediComboBox = new JComboBox(adet);
		yiyecekAdetPaneli.add(new JLabel("Yiyecek Adedi"), BorderLayout.NORTH);
		yiyecekAdetPaneli.add(yiyecekAdediComboBox, BorderLayout.CENTER);
		yiyecekleriEkle = new JButton("Ekle");
		yiyecekAdetPaneli.add(yiyecekleriEkle, BorderLayout.SOUTH);
		
		siparislerPaneli = new JPanel(new BorderLayout(5, 5));
		ekran = new JTextArea(10, 25);
		siparislerPaneli.add(new JLabel("Sipari�lerin Toplam�"), BorderLayout.NORTH);
		siparislerPaneli.add(ekran, BorderLayout.CENTER);
		scroll3 = new JScrollPane(ekran, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		siparislerPaneli.add(scroll3);
		
		iceceklerPaneli = new JPanel(new BorderLayout(5, 5));
		iceceklerListBox = new JList(icecekler);
		iceceklerListBox.setVisibleRowCount(9);
		iceceklerPaneli.add(new JLabel("��ecekler"), BorderLayout.NORTH);
		iceceklerPaneli.add(iceceklerListBox, BorderLayout.CENTER);
		scroll2 = new JScrollPane(iceceklerListBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		iceceklerPaneli.add(scroll2);
		
		icecekAdetPaneli = new JPanel(new BorderLayout(5, 5));
		icecekAdetPaneli.add(new JLabel("��ecek Adedi"), BorderLayout.NORTH);
		icecekAdediComboBox = new JComboBox(adet);
		icecekAdetPaneli.add(icecekAdediComboBox, BorderLayout.CENTER);
		icecekleriEkle = new JButton("Ekle");
		icecekAdetPaneli.add(icecekleriEkle, BorderLayout.SOUTH);
		
		toplamPanel = new JPanel(new BorderLayout(5, 5));
		toplamPanel.add(new JLabel("Toplam Tutar"), BorderLayout.NORTH);
		toplam = new JTextField(25);
		toplamPanel.add(toplam, BorderLayout.CENTER);
		
		dinleyici1 = new ButonDinleyici();
		yiyecekleriEkle.addActionListener(dinleyici1);
		icecekleriEkle.addActionListener(dinleyici1);
		
		frame.add(yiyeceklerPaneli);
		frame.add(yiyecekAdetPaneli);
		frame.add(siparislerPaneli);
		frame.add(iceceklerPaneli);
		frame.add(icecekAdetPaneli);
		frame.add(toplamPanel);
		
		frame.setBounds(100, 100, 620, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		pack();
	}
	
	public class ButonDinleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String s = "";
			if (e.getSource() == yiyecekleriEkle) {
				
				String secilen = (String)yiyeceklerListBox.getSelectedValue();
				int ind_secilen = yiyeceklerListBox.getSelectedIndex();
				String adet = (String)yiyecekAdediComboBox.getSelectedItem();
				int ind_adet = yiyecekAdediComboBox.getSelectedIndex() + 1;
				
				double tutar = ind_adet * yiyecek_fiyalari[ind_secilen];
				toplamTutar += tutar;
				s += secilen + " - " + adet + " adet (" + tutar + " TL)\n";
			}
			
			else if (e.getSource() == icecekleriEkle) {
				
				String secilen = (String)iceceklerListBox.getSelectedValue();
				int ind_secilen = iceceklerListBox.getSelectedIndex();
				String adet = (String)icecekAdediComboBox.getSelectedItem();
				int ind_adet = icecekAdediComboBox.getSelectedIndex() + 1;
				
				double tutar = ind_adet * yiyecek_fiyalari[ind_secilen];
				toplamTutar += tutar;
				s += secilen + " - " + adet + " adet (" + tutar + " TL)\n";
			}
			
			ekran.append(i++ + ") " + s);
			toplam.setText(toplamTutar + " TL");
		}
		
	}
	
	public static void main(String[] args) {
		SiparisFormu gui = new SiparisFormu();
		gui.go();
	}
}
