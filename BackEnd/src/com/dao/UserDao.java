package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DatabaseUtil;

public class UserDao implements UserDaoInterface{

	
	public String checkUserDetails(String userName,String userPassword) throws SQLException
	{
    
		Connection con=null;
		con=DatabaseUtil.getConnection();
		String query="SELECT * FROM USERSTORE_TVM36_TJA184_GROUP_B WHERE  USER_NAME=? AND USER_PASS=?";
		PreparedStatement ps=null;
		ps=con.prepareStatement(query);
		ps.setString(1, userName);
		ps.setString(2, userPassword);
		ResultSet rs=null;
		rs=	ps.executeQuery();
		if(rs.next())
		{	
		  return rs.getString(4);
		}
		return "not found";
		
	}

	
	
}
