package com.gceylan.vo;

import java.util.Date;

/*
 * 
 * Step 1 - Define Domain Model (ACCOUNT) (JPA)
 * Step 2 - Setup your Hibernate configuration (hibernate.cfg.xml)
 * Step 3 - Create the domain object mapping file <domain_object>.hbm.xml
 * Step 4 - Make Hibernate aware of the mapping files
 * 		(update the hibernate.cfg.xml with list of mapping files)
 * Step 5 - Implement a HibernateUtil class
 * Step 6 - Write your code
 * 
 * */

public class Account {
	
	public static final String ACCOUNT_TYPE_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_TYPE_CHECKING = "CHECKING";
	
	private long accountId;
	private String accountType;
	private Date creationDate;
	private double balance;
	
	public long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer(512);
		
		sb.append("\n----ACCOUNT----\n");
		sb.append("accountId=" + accountId + "\n");
		sb.append("accountType=" + accountType + "\n");
		sb.append("creationDate=" + creationDate + "\n");
		sb.append("balance=" + balance + "\n");
		sb.append("----ACCOUNT----\n");
		
		return sb.toString();
	}
}
