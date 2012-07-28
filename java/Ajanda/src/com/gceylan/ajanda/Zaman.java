package com.gceylan.ajanda;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Zaman implements Runnable {
	
	boolean sesCalinsinMi;
	private static Thread thread;
	
	public Zaman() {
		sesCalinsinMi = false;
	}
	
	public static String Now() 	{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
	    String strTime = sdf.format(now);
	    return strTime;
	}

	public Date convertToDate(String s) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date utilDate = dateFormat.parse(s, pos);
		return utilDate;
	}
	
	// uyarý verirken kullanildi.
	public String kacSaatKacDkVar(String date) { 
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();
		
		long gun  = ((l2-l1) / (1000*60*60*24));
		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = ((l2-l1) / (1000 * 60));
		long sn = (l2-l1) / 1000;
		
		String neKadar = "" + 
				((gun == 0) ? "" : gun + " gün ") +
				((((saat % 60) % 24) == 0) ? "" : (saat % 60) % 24 + " sa ") +
				(((dk % 60) == 0) ? "" : dk % 60 + " dk ") + sn % 60 + " sn";
		
		return neKadar;
	}
	
	public int kalanSure(String date) {
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();

		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = (((l2-l1) / (1000 * 60))) % 60;
		long sn = ((l2-l1) / 1000) % 60;
		
		String s = saat + "" + dk + "" + sn;
		
		return Integer.parseInt(s);
	}
	
	// ilk hatirlatmayi bulmada kullanildi.
	public double kacSaatVar(String date) {
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();
		
		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = ((l2-l1) / (1000 * 60)) % 60;

		return saat + dk / 100.0;
	}
	
	// Burasi pek Dry olmadi.
	public boolean sesCalinsinMi(String date) {
		Zaman z = new Zaman();
		
		long l1 = z.convertToDate(Zaman.Now()).getTime();
		long l2 = z.convertToDate(date).getTime();

		long saat = ((l2-l1) / (1000 * 60 * 60));
		long dk = (((l2-l1) / (1000 * 60))) % 60;
		long sn = ((l2-l1) / 1000) % 60;
		
		String kalanSure = saat + ":" + dk + ":" + sn;
		// System.out.println(kalanSure); // 1:0:59
		
		sesCalinsinMi = kalanSure.equals("1:0:1") ? true : false;

		return sesCalinsinMi;
	}
	
	public void kalanSureler(String tarih) {
		System.out.println(kacSaatKacDkVar(tarih));
		System.out.println(kacSaatVar(tarih));
		System.out.println(sesCalinsinMi(tarih));
		System.out.println(kalanSure(tarih)); // int
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		while (true) {
			try {
				thread.sleep(1000);
				
				// girilen tarihi kalan süre...
				kalanSureler("10-08-2012 18:00:00");
				
				System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Zaman z = new Zaman();
		thread = new Thread(z);
		thread.start();
	}
}