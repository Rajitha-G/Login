package com.sopra.bean;

public class Logindetails 
{
	private int Empid;
	private String Empname;
	private String Date;
	public int getEmpid() {
		return Empid;
	}
	public void setEmpid(int empid) {
		Empid = empid;
	}
	public String getEmpname() {
		return Empname;
	}
	public void setEmpname(String empname) {
		Empname = empname;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public Logindetails(int empid, String empname, String date) {
		super();
		Empid = empid;
		Empname = empname;
		Date = date;
	}
	@Override
	public String toString() {
		return "Logindetails [Empid=" + Empid + ", Empname=" + Empname + ", Date=" + Date + "]";
	}
	public Logindetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
