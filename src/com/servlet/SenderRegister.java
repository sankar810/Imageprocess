package com.servlet;

import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import com.Dbcon.Dbcon;
import com.Interface.Interface;
import com.beanclass.Beanclass;
import com.imple.Userimplement;



/**
 * Servlet implementation class Regis
 */
public class SenderRegister extends HttpServlet {
	
	public static String gender;
	
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SenderRegister() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		
		
		String name=request.getParameter("name");
		String Emailid=request.getParameter("email");
		String Uname=request.getParameter("username");
		String Passwd=request.getParameter("password");
		String Confirm=request.getParameter("repassword");
	    String gender=request.getParameter("gender");
		String Phoneno=request.getParameter("phone");
		String Address=request.getParameter("address");
		/*
		out.print(Uname);
		out.print(Passwd);
		out.print(Confirm);
		out.print(Emailid);
		out.print(Dob);
		out.print(Phoneno);*/
		
        
		
	    HttpSession session=request.getSession();  
        session.setAttribute("uname",Uname);  
        
        System.out.println(Uname);
		
		
		
		
		Beanclass bean = new Beanclass();
		
		bean.setName(name);
		bean.setEmaild(Emailid);
		bean.setUname(Uname);
	    bean.setPasswd(Passwd);
	    bean.setConfirm(Confirm);
	    bean.setGender(gender);
		bean.setPhno(Phoneno);
		bean.setAddress(Address);
		
		
		Interface im = new Userimplement();
		
		int i=im.insert(bean);
		
		System.out.println("i ="+i);
		
		if(i == 1)
		{
			try
			{
				String SecretKey=null;
			
			Connection con=Dbcon.dbcon();
			
			PreparedStatement ps=con.prepareStatement("SELECT SecretKey FROM imageprocess.senderregister s where Username='"+Uname+"'");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				SecretKey =rs.getString(1);
				
				System.out.println("SecretKey ="+SecretKey);
			}
			
			Component c=null;
			
			JOptionPane.showMessageDialog(c, "Your SecretKey is "+SecretKey);
			
			response.sendRedirect("SenderLogin.jsp");
			
			}catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
		}
					
		
				
	    
		
				
		}

}
