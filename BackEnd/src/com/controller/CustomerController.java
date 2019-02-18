package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.bean.User;
import com.google.gson.Gson;
import com.service.AccountService;
import com.service.CustomerService;
import com.service.TransactionService;
import com.service.UserService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController/*")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = null;
	private TransactionService transactionService = null;
	private AccountService accountService = null;

	private CustomerService customerService = null;
	private Gson gson=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        this.customerService = new CustomerService();
        this.userService = new UserService();
        this.transactionService = new TransactionService();
        this.accountService = new AccountService();
        
        this.gson=new Gson();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(request.getPathInfo());
		 
	     String[] pathInfo = request.getPathInfo().split("/");
	     System.out.println(pathInfo);
	     if(pathInfo==null || pathInfo.length<=1){
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("viewAllCustomers")){
	    	 
	    	   ArrayList<Customer> customerList = this.customerService.viewAllcustomers();
	    	   this.sendAsJson(response, customerList);
	    	   return;
	     }
	     
	     else{
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }
	   
		
		
	}
	private void sendAsJson(
			 
			HttpServletResponse response, 
			Object obj) throws IOException {
			
			response.setContentType("application/json");
			
			String res = gson.toJson(obj);
			
			System.out.println(res);
			
			PrintWriter out = response.getWriter();
			  
			out.print(res);
			
			out.flush();
			out.close();
		
		
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] pathInfo = request.getPathInfo().split("/");
		  
	       if(pathInfo==null || pathInfo.length<=1){
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("CreateCustomer")){
	    	 
	    	   BufferedReader reader = request.getReader();
	    	 
	    	    Customer obj = gson.fromJson(reader, Customer.class);
		    	 System.out.println("inside controller");

	    	 System.out.println(obj);
	    	        boolean obj1 = this.customerService.CreateCustomer(obj);
	    	         
	    	         this.sendAsJson(response,obj1);
	    	 
	    	   return;
	     }
	     
	     else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("loginUser")){
	    	   BufferedReader reader = request.getReader();
	    	   System.out.println("*********************"+reader);
	    	    User obj = gson.fromJson(reader, User.class);
		    	   System.out.println("gygubbhub"+obj);

	    	   String userType = userService.checkUserDetails(obj.getUserName(), obj.getUserPassword());
	    	   this.sendAsJson(response, userType);
	    	   return;
	     }
	     
	     
	     else{
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }
		
		
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		 String[] pathInfo = request.getPathInfo().split("/");
		  
	       if(pathInfo==null || pathInfo.length<=1){
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("updateCustomers")){
	    	 
	    	   BufferedReader reader = request.getReader();
	    	 
	    	    Customer obj = gson.fromJson(reader, Customer.class);
	    	 
	    	         boolean message = this.customerService.updateCustomer(obj);
	    	         System.out.println("Message:"+message);
	    	         this.sendAsJson(response,message);
	    	 
	    	   return;
	     }else{
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }
	}

	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] pathInfo = request.getPathInfo().split("/");
		System.out.println("hi");
		if (pathInfo == null || pathInfo.length <= 1) {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);

			return;
		}
		
		
		else if (pathInfo.length >= 2 && pathInfo[1].equalsIgnoreCase("deleteCustomer")) {
	    	 
		     System.out.println("pathinfooooo"+pathInfo);

				//System.out.println("pppppppppphhhhhhhhhhhhhh"+pathInfo.toString());

				int customerId = Integer.parseInt(pathInfo[2]);
				System.out.println("pppppppppp"+customerId);
				//BufferedReader reader = request.getReader();
		    	 
	    	    //int accountNo = gson.fromJson(reader, Integer.class);
				
				System.out.println(customerId);
				boolean transactiondel = this.transactionService.deleteTransaction(customerId);
				boolean accountdel = this.accountService.deleteAccountByCustId(customerId);

				boolean customerdel = this.customerService.deleteCustomer(customerId);

				this.sendAsJson(response, customerdel);

				return;
			} 
		
		else {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);

			return;
		}
	}

	
	
	

	}


