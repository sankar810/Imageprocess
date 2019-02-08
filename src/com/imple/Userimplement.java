package com.imple;

import java.sql.*;
import java.util.Random;

import com.Dbcon.Dbcon;
import com.Interface.Interface;
import com.beanclass.Beanclass;



public class Userimplement implements Interface
{
	 int i;
	
	 boolean Status=false;
	 
	 static Connection con;
	 
	 static
	 {
		 
	 con = Dbcon.dbcon();
	 
	 }
	
   public int insert(Beanclass bean)
   {
	   
	   String Username= bean.getUname();
	   
	   System.out.println("Username ="+Username);
	  
	   String s="12456890AE4665INSYZ";
	
	   Random r=new Random();
		
		  char s1=s.charAt(r.nextInt(s.length()));
		  char s2=s.charAt(r.nextInt(s.length()));
		  char s3=s.charAt(r.nextInt(s.length()));
		  char s4=s.charAt(r.nextInt(s.length()));
		  
		String SecretKey=""+s1+s2+s3+s4;
		
		System.out.println("SecretKey ="+SecretKey);
	   
	   try{
		   
		    
		    PreparedStatement st = con.prepareStatement("INSERT INTO imageprocess.senderregister VALUES(?,?,?,?,?,?,?,?,?)");
			
   
	st.setString(1,bean.getName());
	st.setString(2,bean.getEmaild());
	st.setString(3,bean.getUname());
	st.setString(4,bean.getPasswd());
	st.setString(5,bean.getConfirm());
	st.setString(6,bean.getGender());
	st.setString(7,bean.getPhno());
	st.setString(8,bean.getAddress());
	st.setString(9,SecretKey.toString());
	
	 i = st.executeUpdate();
	
	 System.out.println("UserRegister table created Sucessfully i="+i);
	 
	   
	     }catch(Exception e){System.out.println(e);}
	   
	return i;
   }
	
   public boolean getLoginn(Beanclass bean)
   {
	    
	   try
	   {
	   
		PreparedStatement st = con.prepareStatement("SELECT * FROM imageprocess.senderregister where Username=? && Passwd=?");
	    
		st.setString(1,bean.getUname());
		st.setString(2,bean.getPasswd());
		 
		ResultSet rs = st.executeQuery();
		
		 Status = rs.next();
		 
		 System.out.println("Status ="+Status);
	   
	   }catch(Exception e)
	   {System.out.println(e);}
	   
	  
	return Status;
	   
   }

            
}
