package com.service;



import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.dao.CustomerDao;


public class CustomerService implements CustomerServiceInterface {

	CustomerDao customerdao=new CustomerDao();

	@Override
	public boolean CreateCustomer(Customer customer)  {
		
		boolean flag=false;
		try {
			if(flag=customerdao.CreateCustomer(customer))
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public ArrayList<Customer> ViewCustomerBySSN(int ssnId)  {
		
		ArrayList<Customer> customerList=new ArrayList<>();
		
		try {
			customerList=customerdao.ViewCustomerBySSN(ssnId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerList;
	}

	@Override
	public ArrayList<Customer> ViewCustomersByName(String customerName) {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerList=new ArrayList<>();
		
		try {
			customerList=customerdao.ViewCustomersByName(customerName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
	}

	@Override
	public ArrayList<Customer> ViewCustomersByContact(Long customerContact)  {
ArrayList<Customer> customerList=new ArrayList<>();
		
		try {
			customerList=customerdao.ViewCustomersByContact(customerContact);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
	}

	@Override
	public ArrayList<Customer> ViewCustomersByEmail(String customerEmail)  {
		// TODO Auto-generated method stub
ArrayList<Customer> customerList=new ArrayList<>();
		
		try {
			customerList=customerdao.ViewCustomersByEmail(customerEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
	}

	@Override
	public ArrayList<Customer> viewCustomersByCity(String city)  {
		
ArrayList<Customer> customerList=new ArrayList<>();
		
		try {
			customerList=customerdao.viewCustomersByCity(city);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
	}
		
		
	

	@Override
	public ArrayList<Customer> viewAllcustomers() {
ArrayList<Customer> customerList=new ArrayList<>();
		
		try {
			customerList=customerdao.viewAllcustomers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
	}
		
		
	

	@Override
	public boolean updateCustomer(Customer customer)  {
		boolean flag=false;
		
		try {
			
			flag=customerdao.updateCustomer(customer);
			
			if(flag==true){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteCustomer(int ssnId)  {
	boolean flag=false;
		
		try {
			
			flag=customerdao.deleteCustomer(ssnId);
			
			if(flag==true){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean checkCustomer(int ssnId)  {
	boolean flag=false;
		
		try {
			
			flag=customerdao.checkCustomer(ssnId);
			
			if(flag==true){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	
	}