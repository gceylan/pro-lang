import java.sql.*;
import java.util.Vector;
import javax.swing.*;


public class Veritabani {
	
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultset = null;
	
	public Veritabani(String url, String user, String password) {
		connectDatabase(url, user, password);
	}
	
	public void connectDatabase(String url, String user, String password) {
		try {
			connect = DriverManager.getConnection(url, user, password);
		} catch (SQLException sqlEx) {
			JOptionPane.showMessageDialog(null, "Veritabanına Bağlanılamadı!",
					"Hata!", 0);
			sqlEx.printStackTrace();
		}
	}
	
	public void shutDownConnection() throws SQLException {
		try {
			if (connect != null)
				connect.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (resultset != null)
				resultset.close();
			
		} catch (SQLException sqlEx) {
			JOptionPane.showMessageDialog(null, "Veritabanı bağlantısı kapatıla"
					+ "madı!", "Hata!", 0);
			sqlEx.printStackTrace();
		}
	}
	
	public void saveDatabase(String tarih, String not) throws SQLException {
		try {
			String sql = "insert into tNotlar values (default, ?, ?)";
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, tarih);
			preparedStatement.setString(2, not);
			preparedStatement.executeUpdate();
			
			String islenmisNot = Ajanda.strDuzelt(not);
			
			JOptionPane.showMessageDialog(null, "Tarih-saat: " + tarih
					+ "\nNot:\n" + islenmisNot + "\nİşlem Tamamlandı.");
		} catch (SQLException sqlEx) {
			JOptionPane.showMessageDialog(null, "Bilgiler veritabanına "
				+ "kaydedilemedi!", "Hata!", 0);
			sqlEx.printStackTrace();
		}
	}
	
	public Object[][] showDatebase() throws SQLException {
		String sql = "select * from tNotlar";
		Object [][] satirDegerleri = null;
		try {
			preparedStatement = connect.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();
			
			Vector<Object> satirlar = new Vector<Object>();
			
			while (resultset.next()) {
				Object [] degerler = {
						resultset.getString(1),
						resultset.getString(2),
						resultset.getString(3)
				};
				satirlar.add(degerler);
			}
			
			satirDegerleri = new Object[satirlar.size()][3];
			
			for (int i = 0; i < satirlar.size(); i++) {
				satirDegerleri[i] = (Object[]) satirlar.get(i);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Depo Görüntülenemedi!");
			e.printStackTrace();
		}
		
		return satirDegerleri;
	}
	
	public String[] getMetaData(ResultSet resultset) throws SQLException {
		String[] metaData = new String[3];
		try {
			for (int i = 0; i < resultset.getMetaData().getColumnCount(); i++) {
				metaData[i] = resultset.getMetaData().getColumnClassName(i);
			}
		} catch (SQLException exception) {
			JOptionPane.showMessageDialog(null, "Metadata bilgisi alınamadı!");
			exception.printStackTrace();
		}
		return metaData;
	}
	
	public String[] getFirtReminder() throws SQLException {
		Zaman z = new Zaman();
		String[] gonder = new String[2];
		
		double ilk = 9999;
		double gelen;
		
		String ilkHatirlatmaTarihi = null;
		String gelenTarih = null;
		
		String mesaj = null;
		
		String sql = "select * from tNotlar";
		preparedStatement = connect.prepareStatement(sql);
		resultset = preparedStatement.executeQuery();
		
		while (resultset.next()) {
			gelenTarih = resultset.getString("tarih-saat");
			gelen = z.kacSaatVar(gelenTarih);
			if ( gelen >= 1 && gelen <= ilk) {
				ilk = gelen;
				ilkHatirlatmaTarihi = gelenTarih;
				mesaj = resultset.getString("not");
			}
		}
		gonder[0] = ilkHatirlatmaTarihi;
		gonder[1] = mesaj;
		
		return gonder;
	}
}