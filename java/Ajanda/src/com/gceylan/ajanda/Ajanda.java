package com.gceylan.ajanda;

import java.sql.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import org.apache.log4j.Logger;
import javazoom.jl.decoder.JavaLayerException;

public class Ajanda extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	Veritabani vt = null;
	PropertiesMain config = null;
	private static final Logger logger = Logger.getLogger(Ajanda.class);
	

	Font f = new Font("Arial", 12, 12);
	JTextField simdikiTarih;
	JTextArea not;
	JScrollPane scrooll;
	JButton ajandayaEkle, tarihSecimi1, depo, enYakinHatirlatma, bilgi, tamam;
	JTextField tarih1;
	Dinleyici d1;
	
	Zaman z;
	String[] hatirlatma;
	
	JLayerDemo ses;
	
	static Thread thread;
	
	DefaultTableModel tableModel;
	JTable table;
	
	// popup menü için gerekli listener.
	ActionListener menuListener;
	
	// güncelleme esnasýnda seçilen deðiþtirilen datalar.
	JFrame frameGuncelle;
	JTextField tarih2;
	JButton tarihSecimi2;
	JButton guncelle;
	JTextArea notGuncel;
	
	// güncellemek için seçilen satýr.
	ArrayList<String> selectedRowData;
	
	boolean depoShowing = false;
	
	public Ajanda() throws JavaLayerException {

		final JFrame frame = new JFrame("AjandaApp");
		frame.setLayout(new FlowLayout(20, 20, 20));
		
		config = new PropertiesMain();
		
		String host = (config.getProperties("host") != null) ? config.getProperties("host") : "localhost";
		String database = (config.getProperties("database") != null) ? config.getProperties("database") : "dbAjanda";
		String url = "jdbc:mysql://" + host + "/" + database;
		String user = (config.getProperties("user") != null) ? config.getProperties("user") : "root";
		String password = (config.getProperties("password") != null) ? config.getProperties("password") : "ben13753535866";
		
		config.setHost(host);
		config.setDatabase(database);
		config.setUser(user);
		config.setPassword(password);
		
		z = new Zaman();
		d1 = new Dinleyici();
		ses = new JLayerDemo();
		vt = new Veritabani(url, user, password);
		
		sistemTemasiniKullan();

		JPanel zamanPaneli = new JPanel();
		zamanPaneli.setLayout(new BorderLayout(15, 10));
		
		zamanPaneli.add(new JLabel("Þuan ki Tarih"), BorderLayout.WEST);
		
		simdikiTarih = new JTextField(20);
		simdikiTarih.setEditable(false);
		zamanPaneli.add(simdikiTarih, BorderLayout.CENTER);
		
		JPanel tarihPanel = new JPanel();
		tarihPanel.setLayout(new BorderLayout(15, 10));
		tarihPanel.add(new JLabel("Seçilen Tarih"), BorderLayout.WEST);
		
		tarih1 = new JTextField(20);
		tarihPanel.add(tarih1, BorderLayout.CENTER);
		
		tarihSecimi1 = new JButton("Tarih Seç");
		tarihSecimi1.addActionListener(d1);
		tarihPanel.add(tarihSecimi1, BorderLayout.EAST);
		
		
		JPanel notP = new JPanel();
		notP.setLayout(new BorderLayout(10, 10));
		
		notP.add(new JLabel("Notunuzu ekleyin"), BorderLayout.NORTH);
		
		not = new JTextArea(15, 28);
		not.setLineWrap(true);
		notP.add(new JScrollPane(
				not,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		), BorderLayout.CENTER);
		
		not.setFont(f);
		
		JPanel butonlar = new JPanel(new GridLayout(2, 2, 5, 5));
		ajandayaEkle = new JButton("Ajandaya Ekle");
		ajandayaEkle.addActionListener(d1);
		butonlar.add(ajandayaEkle);
		
		depo = new JButton("Depo");
		depo.addActionListener(d1);
		butonlar.add(depo);
		
		enYakinHatirlatma = new JButton("En Yakýn Hatýrlatma");
		enYakinHatirlatma.addActionListener(d1);
		butonlar.add(enYakinHatirlatma);
		
		bilgi = new JButton();
		butonlar.add(bilgi);
		
		notP.add(butonlar, BorderLayout.SOUTH);
		
		frame.add(zamanPaneli);
		frame.add(tarihPanel);
		frame.add(notP);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent winEvent) {
				String closingX = String.valueOf(frame.getX());
				String closingY = String.valueOf(frame.getY());
				
				config.setPositionX(closingX);
				config.setPositionY(closingY);
				
				logger.info("CLOSING X: " + closingX);
				logger.info("CLOSING Y: " + closingY);
				
				config.addAllConfigFile();
				
				try {
					vt.shutDownConnection();
				} catch (SQLException e) {
					logger.error("CONNECTION DO NOT CLOSED!");
					e.printStackTrace();
				}
				logger.info("AJANDA CLOSED! Time: " + Zaman.Now());
				System.exit(0);
			}
		});
		
		frame.setResizable(false);
		frame.setBounds(
				Integer.valueOf((config.getProperties("positionX") != null) ? config.getProperties("positionX") : "350"),
				Integer.valueOf((config.getProperties("positionY") != null) ? config.getProperties("positionY") : "100"),
				380,
				500
		);
			
		frame.setVisible(true);
		
		logger.info("AJANDA STARTED! Time: " + Zaman.Now());
	}
	
