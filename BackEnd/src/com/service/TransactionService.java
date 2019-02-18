package com.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Transaction;
import com.dao.TransactionDao;

public class TransactionService implements TransactionServiceInterface 
{
	TransactionDao transactiondao=new TransactionDao();
	@Override
	public boolean Deposit(double amount, int accountNo)  
	{
		boolean flag;
		try {
			flag=transactiondao.Deposit(amount, accountNo);
			if(flag)
			{
				boolean flag2=transactiondao.AccountDeposit(amount, accountNo);
				return flag2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Withdraw(Transaction transactionObj)  
	{
		boolean flag;
		try {
			flag=transactiondao.Withdraw(transactionObj);
			if(flag)
			{
				boolean flag2=transactiondao.AccountWithdraw(transactionObj.getAmount(), transactionObj.getAccountNo());
				return flag2;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Transaction> viewTransactionByAccountId(int accountId)  
	{
		 ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
		 try {
			transactionList=transactiondao.viewTransactionByAccountId(accountId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return transactionList;
	}

	@Override
	public ArrayList<Transaction> viewAllTransactions(Timestamp lastUpdated)  {
		 ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
		 try {
			transactionList=transactiondao.viewAllTransactions(lastUpdated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return transactionList;
	}

	@Override
	public ArrayList<Transaction> viewTransactionByCustomerId(int customerId) 
	{
		 ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
		 try {
			transactionList=transactiondao.viewTransactionByCustomerId(customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return transactionList;
		
	}
/*
	@Override
	public boolean Transfer(double amount, int transactionSource, int transactionDestination) throws SQLException {
		boolean withdrawStatus=false;
		boolean depositStatus=false;
		withdrawStatus=Withdraw(amount, transactionSource);
		depositStatus=Deposit(amount,transactionDestination);
		if(depositStatus==true && withdrawStatus==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	*/
	
	public boolean deleteTransaction(int customerId) 
	{
		boolean flag;
		try {
			flag=transactiondao.deleteTransaction(customerId);
			if(flag)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
