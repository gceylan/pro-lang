import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class LoginPanel_v2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	String root = "Gökhan", key = "gceylan";
	
	JTextField username, password;
	JButton button1;
	//JRadioButton rbtOgrenci, rbtHoca;
	
	String user, passwd;
	
	public void LoginShow() {
		setLayout(new GridLayout(6, 6, 10, 10));
		
		add(new JLabel("Kullanýcý Adý:"));
		username = new JTextField(20);
		add(username);

		add(new JLabel("Þifre:"));
		password = new JTextField(20);
		add(password);
		
/*		rbtOgrenci = new JRadioButton("Öðrenci");
		rbtOgrenci.addActionListener(this);
		add(rbtOgrenci);
		rbtOgrenci.setSelected(true);
		
		rbtHoca = new JRadioButton("Akademik Personel");
		rbtHoca.addActionListener(this);
		add(rbtHoca);*/
		
		button1 = new JButton("Giriþ");
		add(button1);
		button1.addActionListener(this);
		
		pack();
	}
	
	public void dogruGiris(String user) {
		JOptionPane.showMessageDialog(null, "Hoþgeldiniz...\n" +
						"Merhaba " + user + ".", "Karþýlama Penceresi", 1);
	}
	
	public void yanlisGiris() {
		JOptionPane.showMessageDialog(null, "Kullanýcý adý veya parola hatalý!", "Hata!", 0);
	}
	
	public void uyariMesaji() {
		JOptionPane.showMessageDialog(null, "Bilgilerinizi eksiksiz girin!", "Uyarý", 1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			user = username.getText();
			passwd = password.getText();
			
			if (user.equals(root) && passwd.equals(key)) {
				dogruGiris(user);
			} else if (user.equals("") || passwd.equals("")) {
				uyariMesaji();
			} else {
				yanlisGiris();
			}
		}
	}
		
	
	public static void main(String[] args) {
		LoginPanel_v2 p = new LoginPanel_v2();
		p.LoginShow();
		p.setVisible(true);
		p.setTitle("Login Paneli");
		p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
