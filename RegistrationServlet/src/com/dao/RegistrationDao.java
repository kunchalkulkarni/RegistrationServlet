package com.dao;
import java.sql.*;
import java.util.List;

import com.model.Register;

public class RegistrationDao {
	Connection con;
	public RegistrationDao()
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
public int saveData(List<Register> lst) {
	//collection
	int i=0;
	int cnt=0;
	Register r=lst.get(0);
	con=getConnection();
	try {
	PreparedStatement ps=con.prepareStatement("insert into reg values(?,?,?)");
	ps.setInt(1,r.getRegNo());
	ps.setString(2,r.getFname());
	ps.setString(3,r.getLname());
    i=ps.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	if(i>0) {
		cnt=1;
	}
return cnt;
}

public void displayAll()
{
	try
	{
	con=getConnection();
	PreparedStatement s=con.prepareStatement("select * from reg");
	
	ResultSet rs=s.executeQuery();
	while(rs.next())
	{
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
	}
	
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	
}

}
