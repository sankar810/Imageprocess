package com.servlet;

import java.awt.Graphics2D;
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

/**
 * Servlet implementation class receiversplit
 */
@WebServlet("/receiversplit")
public class receiversplit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	String realpath1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public receiversplit() {
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
		
		System.out.println("welcome receiversplit");
		
        String rrow= request.getParameter("rrow");
        
        int rrow1=Integer.parseInt(rrow);
        
        System.out.println("rrow1 ="+rrow1);
		
		System.out.println("rrow ="+rrow);
		
		String rcol= request.getParameter("rcol");
		
		int rcol1=Integer.parseInt(rcol);
		
		System.out.println("rcol1 ="+rcol1);
		
		System.out.println("rcol ="+rcol);
		
		String Secret_Key1= request.getParameter("Secret_Key1");
		
		System.out.println("Secret_Key1 ="+Secret_Key1);
		
        String Secret_Key2= request.getParameter("Secret_Key2");
		
		System.out.println("Secret_Key2 ="+Secret_Key2);
		
        String Secret_Key3= request.getParameter("Secret_Key3");
		
		System.out.println("Secret_Key3 ="+Secret_Key3);
		
		String Filefullpath= request.getParameter("Filefullpath");
		
		System.out.println("Filefullpath ="+Filefullpath);
		
		String mergeimagepath= request.getParameter("mergeimagepath");
		
		System.out.println("mergeimagepath ="+mergeimagepath);
		
				
		int r =Integer.parseInt(Secret_Key1);
		
		System.out.println("r ="+r);
		
		int c =Integer.parseInt(Secret_Key2);
		
		System.out.println("c ="+c);
		
		String imageno =Secret_Key3;
		
		System.out.println("imageno ="+imageno);
		
		//System.out.println("cond ="+row==rrow1+""+col==rcol1+"");
		
        String realpath=getServletContext().getRealPath("");
        
        System.out.println("realpath ="+realpath);
        
        realpath1 =realpath.substring(0, realpath.indexOf("."));
        
        System.out.println("realpath1 ="+realpath1);
		
		if(r==rrow1 && c==rcol1)
		{
			System.out.println("Condition Matched");
			
			int r1 =r;
			int c1 =c;
			
			//System.out.println("ImageSplit row ="+row);
			//System.out.println("ImageSplit col ="+col);
			
			
			
			System.out.println("Imagesplit mergeimagepath ="+mergeimagepath);
			
			String mergeimagepath1= realpath1+"\\ImageProcess\\WebContent\\"+mergeimagepath;
			
			System.out.println(" New mergeimagepath1 ="+mergeimagepath1);
			
			File file = new File(mergeimagepath1); // I have bear.jpg in my working directory  
	        FileInputStream fis = new FileInputStream(file);  
	        BufferedImage image = ImageIO.read(fis); //reading the image file  
	  
	        int rows = r1; //You should decide the values for rows and cols variables  
	        int cols = c1;  
	        int chunks = rows * cols;  
	  
	        int chunkWidth = image.getWidth() / cols; // determines the chunk width and height  
	        int chunkHeight = image.getHeight() / rows;  
	        int count = 0;  
	        BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks  
	        for (int x = 0; x < rows; x++) {  
	            for (int y = 0; y < cols; y++) {  
	                //Initialize the image array with image chunks  
	                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());  
	  
	                // draws the image chunk  
	                Graphics2D gr = imgs[count++].createGraphics();  
	                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
	                gr.dispose();  
	            }  
	        }  
	        System.out.println("Splitting done");  
	  
	        //writing mini images into image files  
	        for (int i = 0; i < imgs.length; i++) {  
	            ImageIO.write(imgs[i], "jpg", new File(realpath1+"//ImageProcess//WebContent//receiver_ImageSplit//ns" + i + ".jpg"));  
	            
	        }  
	        System.out.println(" RECEIVER Mini images created"); 
			
			response.sendRedirect("receciversplittable.jsp?rrow="+rrow+"&&rcol="+rcol+"&&imageno="+imageno+"&&Filefullpath="+Filefullpath);
			
		}
		else
		{
			response.sendRedirect("receiversplitingError.jsp?Secret_Key1="+Secret_Key1+"&&Secret_Key2="+Secret_Key2+"&&Secret_Key3="+Secret_Key3+"&&Filefullpath="+Filefullpath+"&&mergeimagepath="+mergeimagepath);
		}
	}

}
