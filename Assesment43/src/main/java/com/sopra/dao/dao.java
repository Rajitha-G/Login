package com.sopra.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Registration;

import com.sopra.bean.Logindetails;
import com.sopra.bean.Registrationdetails;
import com.sopra.jdbcconnection.jdbc;


public class dao
{
	public boolean insert(Registrationdetails reg)
	{
		String sql="insert into registration values(?,?,?,?)";
		
		try 
		{
			PreparedStatement st=jdbc.getconnect().prepareStatement(sql);
			st.setInt(1, reg.getEmpid());
			st.setString(2, reg.getEmpname());
			st.setString(3, reg.getEmail());
			st.setString(4, reg.getContact());
			
			return st.executeUpdate()>0;
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	public boolean logininsert(Logindetails emp)
	{
		String sql="insert into login values(?,?,?)";
		
		try 
		{
			PreparedStatement st=jdbc.getconnect().prepareStatement(sql);
			st.setInt(1, emp.getEmpid());
			st.setString(2, emp.getEmpname());
			st.setString(3, emp.getDate());
			
			return st.executeUpdate()>0;
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
public List<Registrationdetails> getUser()
	
	{
		List<Registrationdetails> list=new ArrayList<>();
		String sql="select * from register";
		
		try {
			PreparedStatement st=jdbc.getconnect().prepareStatement(sql);
			ResultSet res=st.executeQuery();
			Registrationdetails users=null;
			
			while(res.next())
			{
				int empId=res.getInt("empidd");
				String empName=res.getString("empname");
				String email=res.getString("email");
				String contact=res.getString("contact");
				users=new Registrationdetails(empId, empName, email,contact);
				list.add(users);
				
			}
			
		} 
		
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}

public List<Logindetails>  getlogindetails()

{
	List<Logindetails> list=new ArrayList<>();
	String sql="select * from login";
	
	try {
		PreparedStatement st=jdbc.getconnect().prepareStatement(sql);
		ResultSet res=st.executeQuery();
		Logindetails user=null;
		
		while(res.next())
		{
			int empId=res.getInt("empId");
			String empName=res.getString("empName");
			String date_time=res.getString("date_time");
			user=new Logindetails(empId, empName, date_time);
			list.add(user);
			
		}
		
	} 
	
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
	
}


}
