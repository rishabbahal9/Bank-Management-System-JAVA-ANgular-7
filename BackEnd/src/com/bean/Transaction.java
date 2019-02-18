package com.bean;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Transaction {
	
	
	
	private int transactionId;
	private double amount;	
	private String transactionStatus;
	private Timestamp lastUpdated;
	//private int transactionSource ;
	private int transactionDestination;
	private int accountNo;
	//private int customerId;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getTransactionDestination() {
		return transactionDestination;
	}
	public void setTransactionDestination(int transactionDestination) {
		this.transactionDestination = transactionDestination;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public Transaction(int transactionId, double amount, String transactionStatus, int transactionDestination,
			int accountNo) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionStatus = transactionStatus;
		this.transactionDestination = transactionDestination;
		this.accountNo = accountNo;
	}
	public Transaction(int transactionId, double amount, String transactionStatus, Timestamp lastUpdated,
			int transactionDestination, int accountNo) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.transactionStatus = transactionStatus;
		this.lastUpdated = lastUpdated;
		this.transactionDestination = transactionDestination;
		this.accountNo = accountNo;
	}



	
	

}
