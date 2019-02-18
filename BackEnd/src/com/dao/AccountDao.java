package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;
import com.util.DatabaseUtil;

public class AccountDao implements AccountDaoInterface {
//m1	
	public boolean createAccount(Account account, int customerId) throws SQLException
	{
		Connection con=null;		
		con=DatabaseUtil.getConnection();
		String query4="INSERT INTO ACCOUNT_TVM36_TJA184_GROUP_B VALUES(sequenceAccount.NEXTVAL,?,?,?,?)";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query4);
		ps.setString(1, account.getAccountType());
		ps.setDouble(2, account.getBalance());
		ps.setString(3, account.getAccountStatus());
		ps.setInt(4, customerId);
		int k=0;
		k=ps.executeUpdate();
		if(k>0)
		{	
		return true;
		}
		return false;

	}

//m2A
	public boolean checkAccountStatus(int accountNo) throws SQLException
	{
		Connection con=null;		
		con=DatabaseUtil.getConnection();
		String query4="SELECT * FROM ACCOUNT_TVM36_TJA184_GROUP_B WHERE ACCOUNT_STATUS='Deactivated' AND ACCOUNT_NO=?";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query4);
		ps.setInt(1, accountNo);

		ResultSet rs=null;
		rs=ps.executeQuery();
		if(rs.next())
		{
			return true;
		}
		
		
		return false;
	}

	
//M2b	
	


//m3	
	public Account viewAccountByAccountId(int accountNo) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DatabaseUtil.getConnection();
		String query4="SELECT * FROM ACCOUNT_TVM36_TJA184_GROUP_B WHERE ACCOUNT_NO=?";
		
		PreparedStatement ps=null;
		ps=con.prepareStatement(query4);
		ps.setInt(1,accountNo);
		ResultSet rs=null;
		rs=ps.executeQuery();
		Account account=null;
		while(rs.next())
		{
			 account=new Account(rs.getInt(1), rs.getString(2), rs.getDouble(4), rs.getString(3));
		
		}
		
		return account;		
		
	}


//m4
	public Account viewAccountByCustomerId(int customerId) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Connection con=null;
		con=DatabaseUtil.getConnection();
		String query1="SELECT * FROM ACCOUNT_TVM36_TJA184_GROUP_B WHERE CUSTOMER_ID=?";
		
		PreparedStatement ps=null;
		ps=con.prepareStatement(query1);
		ps.setInt(1,customerId);
		ResultSet rs=null;
		rs=ps.executeQuery();
		Account account=null;
		while(rs.next())
		{
			 account=new Account(rs.getInt(1), rs.getString(2), rs.getDouble(4), rs.getString(3));
		
		}
		
		return account;
		
		
	}


	
//m5
	public ArrayList<Account> viewAllAccounts() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		con=DatabaseUtil.getConnection();
		ArrayList<Account> accountList=new ArrayList<Account>();
		String query2="SELECT * FROM ACCOUNT_TVM36_TJA184_GROUP_B";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query2);
		ResultSet rs=null;
		rs=ps.executeQuery();
		Account account=null;
		while(rs.next())
		{
			 account=new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4),rs.getInt(5));
		     accountList.add(account);
		}
		
		return accountList;
	}

	
//m6	
	public boolean checkAccount(int accountNo) throws SQLException {
		// TODO Auto-generated method stub\
		Connection con=null;
		con=DatabaseUtil.getConnection();
		String query3="SELECT * FROM ACCOUNT_TVM36_TJA184_GROUP_B WHERE ACCOUNT_NO=?";
		
		PreparedStatement ps=null;
		ps=con.prepareStatement(query3);
		ps.setInt(1,accountNo);
		ResultSet rs=null;
		rs=ps.executeQuery();
		if(rs.next())
		{
			return true;		
		}
		
		return false;
		
		
		
	}

	
	
	public boolean deleteAccount(int accountNo) throws SQLException
	{
		Connection con=DatabaseUtil.getConnection();
		String query1="UPDATE  ACCOUNT_TVM36_TJA184_GROUP_B SET ACCOUNT_STATUS='Deactivated' WHERE ACCOUNT_NO=?";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query1);
		ps.setInt(1, accountNo);
		int k=0;
		k=ps.executeUpdate();
		if(k>0)
		{	
		return true;
		}
		return false;
		
		
	}
	
	
	public boolean deleteAccountByCustId(int customerId) throws SQLException
	{
		Connection con=DatabaseUtil.getConnection();
		String query1="DELETE FROM  ACCOUNT_TVM36_TJA184_GROUP_B  WHERE CUSTOMER_ID=?";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query1);
		ps.setInt(1, customerId);
		int k=0;
		k=ps.executeUpdate();
		if(k>0)
		{	
		return true;
		}
		return false;
		
		
	}
	
	
	
	
	
	

}
