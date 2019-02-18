package com.service;

import java.sql.SQLException;

import com.dao.UserDao;

public class UserService implements UserServiceInterface {
	
	UserDao userdao=new UserDao();
	
	
	public String checkUserDetails(String userName,String userPassword){
		
		//boolean flag=false;
		String userType=null;
		
		try {
			userType=userdao.checkUserDetails(userName, userPassword);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userType;
	}
	

}
