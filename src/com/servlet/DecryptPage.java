package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dbcon.Dbcon;

/**
 * Servlet implementation class DecryptPage
 */
@WebServlet("/DecryptPage")
public class DecryptPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecryptPage() {
        super();
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
		
		System.out.println("Decrypt Page");
		
		try
		{
			String UserSecretkey = null;
		
		
        String Username=request.getParameter("Username");
		
		System.out.println("Username ="+Username);
		
		String SecretKey=request.getParameter("SecretKey");
		
		System.out.println("SecretKey ="+SecretKey);
		
		Connection con=Dbcon.dbcon();
		
		PreparedStatement ps=con.prepareStatement("select SecretKey from imageprocess.senderregister where Username='"+Username+"'");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			UserSecretkey =rs.getString(1);
			
			System.out.println("UserSecretkey ="+UserSecretkey);
		}
		
		
		if(UserSecretkey.equals(SecretKey))
		{
			response.sendRedirect("Inbox.jsp");
		}
		else
		{
			response.sendRedirect("DecryptPageError.jsp");
		}
					
		
		
		
		
		
		}catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
				
	}

}
