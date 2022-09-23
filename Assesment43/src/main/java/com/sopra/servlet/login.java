package com.sopra.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Registration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sopra.bean.Logindetails;
import com.sopra.bean.Registrationdetails;
import com.sopra.dao.dao;



/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String empName=request.getParameter("empName");
		String date_time=dtf.format(now);
		
		Logindetails e1=new Logindetails();
		e1.setEmpid(empId);
		e1.setEmpname(empName);
		e1.setDate(date_time);
		
		dao d2=new dao();
		PrintWriter out=response.getWriter();
		List<Registrationdetails> user=new ArrayList<>();
		user=d2.getUser();
		for(Registrationdetails u:user)
		{
			if(((Registrationdetails) u).getEmpid()==empId ) //&& u.getEmpName()==empName
			{
				d2.logininsert(e1);
				RequestDispatcher req=request.getRequestDispatcher("login.jsp");
				req.forward(request, response);
				
			}

			
		}
		
		RequestDispatcher req=request.getRequestDispatcher("register.jsp");
		req.forward(request, response);
		
		
	}

}
