package com.dao;
import java.sql.Timestamp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Transaction;
import com.util.DatabaseUtil;

public class TransactionDao implements TransactionDaoInterface{

	
//m1	
public boolean Deposit(double amount,int accountNo) throws SQLException{
		
		Connection con=DatabaseUtil.getConnection();
		String query="UPDATE TRANS_TVM36_TJA184_GROUP_B SET AMOUNT=? WHERE ACCOUNT_NO=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setDouble(1, amount);
		ps.setInt(2, accountNo);		
		int i=ps.executeUpdate();
		if(i>0){
			return true;
		}
		return false;
		
		}
//A1
public boolean AccountDeposit(double amount,int accountNo) throws SQLException{
	
	Connection con=DatabaseUtil.getConnection();
	String query="UPDATE ACCOUNT_TVM36_TJA184_GROUP_B SET BALANCE=BALANCE+? WHERE ACCOUNT_NO=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setDouble(1, amount);
	ps.setInt(2, accountNo);		
	int i=ps.executeUpdate();
	if(i>0){
		return true;
	}
	return false;
	
	}

//m2	
public boolean Withdraw(Transaction transactionObj) throws SQLException{
	
	
	Connection con=DatabaseUtil.getConnection();
	//INSERT INTO TRANS_TVM36_TJA184_GROUP_B VALUES(sequenceTransaction.nextval,56,'Completed',SYSTIMESTAMP,208,209,208,1063)
	String query="INSERT INTO TRANS_TVM36_TJA184_GROUP_B VALUES(sequenceTransaction.nextval,?,'Completed',SYSTIMESTAMP,?,?)";
	//String query="UPDATE TRANS_TVM36_TJA184_GROUP_B SET AMOUNT=AMOUNT-? WHERE ACCOUNT_NO=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setDouble(1, transactionObj.getAmount());
	ps.setInt(2, transactionObj.getTransactionDestination());
	//ps.setInt(3, transactionObj.getAccountNo());
	ps.setInt(3, transactionObj.getAccountNo());
	//ps.setInt(5, transactionObj.getCustomerId());
	int i=ps.executeUpdate();
	if(i>0){
		return true;
	}
	return false;
	
	
}
//A2	
public boolean AccountWithdraw(double amount,int accountNo) throws SQLException{
	
	
	Connection con=DatabaseUtil.getConnection();
	String query="UPDATE ACCOUNT_TVM36_TJA184_GROUP_B SET BALANCE=BALANCE-? WHERE ACCOUNT_NO=?";
	//String query="UPDATE TRANS_TVM36_TJA184_GROUP_B SET AMOUNT=AMOUNT-? WHERE ACCOUNT_NO=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setDouble(1, amount);
	ps.setInt(2, accountNo);
	int i=ps.executeUpdate();
	if(i>0){
		return true;
	}
	return false;
	
	
}


//m3

public ArrayList<Transaction> viewTransactionByAccountId(int accountId) throws SQLException{
	 ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
	Connection con=DatabaseUtil.getConnection();
	String query="SELECT * FROM TRANS_TVM36_TJA184_GROUP_B ORDER BY LAST_UPDATED DESC WHERE ACCOUNT_NO=?";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, accountId);
	ResultSet rs=ps.executeQuery();
	Transaction transaction=null;
		
	while(rs.next()){
		
		transaction=new Transaction(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
		transactionList.add(transaction);

	}
	
	return transactionList;
	
	
}

//m4
public  ArrayList<Transaction> viewTransactionByCustomerId(int customerId) throws SQLException
{
	 ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
		Connection con=null;
		con=DatabaseUtil.getConnection();
		String query1="SELECT * FROM TRANS_TVM36_TJA184_GROUP_B WHERE ORDER BY LAST_UPDATED CUSTOMER_ID=?";
		
		PreparedStatement ps=null;
		ps=con.prepareStatement(query1);
		ps.setInt(1, customerId);
		ResultSet rs=ps.executeQuery();

		while(rs.next())
		{
			Transaction transaction=new Transaction(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
			transactionList.add(transaction);
		}
		return transactionList;
		
}


//m5	
public ArrayList<Transaction> viewAllTransactions(Timestamp lastUpdated ) throws SQLException
	
	{
		 ArrayList<Transaction> transactionList=new ArrayList<Transaction>();
			Connection con=null;
			con=DatabaseUtil.getConnection();
			String query1="SELECT * FROM TRANS_TVM36_TJA184_GROUP_B WHERE LAST_UPDATED=?";
			
			PreparedStatement ps=null;
			ps=con.prepareStatement(query1);
			ps.setTimestamp(1,lastUpdated);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Transaction transaction=new Transaction(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4), rs.getInt(5), rs.getInt(6));
				transactionList.add(transaction);
				}
			return transactionList;
			
			
		
	}

public boolean deleteTransaction(int customerId) throws SQLException
{
	// TODO Auto-generated method stub
	
	Connection con=null;		
	con=DatabaseUtil.getConnection();
	String query3="DELETE FROM TRANS_TVM36_TJA184_GROUP_B WHERE CUSTOMER_ID=?";
	PreparedStatement ps=null;
	ps=con.prepareStatement(query3);
	ps.setInt(1, customerId);
	int i=ps.executeUpdate();
	if(i>0)
	{
		return true;
	}
	
	
	return false;
}

}
