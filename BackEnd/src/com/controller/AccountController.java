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

import com.bean.Account;
import com.bean.Customer;
import com.bean.User;
import com.google.gson.Gson;
import com.service.AccountService;
import com.service.CustomerService;
import com.service.TransactionService;
import com.service.UserService;

/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController/*")
public class AccountController extends HttpServlet {
	
	private UserService userService = null;
	private TransactionService transactionService=new TransactionService();
	private AccountService accountService = new AccountService();
	private Gson gson=new Gson();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
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
    public AccountController() {
        super();
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
	     }else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("viewAllAccounts")){
	    	 
	    	   ArrayList<Account> accountList = this.accountService.viewAllAccounts();
	    	  
	    	   this.sendAsJson(response, accountList);
	    	   return;
	     }
		 
		 
		 else if (pathInfo.length >= 2 && pathInfo[1].equalsIgnoreCase("viewAccountByAccountId")) {
			int accountNo = Integer.parseInt(pathInfo[2]);
			Account account = this.accountService.viewAccountByAccountId(accountNo);
			this.sendAsJson(response, account);

			return;
		} 
	     
	     else{
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] pathInfo = request.getPathInfo().split("/");
		  
	       if(pathInfo==null || pathInfo.length<=1){
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("createAccount")){
	    	 System.out.println("inside insert account{{{{{{{{{{{{{");
	    	 System.out.println("inside controller valuessssss");

	    	   BufferedReader reader = request.getReader();
	    	 
	    	    Account obj = gson.fromJson(reader, Account.class);
		    	 System.out.println("inside controller");

	    	 System.out.println(obj);
	    	        boolean obj1 = this.accountService.createAccount(obj,obj.getCustomerId());
	    	         
	    	         this.sendAsJson(response,obj1);
	    	 
	    	   return;
	     }
	     
	     /*else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("loginUser")){
	    	   BufferedReader reader = request.getReader();
	    	   System.out.println("*********************"+reader);
	    	    User obj = gson.fromJson(reader, User.class);
		    	   System.out.println("gygubbhub"+obj);

	    	   String userType = userService.checkUserDetails(obj.getUserName(), obj.getUserPassword());
	    	   this.sendAsJson(response, userType);
	    	   return;
	     }*/
	     
	     
	     else{
	    	 
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
		
		
		else if (pathInfo.length >= 2 && pathInfo[1].equalsIgnoreCase("deleteAccount")) {
	    	 
		     System.out.println("pathinfooooo"+pathInfo);

				//System.out.println("pppppppppphhhhhhhhhhhhhh"+pathInfo.toString());

				int accountNo = Integer.parseInt(pathInfo[2]);
				System.out.println("pppppppppp"+accountNo);
				//BufferedReader reader = request.getReader();
		    	 
	    	    //int accountNo = gson.fromJson(reader, Integer.class);
				
				System.out.println(accountNo);
				boolean result = this.accountService.deleteAccount(accountNo);

				this.sendAsJson(response, result);

				return;
			} 
		
		else {

			response.sendError(HttpServletResponse.SC_BAD_REQUEST);

			return;
		}
	}
	

}
