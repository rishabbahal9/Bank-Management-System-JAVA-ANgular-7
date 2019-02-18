package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;

public interface AccountDaoInterface {
	
	
	public boolean createAccount(Account account, int customerId)throws SQLException;
	public boolean deleteAccount(int accountNo)throws SQLException;
	public Account viewAccountByAccountId(int accountNo) throws SQLException;
	public Account viewAccountByCustomerId(int customerId) throws SQLException;
	public ArrayList<Account> viewAllAccounts() throws SQLException;
	public boolean checkAccount(int accountNo) throws SQLException;
	public boolean deleteAccountByCustId(int customerId) throws SQLException;

	
	
	

}
