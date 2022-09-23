package com.sopra.bean;

public class Registrationdetails 
{
	private int Empid;
	private String Empname;
	private String Email;
	private String Contact;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public Registrationdetails(int empid, String empname, String email, String contact) {
		super();
		Empid = empid;
		Empname = empname;
		Email = email;
		Contact = contact;
	}
	public Registrationdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Registrationdetails [Empid=" + Empid + ", Empname=" + Empname + ", Email=" + Email + ", Contact="
				+ Contact + "]";
	}
	


}
