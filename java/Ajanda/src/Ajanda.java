import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.JTableHeader;

public class Ajanda extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// veritani islemleri icin
	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	// swing bilesenleri
	JTextArea not;
	JScrollPane scrooll;
	JButton ajandayaEkle, tarihSec, depo, enYakinHatirlatma;
	JTextField tarihTf;
	Dinleyici d1;
	JScrollPane scroller;
	
	public Ajanda() {
		JFrame frame = new JFrame("AjandaApp");
		frame.setLayout(new FlowLayout(10, 20, 20));
		
		d1 = new Dinleyici();
		
		// tarih giris paneli
		JPanel zamanPaneli = new JPanel();
		zamanPaneli.setLayout(new BorderLayout(20, 20));
		
		zamanPaneli.add(new JLabel("Þuan ki Tarih"), BorderLayout.WEST);
		
		JTextField simdikiTarih = new JTextField(15);
		simdikiTarih.setBackground(Color.BLACK);
		simdikiTarih.setForeground(Color.WHITE);
		zamanPaneli.add(simdikiTarih, BorderLayout.CENTER);
		simdikiTarih.setText(Zaman.Now());
		simdikiTarih.setEditable(false);
		
		JPanel tarihPanel = new JPanel();
		tarihPanel.setLayout(new BorderLayout(20, 20));
		tarihPanel.add(new JLabel("Seçilen Tarih"), BorderLayout.WEST);
		
		tarihTf = new JTextField(15);
		tarihPanel.add(tarihTf, BorderLayout.CENTER);
		
		tarihSec = new JButton("Tarih Seç");
		tarihPanel.add(tarihSec, BorderLayout.EAST);
		tarihSec.addActionListener(d1);
		
		// Not girisi icin kullanilan panel
		JPanel notP = new JPanel();
		notP.setLayout(new BorderLayout(20, 10));
		
		notP.add(new JLabel("Notunuzu ekleyin"), BorderLayout.NORTH);
		
		not = new JTextArea(10, 34);
		not.setLineWrap(true);	// alt satýra otomatik geç.
		scroller = new JScrollPane (not, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		notP.add(not, BorderLayout.CENTER);
		notP.add(not, BorderLayout.CENTER);
		
		// butonlarýn bulunduðu panel
		JPanel butonlar = new JPanel();
		ajandayaEkle = new JButton("Ajandaya Ekle");
		ajandayaEkle.addActionListener(d1);
		butonlar.add(ajandayaEkle);
		
		depo = new JButton("Depo");
		depo.addActionListener(d1);
		butonlar.add(depo);
		
		enYakinHatirlatma = new JButton("En yakýn tarihli hatýrlatma");
		enYakinHatirlatma.addActionListener(d1);
		butonlar.add(enYakinHatirlatma);
		
		// tüm panelleri frame ekle
		frame.add(zamanPaneli);
		frame.add(tarihPanel);
		frame.add(notP);
		frame.add(butonlar);
		
		// bunu unutursan heap bölgesi tasar...
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(350, 100, 430, 430);
		frame.setVisible(true);
	}
	
	public void connectDatabase() {
		String url = "jdbc:mysql://localhost/ajanda";
		String user = "root";
		String passwd = "********";
		
		try {
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException sqlEx) {
			JOptionPane.showMessageDialog(null, "Veritabanýna baðlanýlamadý!",
					"Hata!", 0);
			sqlEx.printStackTrace();
		}
	}
	
	public void shutDownConnection() {
		try {
			connect.close();
		}
		catch(SQLException sqlEX) {
			JOptionPane.showMessageDialog(null, "Veritabaný kapatýlamadý!",
					"Hata!", 0);
			sqlEX.printStackTrace();
		}
	}
	
	public void vtKaydet() throws SQLException {
		String ozelNot = not.getText();
		String tarih = tarihTf.getText();
		
		if (ozelNot.equals("") || tarih.equals("")) {
			JOptionPane.showMessageDialog(null, "Not eklemeyi ve Tarih seçmeyi unutmayýn!");
		}
		else {
			connectDatabase();
			preparedStatement = connect.prepareStatement("insert into "
					+ "NOTLAR values (default, ?, ?)");
			preparedStatement.setString(1, tarih);
			preparedStatement.setString(2, ozelNot);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Tarih: " + tarih
					+ "\nNot: " + ozelNot + "\nÝþlem tamamlandý.");
			shutDownConnection();
			clear();
		}
	}
	
	public void showDepo() throws SQLException {
		JFrame frame = new JFrame("Creating a Scrollable JTable!");
		  JPanel panel = new JPanel();
		  Object [] sutunAdlari = {"id", "Tarih", "Özel Not"};
		  
		  connectDatabase();
		  statement = connect.createStatement();
		  resultSet = statement.executeQuery("select * from NOTLAR");
		  
		  Vector<Object> satirlar = new Vector<Object>();
		  
		  while (resultSet.next()) {
			  Object [] degerler = {
					  resultSet.getString(1),
					  resultSet.getString(2),
					  resultSet.getString(3)
			  };
			  satirlar.add(degerler);
		  }
		  
		  Object[][] satirDegerleri = new Object[satirlar.size()][3];
		  
		  for(int i = 0; i < satirlar.size(); i++) {
			  satirDegerleri[i] = (Object[]) satirlar.get(i);
		  }
		  
		  JTable tablo = new JTable(satirDegerleri, sutunAdlari);
		  tablo.setGridColor(Color.BLUE);
		  
		  tablo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  tablo.getColumnModel().getColumn(0).setPreferredWidth(30);
		  tablo.getColumnModel().getColumn(1).setPreferredWidth(70);
		  tablo.getColumnModel().getColumn(2).setPreferredWidth(350);
		  tablo.setSize(new Dimension(100, 100));
		  
		  JScrollPane scroollPaneli = new JScrollPane(tablo);
		  panel.add(scroollPaneli);
		  
		  JTableHeader header = tablo.getTableHeader();
		  //header.setBackground(Color.yellow);
		  header.setForeground(Color.WHITE);
		  header.setBackground(Color.BLACK);
		  
		  frame.add(panel);
		  frame.setSize(470,470);
		  //frame.setUndecorated(true);
		  //frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setVisible(true);
		  shutDownConnection();
	}
	
	public void ilkHatirlatma() throws SQLException {
		// TODO Karsilastirmalara saat-dakika-saniye yi de dahil et
		Zaman tarih = new Zaman();
		long simdikiTarih = tarih.convertToDate(Zaman.Now()).getTime();
		String secilen = null;
		String enErken = null;
		long enKucuk = 9999;
		long gelen = 0;
		
		connectDatabase();
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select tarih from notlar");
		
		while (resultSet.next()) {
			secilen = resultSet.getString("tarih");
			gelen = tarih.convertToDate(secilen).getTime();
			gelen = ((gelen - simdikiTarih) / (1000*60*60*24));
			if (gelen < enKucuk) {
				enKucuk = gelen;
				enErken = secilen;
			}
		}
		
		String sql = "select * from notlar";
		resultSet = statement.executeQuery(sql);
		
		if (resultSet.next()) {
			JOptionPane.showMessageDialog(null, "En yakýn hatýrlatmanýzýn tarihi: " + enErken
					+ "\nNotunuz: " + resultSet.getString(3), "En Yakýn Hatýrlatma", 1);
		}

		shutDownConnection();
	}
	
	public void clear() {
		not.setText("");
		tarihTf.setText("");
	}
	
	
	public class Dinleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == ajandayaEkle)
					vtKaydet();
				
				else if (e.getSource() == tarihSec) {
					final JFrame f = new JFrame();
					tarihTf.setText(new DatePicker(f).setPickedDate());
					f.pack();
				}
				
				else if (e.getSource() == depo)
					showDepo();

				else if (e.getSource() == enYakinHatirlatma)
					ilkHatirlatma();

				} catch (SQLException e1) {
					e1.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		new Ajanda();
	}

}
