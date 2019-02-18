package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;
import com.dao.AccountDao;

public class AccountService implements AccountServiceInterface{

	
	AccountDao accountdao=new AccountDao();
	
	public boolean createAccount(Account account, int customerId)  {
		boolean flag;
		try {
			flag=accountdao.createAccount(account, customerId);
			if(flag)
			{
			   return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;		
	}

	

	
	@Override
	public boolean deleteAccount(int accountNo)  {
		boolean flag;
		try {
			flag=accountdao.deleteAccount(accountNo);
			if(flag)
			{
			   return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	@Override
	public Account viewAccountByAccountId(int accountNo)  {
		Account account =new Account();
		try {
			account=accountdao.viewAccountByAccountId(accountNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}

	
	
	
	@Override
	public Account viewAccountByCustomerId(int customerId)  {
		
		
		Account account =new Account();
		try {
			account=accountdao.viewAccountByCustomerId(customerId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}


	
	
	@Override
	public ArrayList<Account> viewAllAccounts()  {
		ArrayList<Account> accountList=new ArrayList<Account>();
		try {
			accountList=accountdao.viewAllAccounts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountList;
	}

	
	
	
	@Override
	public boolean checkAccount(int accountNo)  {
		
		boolean flag;
		try {
			flag=accountdao.checkAccount(accountNo);
			if(flag)
			{
			   return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean deleteAccountByCustId(int customerId)
	{
		boolean flag;
		try {
			flag=accountdao.deleteAccountByCustId(customerId);
			if(flag)
			{
			   return true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
