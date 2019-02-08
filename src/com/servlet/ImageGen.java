package com.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class ImageGen
 */
@WebServlet("/ImageGen")
public class ImageGen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageGen() {
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
		
             System.out.println("welcome Image Generation page"); 
		
		Part part = null;
		FilePart filePart = null;
		//ParamPart paramPart = null;
		String type = null;
		double fileSize=0.0;
		String filename =null;
		
		
		MultipartParser mpp=new MultipartParser(request, 999999999);
		
		String realpath=getServletContext().getRealPath("/");
		
		System.out.println(realpath+"===I am Real Path");
		
		String path=realpath.substring(0,realpath.indexOf("."))+"ImageProcess\\WebContent\\ImageGen\\";
		
        System.out.println("path ="+path);
		
		while((part=mpp.readNextPart())!=null)
		{
			if(part.isFile())
			{
				filePart = (FilePart) part;
				
				path=path+filePart.getFileName();
				
				System.out.println("Full Path ="+path);
								
				filename=filePart.getFileName();
										
				File uploadedFile = new File(path);
				
				type = filePart.getContentType();
				
				fileSize = filePart.writeTo(uploadedFile);
				
				response.sendRedirect("ImageGenSucess.jsp?path="+path);				
			   }
		
			}
		
		
	}

}
