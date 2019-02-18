package com.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Transaction;

public interface TransactionServiceInterface {

	public boolean Deposit(double amount,int accountNo) throws SQLException;
	public boolean Withdraw(Transaction transactionObj) throws SQLException;
	//public boolean Transfer(double amount,int transactionSource,int transactionDestination) throws SQLException;
	public ArrayList<Transaction> viewTransactionByAccountId(int accountId) throws SQLException;
	public ArrayList<Transaction> viewAllTransactions(Timestamp lastUpdated ) throws SQLException;
	public  ArrayList<Transaction> viewTransactionByCustomerId(int customerId) throws SQLException;
	public boolean deleteTransaction(int customerId) throws SQLException;


}
