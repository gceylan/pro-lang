package net.gceylan.entities;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		OrnekTablo ot = new OrnekTablo();
		ot.setId(1);
		ot.setTanim("tanim");
		ot.setAciklama("aciklama");
		
		s.save(ot);
		t.commit();
		s.close();
	}

}
