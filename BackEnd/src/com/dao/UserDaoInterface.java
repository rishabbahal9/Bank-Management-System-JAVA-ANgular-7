package com.dao;

import java.sql.SQLException;

public interface UserDaoInterface {
	
	String checkUserDetails(String userName, String userPassword) throws SQLException;

}
