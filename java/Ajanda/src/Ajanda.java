import java.sql.*;
import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

public class Ajanda extends JFrame {
	
	private static final long serialVersionUID = 1L;
	// veritani islemleri icin
	Connection connect = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	// swing bileþenleri
	JTextArea not;
	JScrollPane scrooll;
	JButton ajandayaEkle, tarihSec, depo, enYakinHatirlatma;
	JTextField tarihTf;
	Dinleyici d1;
	
	// tarih-zaman
	Zaman z;
	
	public Ajanda() {
		JFrame frame = new JFrame("AjandaApp");
		frame.setLayout(new FlowLayout(10, 20, 20));
		
		d1 = new Dinleyici();
		
		// þu anki tarihin ve tarihPanel in bulunduðu panel.
		JPanel zamanPaneli = new JPanel();
		zamanPaneli.setLayout(new BorderLayout(20, 20));
		zamanPaneli.add(new JLabel("Þuan ki Tarih"), BorderLayout.WEST);
		JTextField simdikiTarih = new JTextField(15);
		zamanPaneli.add(simdikiTarih, BorderLayout.CENTER);
		simdikiTarih.setText(z.Now());
		simdikiTarih.setEditable(false);
		
		JPanel tarihPanel = new JPanel();
		tarihPanel.setLayout(new BorderLayout(20, 20));
		tarihPanel.add(new JLabel("Seçilen Tarih"), BorderLayout.WEST);
		
		tarihTf = new JTextField(15);
		tarihPanel.add(tarihTf, BorderLayout.CENTER);
		
		tarihSec = new JButton("Tarih Seç");
		tarihPanel.add(tarihSec, BorderLayout.EAST);
		tarihSec.addActionListener(d1);
		
		// TextArea paneli
		JPanel notP = new JPanel();
		notP.setLayout(new BorderLayout(20, 20));
		
		notP.add(new JLabel("Notunuzu ekleyin"), BorderLayout.NORTH);
		
		not = new JTextArea(10, 34);
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
		
		
		frame.add(zamanPaneli);
		frame.add(tarihPanel);
		frame.add(notP);
		frame.add(butonlar);
		
		// bunu unutursan heap bölgesi taþar...
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setBounds(350, 100, 430, 430);
		frame.setVisible(true);
	}
	
	public void connectDatabase() {
		String url = "jdbc:mysql://localhost/ajanda";
		String user = "root";
		String passwd = "ben13753535866";
		
		try {
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException sqlEx) {
			System.err.println("Veritabanýna baðlanýlamadý!");
			sqlEx.printStackTrace();
		}
	}
	
	public void shutDownConnection() {
		try {
			connect.close();
		}
		catch(SQLException sqlEX) {
			System.err.println("Veritabaný kapýtýlamadý!");
			sqlEX.printStackTrace();
		}
	}
	
	public void vtKaydet() throws SQLException {
		String ozelNot = not.getText();
		String tarih = tarihTf.getText();
		
		ozelNot = "A";
		tarih = "B";
		
		if (ozelNot.equals("") || tarih.equals("")) {
			JOptionPane.showMessageDialog(null, "Not eklemeyi ve Tarih seçmeyi unutmayýn!");
		}
		else {
			connectDatabase();
			// TODO
			JOptionPane.showMessageDialog(null, "Tarih: " + tarih + "\nNot: " + ozelNot, "Ýþlem Baþarýlý.", 1);
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
		  resultSet = statement.executeQuery("select * from notlar");
		  
		  Vector satirlar = new Vector();
		  
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
		  JScrollPane scroollPaneli = new JScrollPane(tablo);
		  panel.add(scroollPaneli);
		  
		  JTableHeader header = tablo.getTableHeader();
		  header.setBackground(Color.green);
		  
		  //tablo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		  
		  frame.add(panel);
		  frame.setSize(480,480);
		  //frame.setUndecorated(true);
		  //frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		  frame.setVisible(true);
		  shutDownConnection();
	}
	
	public void clear() {
		not.setText("");
		tarihTf.setText("");
	}
	
	
	public class Dinleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ajandayaEkle) {
				try {
					vtKaydet();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (e.getSource() == tarihSec) {
                final JFrame f = new JFrame();
                tarihTf.setText(new DatePicker(f).setPickedDate());
                f.pack();
			}
			else if (e.getSource() == depo) {
				try {
					showDepo();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else if (e.getSource() == enYakinHatirlatma) {
				System.out.println("TEST AÞAMASINDAYIZ!!!");
			}
			
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		Ajanda gui = new Ajanda();
		//java.sql.Date bugununTarihi = new java.sql.Date(System.currentTimeMillis());
	}

}
