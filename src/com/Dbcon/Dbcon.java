package com.Dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcon {

	public static Connection con;
	
	public static Connection dbcon()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imageprocess", "root","root");
			
			System.out.println("Db connected");	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	
	
	
}
