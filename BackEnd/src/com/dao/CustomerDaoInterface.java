package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;

public interface CustomerDaoInterface {
	

	public boolean CreateCustomer(Customer customer) throws SQLException;
	public ArrayList<Customer> ViewCustomerBySSN  (int ssnId) throws SQLException;
    public ArrayList<Customer> ViewCustomersByName  (String customerName) throws SQLException;
   	public ArrayList<Customer> ViewCustomersByContact(Long customerContact)throws SQLException;
   	public ArrayList<Customer> ViewCustomersByEmail(String customerEmail)throws SQLException;
	public ArrayList<Customer> viewCustomersByCity(String city) throws SQLException;
	public ArrayList<Customer> viewAllcustomers() throws SQLException;
	public boolean updateCustomer(Customer customer) throws SQLException;
	public boolean deleteCustomer(int ssnId) throws SQLException;
	public boolean checkCustomer(int ssnId) throws SQLException;
	
	

}
