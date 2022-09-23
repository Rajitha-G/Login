package com.sopra.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sopra.bean.Registrationdetails;
import com.sopra.dao.dao;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		
		Registrationdetails r1=new Registrationdetails();
		r1.setEmpid(empId);
		r1.setEmpname(empName);
		r1.setEmail(email);
		r1.setContact(contact);
		
		dao d1=new dao();
		boolean b=d1.insert(r1);
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		if(b)
		{
			out.println("Registration successful. Please login!!!");
			RequestDispatcher req=request.getRequestDispatcher("index.jsp");
			req.forward(request, response);
			
		}
		else
		{
			out.println("Invalid user details. Re-enter details!!!");
			RequestDispatcher req=request.getRequestDispatcher("register.jsp");
			req.include(request, response);
			
		}
		
	
	}

}
