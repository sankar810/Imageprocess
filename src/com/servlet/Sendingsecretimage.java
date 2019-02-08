package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dbcon.Dbcon;

/**
 * Servlet implementation class Sendingsecretimage
 */
@WebServlet("/Sendingsecretimage")
public class Sendingsecretimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendingsecretimage() {
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
		
		try {
		
		System.out.println("welcome Sending secret image");
		
		String receiver =request.getParameter("receiver");
		
		System.out.println("receiver ="+receiver);
					
        String mergeimagepath =request.getParameter("mergeimagepath");
		
		System.out.println("mergeimagepath ="+mergeimagepath);
		
		String secret_key1= request.getParameter("secret_key1");
		
		System.out.println(" secret_key1 ="+secret_key1);
		
        String secret_key11=encryptdata.encrypt(secret_key1);
		
		System.out.println("secret_key11 ="+secret_key11);
		
        String secret_key2= request.getParameter("secret_key2");
		
		System.out.println(" secret_key2 ="+secret_key2);
		
        String secret_key12=encryptdata.encrypt(secret_key2);
		
		System.out.println("secret_key12 ="+secret_key12);
		
        String secret_key3= request.getParameter("secret_key3");
		
		System.out.println(" secret_key3 ="+secret_key3);
		
        String secret_key13=encryptdata.encrypt(secret_key3);
		
		System.out.println("secret_key13 ="+secret_key13);
		
        
        String Imagepath= request.getParameter("Imagepath");
        
        System.out.println(" Imagepath="+Imagepath);
        
        String FileFullpath= request.getParameter("FileFullpath");
		        
        System.out.println(" FileFullpath ="+FileFullpath);
		
        String sender= request.getParameter("sender");
        
        System.out.println(" sender ="+sender);
		
		Connection con=Dbcon.dbcon();
		
		PreparedStatement ps;
		
		
			
			ps = con.prepareStatement("INSERT INTO imageprocess.secretmessage VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		    
			ps.setString(1, sender );
			ps.setString(2, FileFullpath);
			ps.setString(3, secret_key1);
			ps.setString(4, secret_key2);
			ps.setString(5, secret_key3);
			ps.setString(6, Imagepath);
			ps.setString(7, mergeimagepath);
			ps.setString(8, receiver);
			ps.setString(9, secret_key11);
			ps.setString(10, secret_key12);
			ps.setString(11, secret_key13);
			
			
			
		int i =ps.executeUpdate();
		
		System.out.println("All Details sucessfully Updated i ="+i);
		
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		response.sendRedirect("sendingsecretmsgsucess.jsp");
		
		
	}

}
