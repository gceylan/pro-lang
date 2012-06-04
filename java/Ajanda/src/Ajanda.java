import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class Ajanda extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	Veritabani vt = null;
	String url = "jdbc:mysql://localhost/ajanda2";
	String user = "root";
	String password = "------";

	JTextField simdikiTarih;
	JTextArea not;
	JScrollPane scrooll;
	JButton ajandayaEkle, tarihSec, depo, enYakinHatirlatma, gunuGecmisHatirlatmar;
	JTextField tarihTf;
	Dinleyici d1;
	
	public Ajanda() {
		JFrame frame = new JFrame("AjandaApp");
		frame.setLayout(new FlowLayout(20, 20, 20));
		
		d1 = new Dinleyici();

		JPanel zamanPaneli = new JPanel();
		zamanPaneli.setLayout(new BorderLayout(10, 10));
		
		zamanPaneli.add(new JLabel("Şuan ki Tarih"), BorderLayout.WEST);
		
		simdikiTarih = new JTextField(15);
		simdikiTarih.setBackground(Color.BLACK);
		simdikiTarih.setForeground(Color.WHITE);
		zamanPaneli.add(simdikiTarih, BorderLayout.CENTER);
		simdikiTarih.setEditable(false);
		
		
		JPanel tarihPanel = new JPanel();
		tarihPanel.setLayout(new BorderLayout(10, 10));
		tarihPanel.add(new JLabel("Seçilen Tarih"), BorderLayout.WEST);
		
		tarihTf = new JTextField(15);
		tarihPanel.add(tarihTf, BorderLayout.CENTER);
		
		tarihSec = new JButton("Tarih Seç");
		tarihPanel.add(tarihSec, BorderLayout.EAST);
		tarihSec.addActionListener(d1);
		
		
		JPanel notP = new JPanel();
		notP.setLayout(new BorderLayout(10, 10));
		
		notP.add(new JLabel("Notunuzu ekleyin"), BorderLayout.NORTH);
		
		not = new JTextArea(10, 34);
		not.setLineWrap(true);
		notP.add(not, BorderLayout.CENTER);
		
		JPanel butonlar = new JPanel(new FlowLayout(0, 0, 10));
		ajandayaEkle = new JButton("Ajandaya Ekle");
		ajandayaEkle.addActionListener(d1);
		butonlar.add(ajandayaEkle, BorderLayout.WEST);
		
		depo = new JButton("Depo");
		depo.addActionListener(d1);
		butonlar.add(depo, BorderLayout.CENTER);
		
		enYakinHatirlatma = new JButton("En Yakın Hatırlatma");
		enYakinHatirlatma.addActionListener(d1);
		butonlar.add(enYakinHatirlatma, BorderLayout.EAST);
		
		vt = new Veritabani(url, user, password);
		sistemTemasiniKullan();
		

		frame.add(zamanPaneli);
		frame.add(tarihPanel);
		frame.add(notP);
		frame.add(butonlar);
		
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
		frame.setBounds(350, 100, 420, 420);
		frame.setVisible(true);
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				simdikiTarih.setText(Zaman.Now());
			} catch (Exception treadEx) {
				treadEx.printStackTrace();
			}
		}
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
		  tablo.getColumnModel().getColumn(2).setPreferredWidth(350);
		  tablo.setSize(new Dimension(100, 100));
		  
		  JScrollPane scroollPaneli = new JScrollPane(tablo);
		  panel.add(scroollPaneli);
		  
		  JTableHeader header = tablo.getTableHeader();
		  //header.setBackground(Color.yellow);
		  header.setForeground(Color.BLUE);
		  header.setBackground(Color.BLACK);
		  
		  frame.add(panel);
		  frame.setSize(470,470);
		  //frame.setUndecorated(true);
		  //frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setVisible(true);
	}
	
	public void kaydet() throws SQLException {
		String tarih = tarihTf.getText();
		String ozelNot = not.getText();
		
		if (tarih.equals("") || ozelNot.equals("")) {
			JOptionPane.showMessageDialog(null, "Not eklemeyi ve Tarih seçmeyi"
					+ " unutmayın!", "Uyarı", 1);
		}
		else {
			vt.saveDatabase(tarih, ozelNot);
			JOptionPane.showMessageDialog(null, "Tarih-saat: " + tarih
					+ "\nNot: " + ozelNot + "\nİşlem Tamamlandı.");
			clear();
		}
	}
	
	public void theFirstReminder() throws SQLException {
		
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
	
	public static void main(String[] args) throws SQLException {
		Ajanda ajnd = new Ajanda();
		Thread thread = new Thread(ajnd);
		thread.start();
	}
}
