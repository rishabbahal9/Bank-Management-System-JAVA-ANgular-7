package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.util.DatabaseUtil;

public class CustomerDao implements CustomerDaoInterface {
	
	
//m1
	public boolean CreateCustomer(Customer customer) throws SQLException 
	
	{
		Connection con=null;		
		con=DatabaseUtil.getConnection();
		String query="INSERT INTO CUSTOMER_TVM36_TJA184_GROUP_B VALUES(sequenceCustomer.NEXTVAL,sequenceSsnId.NEXTVAL,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query);
		ps.setString(1, customer.getCustomerName());
		ps.setInt(2, customer.getCustomerAge());
		ps.setLong(3, customer.getCustomerContact());
		ps.setString(4, customer.getCustomerEmail());
		ps.setString(5, customer.getCustomerAddress1());
		ps.setString(6, customer.getCustomerAddress2());
		ps.setString(7, customer.getCity());
		ps.setString(8, customer.getState());
		int k=0;
		k=ps.executeUpdate();
		if(k>0)
		{	
		return true;
		}
		return false;
	
	}
	

	//m2
	public ArrayList<Customer> ViewCustomerBySSN(int ssnId) throws SQLException {
			
			ArrayList<Customer> customerList=new ArrayList<>();
			
			Connection con=null;
			con=DatabaseUtil.getConnection();
			String query="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE SSN_ID=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query);
			ps.setInt(1, ssnId);
			ResultSet rs=null;
			rs=	ps.executeQuery();
			
			while(rs.next())
			{
				
				Customer customer=new Customer(rs.getInt(1), rs.getInt(2),  rs.getString(3), rs.getInt(4),rs.getLong(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				customerList.add(customer);
			}
					
			return customerList;
		}

	
	//m3
	
	    public ArrayList<Customer> ViewCustomersByName(String customerName) throws SQLException {
			
    	ArrayList<Customer> customerList=new ArrayList<>();
			
			Connection con=null;
			con=DatabaseUtil.getConnection();
			String query="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE CUSTOMER_NAME=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query);
			ps.setString(1, customerName);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				Customer customer=new Customer(rs.getInt(1), rs.getInt(2),  rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				customerList.add(customer);
			}
			return customerList;
		}

		
		
	//m4
	    
		public ArrayList<Customer> ViewCustomersByContact(Long customerContact) throws SQLException {
			
			ArrayList<Customer> customerList=new ArrayList<>();

			
			Connection con=null;
			con=DatabaseUtil.getConnection();
			String query="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE CUSTOMER_CONTACT=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query);
			ps.setLong(1, customerContact);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				Customer customer=new Customer(rs.getInt(1), rs.getInt(2),  rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				customerList.add(customer);
			}
			return customerList;
		}
		
		

		
		
//m5
		public ArrayList<Customer> ViewCustomersByEmail(String customerEmail) throws SQLException {
			ArrayList<Customer> customerList=new ArrayList<>();

			
			Connection con=null;
			con=DatabaseUtil.getConnection();
			String query="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE CUSTOMER_EMAIL=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query);
			ps.setString(1, customerEmail);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				Customer customer=new Customer(rs.getInt(1), rs.getInt(2),  rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				customerList.add(customer);
			}
			return customerList;
		}

		
		
		
//m6		
		public ArrayList<Customer> viewCustomersByCity(String city) throws SQLException {
			// TODO Auto-generated method stub
			
			ArrayList<Customer> customerList=new ArrayList<>();

			Connection con=null;
			con=DatabaseUtil.getConnection();
			String query1="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE CITY=?";
			
			PreparedStatement ps=null;
			ps=con.prepareStatement(query1);
			ps.setString(1,city);
			ResultSet rs=null;
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				Customer customer=new Customer(rs.getInt(1), rs.getInt(2),  rs.getString(3), rs.getInt(4),rs.getInt(5),rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				customerList.add(customer);
			}
			return customerList;
		}
		
		
		
		
//m7		
		public ArrayList<Customer> viewAllcustomers() throws SQLException
		{
			Connection con=null;
			ArrayList<Customer> customerList=new ArrayList<Customer>();
			
			con=DatabaseUtil.getConnection();
			String query1="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query1);
			ResultSet rs=null;
			rs=ps.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getLong(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
				customerList.add(customer);
				
			}
			return customerList;
		}

	
//m8		
		public boolean updateCustomer(Customer customer) throws SQLException {
			
			// TODO Auto-generated method stub
			
			
			Connection con=DatabaseUtil.getConnection();
			String query1="UPDATE CUSTOMER_TVM36_TJA184_GROUP_B SET CUSTOMER_NAME=?,CUSTOMER_AGE=?,CUSTOMER_CONTACT=?,CUSTOMER_EMAIL=?,CUSTOMER_ADDRESS_1=?,CUSTOMER_ADDRESS_2=?,CITY=?,STATE=? WHERE CUSTOMER_ID=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query1);
			ps.setString(1,customer.getCustomerName());
			ps.setInt(2,customer.getCustomerAge());
			ps.setLong(3,customer.getCustomerContact());
			ps.setString(4,customer.getCustomerEmail());
			ps.setString(5,customer.getCustomerAddress1());
			ps.setString(6,customer.getCustomerAddress2());
			ps.setString(7,customer.getCity());
			ps.setString(8, customer.getState());
			ps.setInt(9, customer.getCustomerId());
			
			
			
			ResultSet rs=null;
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			return false;
			
			
		}

		
//m9a
		public boolean checkAccountStatus(int customerId) throws SQLException
		{
			Connection con=null;		
			con=DatabaseUtil.getConnection();
			String query4="SELECT * FROM ACCOUNT_TVM36_TJA184_GROUP_B WHERE ACCOUNT_STATUS='Deactivated' AND CUSTOMER_ID=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query4);
			ps.setInt(1, customerId);

			ResultSet rs=null;
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
			
			return false;
		}

		
		
//M9b		
		

//m10	
		
		
		
		public boolean deleteCustomer(int customerId) throws SQLException {
			// TODO Auto-generated method stub
			
			Connection con=null;		
			con=DatabaseUtil.getConnection();
			String query3="DELETE FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE CUSTOMER_ID=?";
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
		
		
		
		public boolean checkCustomer(int ssnId) throws SQLException {
			// TODO Auto-generated method stub
			Connection con=null;		
			con=DatabaseUtil.getConnection();
			String query4="SELECT * FROM CUSTOMER_TVM36_TJA184_GROUP_B WHERE SSN_ID=?";
			PreparedStatement ps=null;
			ps=con.prepareStatement(query4);
			ps.setInt(1, ssnId);

			ResultSet rs=null;
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
			
			return false;
			
		}



	

}
