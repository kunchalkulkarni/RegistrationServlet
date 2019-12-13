package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDao;
import com.dao.RegistrationDao;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<h1>Records present are</h1>");
		out.print("<table border=1><tr><th>REGNO</th><th>FIRSTNAME</th><th>LASTNAME</th></tr>");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","redhat");
		PreparedStatement s=con.prepareStatement("select * from reg");
		
		ResultSet rs=s.executeQuery();
		while(rs.next())
		{
			out.print("<tr><td>");
			out.println(rs.getInt(1));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getString(2));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getString(3));
			out.print("</td>");
			out.print("</tr>");
		}
		
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	out.print("</table>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
