package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RegistrationDao;
import com.model.Register;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		//ojdbc14 jar file to be inserted in web content-> WEB_INF->lib
		String s1=request.getParameter("rno");
		int rno=Integer.parseInt(s1);
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		
		Register r=new Register();
		r.setRegNo(rno);
		r.setFname(fname);
		r.setLname(lname);
		
		List<Register>lst=new ArrayList<Register>();
		lst.add(r);
		
		RegistrationDao rd=new RegistrationDao();
		int c=rd.saveData(lst);
		if(c>0)
		{
			pw.print("record inserted");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
