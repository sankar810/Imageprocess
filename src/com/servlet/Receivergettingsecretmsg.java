package com.servlet;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class Receivergettingsecretmsg
 */
@WebServlet("/Receivergettingsecretmsg")
public class Receivergettingsecretmsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receivergettingsecretmsg() {
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
		
		
		System.out.println("welcome receiver getting secret msg");
		
		String image =request.getParameter("image");
		
		System.out.println("image ="+image);
		
		String imageno =request.getParameter("imageno");
		
		System.out.println("imageno ="+imageno);
		
        String Filefullpath =request.getParameter("Filefullpath");
		
		System.out.println("Filefullpath ="+Filefullpath);
		
		
		//split imageno in receive choosing image
		
		System.out.println(" .jpg"+image.indexOf("."));
		
		String check =image.substring(23, image.indexOf("."));
		
		System.out.println("check ="+check);
		
		
		
		//c-check , i-imageno
		
		int c =Integer.parseInt(check);
		int i =Integer.parseInt(imageno);
		
		System.out.println("c ="+c+" i ="+i);
		
		if(c == i)
		{
			System.out.println("condition matched");
			
			Receivergettingsecretmsg msg =new Receivergettingsecretmsg();
			
			File file1 = new File(Filefullpath); // Secret msg Image path 
	        
	        System.out.println("file1 ="+file1);
	        
			FileInputStream fis1 = new FileInputStream(file1); 
			
			System.out.println("fis1 ="+fis1);
	        
			BufferedImage bimg1 = ImageIO.read(fis1); //reading the image file
			
			System.out.println("bimg1 ="+bimg1);
			
			msg.decodestegnography(bimg1);
			
			response.sendRedirect("receivedmsgsucess.jsp");
			
		}
		else
		{
			System.out.println("condition failed");
			
			Component par = null;
			JOptionPane.showMessageDialog(par, "Sorry");
			
			response.sendRedirect("receivedmsgerror.jsp");
		}
		
	}
	public String msg1="";
	private void decodestegnography(BufferedImage bimg) {

	     System.out.println("in decode");
	     char msg = 0;
	    

	    int w=bimg.getWidth(),h=bimg.getHeight();
	    bitpattern(bimg.getRGB(0, 0));
	    int msglength=(bimg.getRGB(0, 0)&0xff);
	    bitpattern(msglength);
	    System.out.println("Message Length="+msglength);

	    //jTextField1.setText("");
	      for(int row=0,j=0,i=1;   row<h   ;row++  )
	  { 
	      for(int col=0;col<w && j<msglength ;col++ ,i++)
	      {

	          if (i%11==0) {
	             int result=bimg.getRGB(col,row);


	              int charatpos = (((result >> 16) & 0x7) << 5);

	              charatpos |=  (((result >> 8) & 0x7) << 2);

	              charatpos |=  ((result & 0x3));

	              System.out.print((char)charatpos);
	              
	              //System.out.print("");

	             msg=(char)charatpos;
	             
	              msg1 =msg1+msg;
	             
	             
	            
	             
	            // jTextField1.setText(jTextField1.getText()+ (char)charatpos);
	             
	             /*Component par = null;
	             
	 			JOptionPane.showMessageDialog(par,(char)charatpos ); */
	             
	 			j++;
	             
	             
	             
	          }
	          
	          
	      }
	  }        System.out.println("");
	           System.out.println("msg1 ="+msg1);
	           System.out.println("msg ="+msg);
	           System.out.println("decoding done");
	            
	            Component rmsg = null;
				
	            JOptionPane.showMessageDialog(rmsg, ""+msg1);
	            
	            
	            
	}//function

	private void bitpattern(int rgb) {
		// TODO Auto-generated method stub
		
	}

}
