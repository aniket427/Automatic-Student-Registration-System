package com.project.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.project.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean adminLogin(String username, String pass) {
		
		boolean loggedin = false;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from admin where username = ? AND password = ?");			
			
			ps.setString(1, username);
			ps.setString(2, pass);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				
			loggedin = true;
			
		}
			
		} catch (SQLException e) {	
				
			System.out.println(e.getMessage());
		
		}
		
		
		return loggedin;
	}

}
