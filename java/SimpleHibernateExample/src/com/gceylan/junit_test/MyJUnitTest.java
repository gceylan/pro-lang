package com.gceylan.junit_test;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import com.gceylan.service.AccountService;
import com.gceylan.util.HibernateUtil;
import com.gceylan.vo.Account;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MyJUnitTest extends TestCase {
	
	@Test
	public void testCreateAccount() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		Account account = new Account();
		account.setAccountType(Account.ACCOUNT_TYPE_SAVINGS);
		account.setCreationDate(new Date());
		account.setBalance(1000L);
		
		// confirm that there is no accountId set
		Assert.assertTrue(account.getAccountId() == 0);
		
		// save the account
		AccountService accountService = new AccountService();
		accountService.saveOrUpdateAccount(account);
		
		session.getTransaction().commit();
		HibernateUtil.getSessionFactory().close();
		
		System.out.println(account);
		Assert.assertTrue(account.getAccountId() > 0);
	}
}
