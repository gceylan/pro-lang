package com.gceylan.service;

import com.gceylan.dao.AccountDAO;
import com.gceylan.vo.Account;

public class AccountService {
	
	AccountDAO accountDAO = new AccountDAO();
	
	public void saveOrUpdateAccount(Account account) {
		accountDAO.saveOrUpdateAccount(account);
	}
	
	public Account getAccount(long accountId) {
		return accountDAO.getAccount(accountId);
	}
	
	public void deleteAccount(Account account) {
		accountDAO.deleteAccount(account);
	}

}
