package com.service;

import java.sql.SQLException;

import com.bean.Customer;
import com.bean.Transaction;

public class Tester {

	public static void main(String[] args) throws SQLException 
	{//Transaction transaction=new Transaction(transactionId, amount, transactionStatus, lastUpdated, transactionSource, transactionDestination)
		Transaction transaction=new Transaction(1, 2324.0, "fg", 208,  208);
		TransactionService tService=new TransactionService();
		System.out.println("nnnnnn"+tService.Withdraw(transaction));

		//System.out.println(tService.Deposit(5000, 1068));
		//System.out.println(tService.Withdraw(20, 101));
		//System.out.println(tService.Deposit(10, 101));
		
		/*System.out.println(tService.Deposit(10, 101));*/
		/*
	
		CustomerService cService=new CustomerService();
		
		Customer customer=new Customer("sdgfs", 34, 87654432, "abc@gmail.com", "znsdbmnbd", "hscscscfs", "sdhfj", "sjdhfjs");
		
		
		System.out.println(cService.viewAllcustomers());		
		
		
		System.out.println(cService.CreateCustomer(customer));
		
		System.out.println(cService.checkCustomer(471));
		System.out.println("*********"+cService.ViewCustomerBySSN(78));


		*/
		/*UserService uService=new UserService();
		System.out.println(uService.checkUserDetails("Dinesh@kartik", "12yvibha"));
		System.out.println(uService.checkUserDetails("virat@kholi", "125sumant"));
	*/
		
		
		
		
		
	}

}
