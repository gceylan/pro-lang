package com.gceylan.dao;

import org.hibernate.Session;

import com.gceylan.util.HibernateUtil;
import com.gceylan.vo.Account;

/*
 * Hibernate Sessions are NOT thread safe
 * One per thread of execution
 * 
 * */

public class AccountDAO {
	
	public void saveOrUpdateAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// Remember the number of LOC needed to do this with JDBC?
		session.saveOrUpdate(account);
	}
	
	public Account getAccount(long accountId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Account account = (Account) session.get(Account.class, accountId);
		
		return account;
	}
	
	public void deleteAccount(Account account) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.delete(account);
	}

}
