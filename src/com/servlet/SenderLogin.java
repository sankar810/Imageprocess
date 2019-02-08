package com.servlet;

import java.io.IOException;
import java.sql.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.Interface.Interface;
import com.beanclass.Beanclass;
import com.imple.Userimplement;



/**
 * Servlet implementation class Loginn
 */
public class SenderLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SenderLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("welcome login page");
		
		
		response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
	    HttpSession session=request.getSession();  
        session.setAttribute("Uname",username);   
        System.out.println("User name is "+username);
        System.out.println("Password is "+password);
        
		
		Beanclass bean=new Beanclass();
		 
		bean.setUname(username);
		bean.setPasswd(password);

		
		Interface im=new Userimplement();  //Upcasting
		
		Boolean status=im.getLoginn(bean);
		
		System.out.println("status ="+status);
		
		if(status == true)
		{
			System.out.println("Homepage.jsp");
			
			response.sendRedirect("HomePage.jsp");
		}
		else
		{ 
			response.sendRedirect("SenderLoginError.jsp");
		}
		
	}

}
