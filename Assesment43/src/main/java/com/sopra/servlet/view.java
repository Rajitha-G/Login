package com.sopra.servlet;

import java.io.IOException.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.sopra.bean.Logindetails;
import com.sopra.dao.dao;
/**
 * Servlet implementation class view
 */
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	
         dao d3=new dao();
         PrintWriter p=response.getWriter();
         
		List<Logindetails> users=new ArrayList<>();
		
		users.addAll(d3.getlogindetails());
		
		p.println("<table callspacing='0' width='35px' border='1px'>");
		p.println("<tr>");
		p.println("<th>Employee Id</th>");
		p.println("<th>Employee Name</th>");
		p.println("<th>Data And Time</th>");
		p.println("</tr>");
		
		for(Logindetails u:users)
		{
			p.println("<tr>");
			p.println("<td>"+u.getEmpid()+"</td>");
			p.println("<td>"+u.getEmpname()+"</td>");
			p.println("<td>"+u.getDate()+"</td>");
			p.println("</tr>");
		}
		p.println("</table>");
		
    }

}
