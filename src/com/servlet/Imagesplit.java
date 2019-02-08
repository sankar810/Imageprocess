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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Imagesplit
 */
@WebServlet("/Imagesplit")
public class Imagesplit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imagesplit() {
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
		
		HttpSession session =request.getSession();
		String row =(String) session.getAttribute("row");
		String col =(String) session.getAttribute("col");
		
		int r1 =Integer.parseInt(row);
		int c1 =Integer.parseInt(col);
		
		System.out.println("ImageSplit row ="+row);
		System.out.println("ImageSplit col ="+col);
		
		String path =request.getParameter("path");
		
		System.out.println("Imagesplit path ="+path);
		
		File file = new File(path); // I have bear.jpg in my working directory  
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
        
        String realpath=getServletContext().getRealPath("");
        
        System.out.println("realpath ="+realpath);
        
        String realpath1 =realpath.substring(0, realpath.indexOf("."));
        
        System.out.println("realpath1 ="+realpath1);
  
        //writing mini images into image files  
        for (int i = 0; i < imgs.length; i++) {  
            ImageIO.write(imgs[i], "jpg", new File(realpath1+"//ImageProcess//WebContent//sender_ImageSplit//ns" + i + ".jpg"));  
            
        }  
        System.out.println("Mini images created"); 
		
		
        response.sendRedirect("table.jsp?row="+row+"&&col="+col);
        
        
	}

}
