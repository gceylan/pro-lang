import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import javazoom.jl.decoder.JavaLayerException;

public class Ajanda extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	Veritabani vt = null;
	String url = "jdbc:mysql://localhost/dbAjanda";
	String user = "root";
	String password = "gceylan";

	JTextField simdikiTarih;
	JTextArea not;
	JScrollPane scrooll;
	JButton ajandayaEkle, tarihSec, depo, enYakinHatirlatma, kalanSure, tamam;
	JTextField tarihTf;
	Dinleyici d1;
	
	Zaman z;
	String[] hatirlatma;
	
	JLayerDemo ses;
	boolean sonBirSaat = true;
	
	public Ajanda() throws JavaLayerException {
		JFrame frame = new JFrame("AjandaApp");
		frame.setLayout(new FlowLayout(20, 20, 20));
		
		z = new Zaman();
		d1 = new Dinleyici();
		ses = new JLayerDemo();
		vt = new Veritabani(url, user, password);
		
		sistemTemasiniKullan();

		JPanel zamanPaneli = new JPanel();
		zamanPaneli.setLayout(new BorderLayout(15, 10));
		
		zamanPaneli.add(new JLabel("Şuan ki Tarih"), BorderLayout.WEST);
		
		simdikiTarih = new JTextField(20);
		simdikiTarih.setEditable(false);
		zamanPaneli.add(simdikiTarih, BorderLayout.CENTER);
		
		
		JPanel tarihPanel = new JPanel();
		tarihPanel.setLayout(new BorderLayout(15, 10));
		tarihPanel.add(new JLabel("Seçilen Tarih"), BorderLayout.WEST);
		
		tarihTf = new JTextField(20);
		tarihPanel.add(tarihTf, BorderLayout.CENTER);
		
		tarihSec = new JButton("Tarih Seç");
		tarihSec.addActionListener(d1);
		tarihPanel.add(tarihSec, BorderLayout.EAST);
		
		
		JPanel notP = new JPanel();
		notP.setLayout(new BorderLayout(10, 10));
		
		notP.add(new JLabel("Notunuzu ekleyin"), BorderLayout.NORTH);
		
		not = new JTextArea(15, 30);
		not.setLineWrap(true);
		notP.add(not, BorderLayout.CENTER);
		
		Font f = new Font("Arial", Font.ITALIC ,13);
		not.setFont(f);
		
		JPanel butonlar = new JPanel(new GridLayout(2, 2, 5, 5));
		ajandayaEkle = new JButton("Ajandaya Ekle");
		ajandayaEkle.addActionListener(d1);
		butonlar.add(ajandayaEkle);
		
		depo = new JButton("Depo");
		depo.addActionListener(d1);
		butonlar.add(depo);
		
		enYakinHatirlatma = new JButton("En Yakın Hatırlatma");
		enYakinHatirlatma.addActionListener(d1);
		butonlar.add(enYakinHatirlatma);
		
		kalanSure = new JButton();
		butonlar.add(kalanSure);
		
		notP.add(butonlar, BorderLayout.SOUTH);
		
		frame.add(zamanPaneli);
		frame.add(tarihPanel);
		frame.add(notP);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent winEvent) {
				try {
					vt.shutDownConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		
		frame.setResizable(false);
		frame.setBounds(350, 100, 430, 500);
		frame.setVisible(true);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				simdikiTarih.setText(Zaman.Now());
				hatirlatma = vt.getFirtReminder();
				kalanSure.setText(z.kacSaatKacDkVar(hatirlatma[0]));
				
				if (z.sesCalinsinMi(hatirlatma[0]).equals("1:0:0") && sonBirSaat) {
					sonBirSaat = false;
					uyariPenceresi();
					ses.oynat();
				}
			} catch (Exception treadEx) {
				treadEx.printStackTrace();
			}
		}
	}
	
	public void uyariPenceresi() {
		final JFrame f = new JFrame();
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JPanel p = new JPanel();
		tamam = new JButton("Tamam");
		tamam.addActionListener(d1);
		p.add(tamam);
		
		tamam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ses.kapat();
				f.setVisible(false);
			}
		});
		
		f.add(new JLabel("1 saat Kaldı. Mail at ve Uyarı sesini çal!"));
		f.add(p);
		f.setBounds(300, 300, 300, 100);
		f.setVisible(true);
	}
	
	public void sistemTemasiniKullan() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	public void showDepo() throws SQLException {
		JFrame frame = new JFrame("Depo");
		  JPanel panel = new JPanel();
		  Object [] sutunAdlari = {"id", "Tarih-Saat", "Not"};
		  
		  Object[][] satirDegerleri = vt.showDatebase();
		  
		  JTable tablo = new JTable(satirDegerleri, sutunAdlari);
		  tablo.setGridColor(Color.BLUE);
		  
		  tablo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  tablo.getColumnModel().getColumn(0).setPreferredWidth(30);
		  tablo.getColumnModel().getColumn(1).setPreferredWidth(120);
		  tablo.getColumnModel().getColumn(2).setPreferredWidth(500);
		  tablo.setSize(new Dimension(100, 100));
		  
		  JScrollPane scroollPaneli = new JScrollPane(tablo);
		  panel.add(scroollPaneli);
		  
		  JTableHeader header = tablo.getTableHeader();
		  header.setForeground(Color.BLUE);
		  header.setBackground(Color.BLACK);
		  
		  frame.add(panel);
		  frame.setSize(480,490);
		  //frame.setUndecorated(true);
		  //frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setVisible(true);
	}
	
	public void kaydet() throws SQLException {
		String tarih = tarihTf.getText();
		String ozelNot = not.getText();
		
		if (ozelNot.length() <= 400) {
			if (tarih.equals("") || ozelNot.equals("")) {
				JOptionPane.showMessageDialog(null, "Not eklemeyi ve Tarih"
						+ " seçmeyi unutmayın!", "Uyarı", 1);
			} else {
				vt.saveDatabase(tarih, ozelNot);
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Notunuz 400 karakter sınırını "
					+ "aşıyor!", "Uyarı", 1);
		}
		
	}
	
	public void theFirstReminder() throws SQLException {
		hatirlatma = vt.getFirtReminder();
		String not = strDuzelt(hatirlatma[1]);
		
		JOptionPane.showMessageDialog(null, "En yakın hatırlatma tarihi : "
				+ hatirlatma[0] + "\n"
				+ "Hatırlatma notu : \n" + not
				+ "\nKalan süre : " + z.kacSaatKacDkVar(hatirlatma[0]));
	}
	
	public static String strDuzelt( String not ) {
		String gonder = "";
		int j = 0, k = 50;
		int boy = not.length(); 
		if (boy > 50) {
			while (boy % 50 > 0) {
				gonder += not.substring(j, k) + "\n";
				boy -= 50;
				j = k;
				k += (boy < 50) ? boy : 50;
			}
		} else {
			gonder = not;
		}
		
		return gonder;
	}
	
	public void clear() {
		not.setText("");
		tarihTf.setText("");
	}
	
	public void dateChose() {
		final JFrame f = new JFrame();
		tarihTf.setText(new DatePicker(f).setPickedDate());
		f.pack();
	}
	
	
	public class Dinleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == ajandayaEkle)
					kaydet();
				
				else if (e.getSource() == tarihSec)
					dateChose();
				
				else if (e.getSource() == depo)
					showDepo();

				else if (e.getSource() == enYakinHatirlatma)
					theFirstReminder();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) throws SQLException, JavaLayerException {
		Ajanda ajnd = new Ajanda();
		Thread thread = new Thread(ajnd);
		thread.start();
	}
}