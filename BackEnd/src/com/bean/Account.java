package com.bean;

import java.util.ArrayList;

public class Account {
	
private int	accountNo;
private String accountType;
private double balance;
private String accountStatus;
private int customerId;


public int getAccountNo() {
	return accountNo;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getAccountStatus() {
	return accountStatus;
}
public void setAccountStatus(String accountStatus) {
	this.accountStatus = accountStatus;
}
public Account(int accountNo, String accountType, double balance, String accountStatus) {
	super();
	this.accountNo = accountNo;
	this.accountType = accountType;
	this.balance = balance;
	this.accountStatus = accountStatus;
}
public Account(String accountType, double balance, String accountStatus) {
	super();
	this.accountType = accountType;
	this.balance = balance;
	this.accountStatus = accountStatus;
}
public Account() {
	// TODO Auto-generated constructor stub
}
public Account(int accountNo, String accountType, double balance, String accountStatus, int customerId) {
	super();
	this.accountNo = accountNo;
	this.accountType = accountType;
	this.balance = balance;
	this.accountStatus = accountStatus;
	this.customerId = customerId;
}



}
