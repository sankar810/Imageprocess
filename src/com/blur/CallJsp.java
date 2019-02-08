package com.blur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallJsp extends HttpServlet 
{ 

	
public void doGet(HttpServletRequest request,HttpServletResponse response) 
throws IOException,ServletException 
{ 
response.setContentType("text/html"); 
String s1="fan"; 
String s2="light"; 
if(s1.compareTo(s2)>0) 
{ 
response.sendRedirect("HomePage.jsp"); 
} 
else 
{ 
response.sendRedirect("HomePage.jsp"); 
} 
} 
} 

