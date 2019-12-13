package com.dao;
import com.controller.*;
import com.model.*;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao {
	Connection con;
	public LoginDao()
	{
		
	}
	//sql is check type exception for which try catch is compulsory
	public Connection getConnection()
	{
		try {
			String url="jdbc:mysql://localhost:3306/test";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,"root","redhat");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
	public boolean validateUser(Login l)
	{
		try {
			con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from reg where fname=? and lname=?");
			ps.setString(1,l.getUname());
			ps.setString(2,l.getPname());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				l.setUname(rs.getString(1));
				l.setPname(rs.getString(2));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