/*	public void addMenu(JPanel p) {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu1 = new JMenu("File");
		menu1.add(menuItem("File", menuBarListener));
		
		menuBar.add(menu1);
		
		p.add(menuBar);
	}
	
	public JMenuItem menuItem(String name, ActionListener aL) {
		JMenuItem item = new JMenuItem(name);
		item.addActionListener(aL);
		return item;
	}
	
	private class MyMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			
			if (command.equals("File")) {
				System.exit(0);
			}
		}
	}*/
	
	// hatirlatma[0] en yakýn hatýrlatma tarihini verir.
	public void refreshMonitor() {
		simdikiTarih.setText(Zaman.Now());
		bilgi.setText(z.kacSaatKacDkVar(hatirlatma[0]));
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				
				// TODO
				// her 1 saniye de ilk hatýrlatmayý çekmek veritabanýna yük bindirir.
				// bunu daha makul bir seviyede yapmak gerek. 5 - 10 sn...
				hatirlatma = vt.getFirtReminder();
				
				if (hatirlatma[0] == null) {
					JOptionPane.showMessageDialog(null, "Veritabaný boþ!");
					thread.stop();
					break;
				}
				
				refreshMonitor();
				
				if (z.sesCalinsinMi(hatirlatma[0])) {
					// TODO Mail Gönderme iþini uyariVerMailGonder metoduna ekle.
					// Böyle pek hoþ olmamýþ.
					bilgi.setText("Mail gönderiliyor...");
					// SendMail mail = new SendMail();
					// mail.send(hatirlatma[0] + " tarihli hatýrlatma!", hatirlatma[1]);
					bilgi.setText("Mail Gönderildi.");
					uyariVerMailGonder();
				}
			} catch (Exception treadEx) {
				logger.error("THREAD NOT WORKING!");
				logger.error("AJANDA APPLICATION IS STOPPED!");
				treadEx.printStackTrace();
				System.exit(0);
			}
		}
	}
	
	public void uyariVerMailGonder() throws JavaLayerException {
		final JFrame f = new JFrame("Hatýrlatmanýz var!");
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		JPanel p = new JPanel(new BorderLayout(10, 10));
		
		p.add(new JLabel(hatirlatma[1]), BorderLayout.CENTER);
		
		tamam = new JButton("Tamam");
		tamam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ses.kapat();
				f.setVisible(false);
			}
		});
		p.add(tamam, BorderLayout.SOUTH);
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent winEvent) {
				try {
					ses.kapat();
					f.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		f.add(p);
		f.setVisible(true);
		f.setBounds(300, 300, 300, 130);
		
		ses.oynat();
	}
	
	public void sistemTemasiniKullan() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			logger.error("UIMANAGER -> CLASS NOT FOUND!");
			e.printStackTrace();
		} catch (InstantiationException e) {
			logger.error("UIMANAGER -> INSTANTIATION!");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("UIMANAGER -> ILLEGAL ACCESS!");
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			logger.error("UIMANAGER -> UNSUPPORTED LOOK AND FEEL!");
			e.printStackTrace();
		}
	}
	
	public void showDepo(Object[][] data) throws SQLException {
		final JFrame frameShowDepo = new JFrame("Depo");
		
		// bitane table model tanýmladýk.
		tableModel = new DefaultTableModel();
		tableModel.addColumn("id");
		tableModel.addColumn("kayýt tarihi");
		tableModel.addColumn("hatýrlatma tarihi");
		tableModel.addColumn("notlar");
		
		// tabo oluþturmanýn 2 yolu var. ya table model argüman vermek, ya da 2 farklý liste...
		table = new JTable(tableModel);
		table.setRowHeight(25);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(900);
		
		Object[][] satirDegerleri = data;
		
		for (Object[] objects : satirDegerleri) {
			tableModel.addRow(objects);
		}
		
		// popup menü için gerekli yerler...
		menuListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();

				// iþlem görecek satýr bilgilerini tableModel' den al. Çünkü oradaki bilgiler vt den çekiliyor.
				selectedRowData = getSelectedRowData(selectedRow);
				
				if (e.getActionCommand().equals("Düzenle")) {
					frameGuncelle = new JFrame("Düzenle...");
					frameGuncelle.setLayout(new BorderLayout(20, 20));
					
					JPanel p1 = new JPanel(new FlowLayout());
					tarih2 = new JTextField(30);
					tarih2.setText(selectedRowData.get(2));
					
					tarihSecimi2 = new JButton("Tarih Seç");
					tarihSecimi2.addActionListener(d1);
					p1.add(new JLabel("Tarih"));
					p1.add(tarih2);
					p1.add(tarihSecimi2);
					
					JPanel p2 = new JPanel(new BorderLayout(5, 5));
					notGuncel = new JTextArea(15, 30);
					notGuncel.setText(selectedRowData.get(3));
					
					notGuncel.setFont(f);

					p2.add(new JLabel("Not"), BorderLayout.NORTH);
					p2.add(new JScrollPane(
							notGuncel,
							JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
							JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
					), BorderLayout.CENTER);
					
					guncelle = new JButton("Güncelle");
					guncelle.addActionListener(d1);
					p2.add(guncelle, BorderLayout.SOUTH);

					// p2 yi p1 e ekle ve göster...(düzenli bir çýktý elde etmek için...)
					p1.add(p2);

					frameGuncelle.add(p1, BorderLayout.CENTER);
					frameGuncelle.setBounds(100, 100, 400, 400);
					frameGuncelle.setVisible(true);
				}
				else if (e.getActionCommand().equals("Sil")) {
					delete(selectedRow, selectedRowData.get(0));
				}
			}
		};
		
		final JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem item = new JMenuItem();
		
		popupMenu.add(item = new JMenuItem("Düzenle"));
		item.addActionListener(menuListener);
		
		popupMenu.add(item = new JMenuItem("Sil"));
		item.addActionListener(menuListener);
		
		// ve tablodaki bir satýra týklandýðýnda popup menü açýlsýn.
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				checkPopup(e);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				checkPopup(e);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				checkPopup(e);
			}
			
			private void checkPopup(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		frameShowDepo.add(new JScrollPane(
				table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		), BorderLayout.CENTER);
		
		final JSpinner rowHeight = new JSpinner(
				new SpinnerNumberModel(25, 1, 50, 1));
		
		frameShowDepo.add(rowHeight, BorderLayout.SOUTH);
		
		rowHeight.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				table.setRowHeight(((Integer) rowHeight.getValue()).intValue());
			}
		});
		
		// frameShowDepo penceresi açýk mý?
		frameShowDepo.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				depoShowing = true;
			}
			
			public void windowClosing(WindowEvent e) {
				depoShowing = false;
			};
		});
		
		frameShowDepo.setBounds(50, 50, 750, 640);
		frameShowDepo.setVisible(true);
		
	}
	
	// table da seçilen satýrdaki bilgileri ArrayList olarak döndür.
	public ArrayList<String> getSelectedRowData(int selectedRow) {
		ArrayList<String> selectedRowData = new ArrayList<String>();
		
		for (int i = 0; i < table.getColumnCount(); i++) {
			selectedRowData.add((String) table.getValueAt(selectedRow, i));
		}
		
		return selectedRowData;
	}
	
	public void kaydet(String tarih, String not) throws SQLException {
		
		if (not.length() <= 400) {
			if (tarih.equals("") || not.equals("")) {
				JOptionPane.showMessageDialog(null, "Not eklemeyi ve Tarih"
						+ " seçmeyi unutmayýn!", "Uyarý", 1);
			} else {
				vt.saveData(tarih, not);
				tableModel.addRow(new Object[] {"id=?", Zaman.Now(), tarih, not});				
				clear();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Notunuz 400 karakter sýnýrýný "
					+ "aþýyor!", "Uyarý", 1);
		}
	}
	
	public void guncelle(String tarih, String not) {
		int selectedRow = table.getSelectedRow();
		
		String ID = vt.getID(selectedRowData.get(2));
		vt.updateData(tarih, not, ID);
		
		tableModel.removeRow(selectedRow);
		
		tableModel.insertRow(selectedRow, new Object[] {
				ID, Zaman.Now(), tarih, not
		});
		
		// 1.güncellemeden sonra imleç son iþlemin üzerinde kalýr.
		table.addRowSelectionInterval(selectedRow, selectedRow);
		
		frameGuncelle.setVisible(false);
	}
	
	public void delete(int selectedRow, String id) {
		tableModel.removeRow(selectedRow);
		vt.deleteSelectedRow(id);
	}
	
	public void theFirstReminder() throws SQLException {
		hatirlatma = vt.getFirtReminder();
		String not = strDuzelt(hatirlatma[1]);
		
		JOptionPane.showMessageDialog(null, "En yakýn hatýrlatma tarihi : "
				+ hatirlatma[0] + "\n"
				+ "Hatýrlatma notu : \n" + not
				+ "\nKalan süre : " + z.kacSaatKacDkVar(hatirlatma[0]));
	}
	
	public static String strDuzelt(String not) {
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
		tarih1.setText("");
	}
	
	// istenilen componente tek 1 fonksiyon ile seçilen tarihi yönlendiriyoruz...
	public void dateChose(Component c) {
		final JFrame f = new JFrame();
		((JTextComponent) c).setText(new DatePicker(f).setPickedDate());
		f.pack();
	}
	
	
	public class Dinleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == ajandayaEkle)
					kaydet(tarih1.getText(), not.getText());
				
				else if (e.getSource() == guncelle)
					guncelle(tarih2.getText(), notGuncel.getText());

				else if (e.getSource() == tarihSecimi1)
					dateChose(tarih1);
				
				else if (e.getSource() == tarihSecimi2)
					dateChose(tarih2);
				
				else if (e.getSource() == depo) {
					if (!depoShowing)
						showDepo(vt.getDataForSQL("SELECT * FROM tNotlar"));
				}

				else if (e.getSource() == enYakinHatirlatma)
					theFirstReminder();

				} catch (SQLException sqlEx) {
					logger.error("SQL EXCEPTION -> " + sqlEx.getMessage());
					sqlEx.printStackTrace();
			}
		}	
	}
	
	public static void main(String[] args) throws SQLException, JavaLayerException {
		Ajanda ajnd = new Ajanda();
		thread = new Thread(ajnd);
		thread.start();
	}
}