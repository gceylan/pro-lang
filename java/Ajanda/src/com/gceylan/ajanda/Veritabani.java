package com.gceylan.ajanda;

import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;

import org.apache.log4j.Logger;


public class Veritabani {
	
	private static final Logger logger = Logger.getLogger(Veritabani.class);
	
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
			logger.error("VERÝTABANINA BAÐLANILAMADI!");
			JOptionPane.showMessageDialog(null, "Veritabanýna Baðlanýlamadý!",
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
			logger.error("VERÝTABANI BAÐLANTISI KAPATILAMADI!");
			JOptionPane.showMessageDialog(null, "Veritabaný baðlantýsý kapatýla"
					+ "madý!", "Hata!", 0);
			sqlEx.printStackTrace();
		}
	}
	
	public void saveData(String tarih, String not) {
		String sql = "insert into tNotlar values (default, ?, ?, ?)";
		
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Zaman.Now());
			preparedStatement.setString(2, tarih);
			preparedStatement.setString(3, not);
			preparedStatement.executeUpdate();

			String islenmisNot = Ajanda.strDuzelt(not);

			JOptionPane.showMessageDialog(null, "Tarih-saat: " + tarih
					+ "\nNot:\n" + islenmisNot + "\nÝþlem Tamamlandý.");
		} catch (SQLException sqlEx) {
			logger.error("BÝLGÝLER VERÝTABANINA KAYDEDÝLEMEDÝ!");
			JOptionPane.showMessageDialog(null, "Bilgiler veritabanýna "
				+ "kaydedilemedi!", "Hata!", 0);
			sqlEx.printStackTrace();
		}
	}
	
	public void updateData(String tarih, String not, String id) {
		String sql = "UPDATE tNotlar SET tNotlar.kayit_tarihi=?, tNotlar.alarm=?, " +
					"tNotlar.not=? WHERE id=?";
		
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, Zaman.Now());
			preparedStatement.setString(2, tarih);
			preparedStatement.setString(3, not);
			preparedStatement.setString(4, id);
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// TODO alarm tarihinden id buluyoruz. çünkü güncelleme iþlemleri buna göre yapýlacak.
	public String getID(String date) {
		String sql = "SELECT * FROM tNotlar where alarm=?";
		String id = null;
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, date);
			resultset = preparedStatement.executeQuery();
			
			id = (resultset.next()) ? resultset.getString(1) : "-1";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	public Object[][] getDataForSQL(String sql) throws SQLException {
		Object [][] satirDegerleri = null;
		try {
			preparedStatement = connect.prepareStatement(sql);
			resultset = preparedStatement.executeQuery();
			
			Vector<Object> satirlar = new Vector<Object>();
			
			while (resultset.next()) {
				Object [] degerler = {
						resultset.getString(1),
						resultset.getString(2),
						resultset.getString(3),
						resultset.getString(4)
				};
				satirlar.add(degerler);
			}
			
			satirDegerleri = new Object[satirlar.size()][3];
			
			for (int i = 0; i < satirlar.size(); i++) {
				satirDegerleri[i] = (Object[]) satirlar.get(i);
			}
			
		} catch (SQLException e) {
			logger.error("DEPO GÖRÜNTÜLENEMEDÝ!");
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
			JOptionPane.showMessageDialog(null, "Metadata bilgisi alýnamadý!");
			exception.printStackTrace();
		}
		return metaData;
	}
	
	public void deleteSelectedRow(String id) {
		String sql = "DELETE from tNotlar where id=?";
		
		try {
			preparedStatement = connect.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			logger.error("SATIR SÝLÝNEMEDÝ!");
			e.printStackTrace();
		}
	}
	
	public String[] getFirtReminder() throws SQLException {
		Zaman z = new Zaman();
		String[] gonder = new String[2];
		
		String ilkHatirlatmaTarihi = null;
		String hatirlatmaTarihi = null;
		
		String mesaj = null;
		
		String sql = "select * from tNotlar";
		preparedStatement = connect.prepareStatement(sql);
		resultset = preparedStatement.executeQuery();
		
		double ilk = 9999;
		double alarmaKacSaatVar;
		
		while (resultset.next()) {
			hatirlatmaTarihi = resultset.getString("alarm");
			alarmaKacSaatVar = z.kacSaatVar(hatirlatmaTarihi);
			// System.out.println( alarmaKacSaatVar );
			if ( alarmaKacSaatVar >= 1 && alarmaKacSaatVar <= ilk ) {
				ilk = alarmaKacSaatVar;
				ilkHatirlatmaTarihi = hatirlatmaTarihi;
				mesaj = resultset.getString("not");
			}
		}
		gonder[0] = ilkHatirlatmaTarihi;
		gonder[1] = mesaj;
		
		return gonder;
	}
	
	public static void main(String[] args) throws SQLException {
		Veritabani vt = new Veritabani("jdbc:mysql://localhost/dbAjanda", "root", "ben13753535866");
		String[] dizi = vt.getFirtReminder();
		System.out.println(Arrays.toString(dizi));
		
		System.out.println(vt.getID("10-08-2012 18:00:00"));
	}
}