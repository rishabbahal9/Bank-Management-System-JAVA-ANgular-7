package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;
import com.bean.Transaction;
import com.google.gson.Gson;
import com.service.CustomerService;
import com.service.TransactionService;
import com.service.UserService;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/TransactionController/*")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = null;

	private TransactionService transactionService = null;
	private Gson gson=new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
    	  super();
    	 this.transactionService = new TransactionService();
         this.userService = new UserService();

         this.gson=new Gson();
      
        // TODO Auto-generated constructor stub
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] pathInfo = request.getPathInfo().split("/");
		  
	       if(pathInfo==null || pathInfo.length<=1){
	    	 
	    	 response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	 return;
	     }
	       else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("Deposit")){
	    	 
	    	   BufferedReader reader = request.getReader();
	    	 
	    	    Transaction obj = gson.fromJson(reader, Transaction.class);
	    	   
		    	 System.out.println("inside controller");

	    	 System.out.println(obj);
	    	        boolean obj1 = this.transactionService.Deposit(obj.getAmount(),obj.getAccountNo());
	    	         
	    	         this.sendAsJson(response,obj1);
	    	 
	    	   return;
	     }
	       
	       
	       
	       
	       else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("Withdraw")){
		    	 
	    	   BufferedReader reader = request.getReader();
	    	 
	    	    Transaction obj = gson.fromJson(reader, Transaction.class);
	    	   
		    	 System.out.println("inside controller");

	    	 System.out.println(obj);
	    	        boolean obj1 = this.transactionService.Withdraw(obj.getAmount(),obj.getAccountNo());
	    	         
	    	         this.sendAsJson(response,obj1);
	    	 
	    	   return;
	     }
	       
	       
	       
	       
	       else if(pathInfo.length>=2 &&  pathInfo[1].equalsIgnoreCase("Transfer")){
		    	 
	    	   BufferedReader reader = request.getReader();
	    	 
	    	    Transaction obj = gson.fromJson(reader, Transaction.class);
	    	   
		    	 System.out.println("inside controller");

	    	 System.out.println(obj);
	    	        boolean obj1=false;
					try {
						obj1 = this.transactionService.Transfer(obj.getAmount(),obj.getTransactionSource(),obj.getTransactionDestination());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	         
	    	         this.sendAsJson(response,obj1);
	    	 
	    	   return;
	     }
	       
	       
	       
         else{
	    	 
	    	   response.sendError(HttpServletResponse.SC_BAD_REQUEST);
	    	   return;
	         }
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
