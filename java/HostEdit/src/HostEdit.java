import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class HostEdit extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField siteAdi;
	JButton ekle, kaydet;
	JTextArea textHost;
	Dinleyici d;
	String filePath = "C:\\Windows\\System32\\drivers\\etc\\hosts";
	
	public HostEdit() throws IOException {
		sistemTemasiniKullan();

		JFrame frame = new JFrame("host edit by gceylan");
		
		d = new Dinleyici();
		
		JPanel ust = new JPanel();
		ust.setLayout(new FlowLayout(10, 10, 5));
		ust.add(new JLabel("Eklenecek Site"));
		
		siteAdi = new JTextField(90);
		siteAdi.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_ENTER) {
					hostsEkle();
				}
				
			}
		});
		
		
		ekle = new JButton("Ekle");
		ekle.addActionListener(d);
		ust.add(siteAdi);
		ust.add(ekle);
		
		JPanel govde = new JPanel();
		govde.setLayout(new BorderLayout(5, 5));
		
		kaydet = new JButton("Kaydet");
		kaydet.addActionListener(d);
		
		Font f = new Font("Arial", Font.PLAIN, 11);
		textHost = new JTextArea(oku(filePath), 33, 105);
		//textHost.setEditable(false);
		textHost.setFont(f);
		JScrollPane spane = new JScrollPane(textHost);
		spane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		govde.add(new JLabel("Windows Hosts Dosyas�"), BorderLayout.NORTH);
		govde.add(spane, BorderLayout.CENTER);
		
		ust.add(govde);
		ust.add(kaydet);
		
		frame.add(ust, BorderLayout.CENTER);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(20, 20, 900, 600);
		frame.setVisible(true);
	}
	
	public String oku(String filePath) {
		BufferedReader bufferedReader = null;
		String foo = null;
		StringBuffer sb = null;
		
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			sb = new StringBuffer();
			
			while((foo = bufferedReader.readLine()) != null) {
				sb.append(foo + "\n");
			}
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
		}
		
		return sb.toString();
	}
	
	public void hostsEkle() {
		String site = siteAdi.getText().toLowerCase().trim();
		// TODO �imdilik idare eder...
		if (site.equals("") || !site.substring(0, 4).equals("www.")) {
			JOptionPane.showMessageDialog(null, "Bir site ad� girin."
					+ "\n�r: www.facebook.com", "Uyar�", 2);
		} else {
			textHost.append("127.0.0.1\t" + site + "\n");
			siteAdi.setText("");
		}
	}
	
	public void hostsKaydet(String filePath) {
		String yeniHosts = textHost.getText();
		BufferedWriter bufferedWriter = null;
		
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(filePath));
			bufferedWriter.write(yeniHosts);
			JOptionPane.showMessageDialog(null, "Kaydedildi.", "Kay�t ba�ar�l�", 3);
		} catch (FileNotFoundException fileEx) {
			JOptionPane.showMessageDialog(null, "Kaydedilemedi!\n"
					+ "Kullan�c� hesap yetkilerinizi kontrol edin.", "Hata!", 0);
			fileEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			try {
				bufferedWriter.flush();
				bufferedWriter.close();
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
		}
	}
	
	private class Dinleyici implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == ekle) {
				hostsEkle();
			}
			else if (e.getSource() == kaydet) {
				hostsKaydet(filePath);
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

	public static void main(String[] args) throws IOException {
		new HostEdit();
	}

}
