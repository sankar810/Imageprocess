package com.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.Dbcon.Dbcon;

/**
 * Servlet implementation class MergeImage
 */
@WebServlet("/MergeImage")
public class MergeImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String realpath1;
	
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MergeImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Mergeing Image Page");

		String row = request.getParameter("row");

		System.out.println("row =" + row);

		String col = request.getParameter("col");

		System.out.println("col =" + col);

		String Imagepath = request.getParameter("Imagepath");

		System.out.println("Imagepath =" + Imagepath);

		String Username = request.getParameter("Username");

		System.out.println("Username =" + Username);

		String Imagename= request.getParameter("Imagename");
		
		System.out.println("MergeImage Imagename ="+Imagename);
		
		String Filename = JOptionPane.showInputDialog("Enter Your Image Merging Filename");

		System.out.println("Filename =" + Filename);
		
        String Imagename1=Imagename.substring(Imagename.indexOf("s"), Imagename.indexOf("."));
		
		System.out.println("Imagename1 ="+Imagename1);
		
		String Imagename2=Imagename1.substring(1);
		
		System.out.println("Imagename2 ="+Imagename2);

		int r1 = Integer.parseInt(row);
		int c1 = Integer.parseInt(col);
		
        String realpath=getServletContext().getRealPath("");
        
        System.out.println("realpath ="+realpath);
        
        realpath1 =realpath.substring(0, realpath.indexOf("."));
        
        System.out.println("realpath1 ="+realpath1);
   

		int rows = r1; // we assume the no. of rows and cols are known and each
						// chunk has equal width and height
		int cols = c1;
		int chunks = rows * cols;

		int chunkWidth, chunkHeight;
		int type;
		// fetching image files
		File[] imgFiles = new File[chunks];
		for (int i = 0; i < chunks; i++) {
			imgFiles[i] = new File(
					realpath1+"\\ImageProcess\\WebContent\\sender_ImageSplit\\ns"
							+ i + ".jpg");
		}

		// creating a bufferd image array from image files
		BufferedImage[] buffImages = new BufferedImage[chunks];
		for (int i = 0; i < chunks; i++) {
			buffImages[i] = ImageIO.read(imgFiles[i]);
		}
		type = buffImages[0].getType();
		chunkWidth = buffImages[0].getWidth();
		chunkHeight = buffImages[0].getHeight();

		// Initializing the final image
		BufferedImage finalImg = new BufferedImage(chunkWidth * cols,
				chunkHeight * rows, type);

		int num = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				finalImg.createGraphics().drawImage(buffImages[num],
						chunkWidth * j, chunkHeight * i, null);
				num++;
			}
		}

		System.out.println("Image concatenated.....");

		ImageIO.write(finalImg, "jpeg", new File(realpath1+"\\ImageProcess\\WebContent\\Mergeimages\\"+ Filename + ".jpg"));

		String FileFullpath = realpath1+"\\ImageProcess\\WebContent\\Mergeimages\\"+ Filename + ".jpg";
          
		//folder created
		
		File file = new File(realpath1+"\\ImageProcess\\WebContent\\Repeat\\sender_ImageSplit\\"+Filename+"");
		
		if (!file.exists()) 
		{
			if (file.mkdir()) 
			{
				System.out.println("Directory is created!");
			} else 
			{
				System.out.println("Failed to create directory!");
			}
			System.out.println("Filename folder sucessfully created");
		}
		
		//image read and write
		
		File file1= new File(realpath1+"\\ImageProcess\\WebContent\\Repeat\\"+ Imagepath);
		
		FileInputStream fis1 = new FileInputStream(file1);

		BufferedImage bimg = ImageIO.read(fis1);
		
        String Newsecretimage=realpath1+"\\ImageProcess\\WebContent\\Repeat\\sender_ImageSplit\\"+Filename+""+Imagename;
		
		System.out.println("Newsecretimage ="+Newsecretimage);
		
		File file2= new File(Newsecretimage);
		
		ImageIO.write(bimg, "png", file2);
		
		System.out.println("Image Sucessfully created in Filename location ");
		
		
		
		String RowColomnImageno = null;
		
		
		//database Stored		
		
		/*System.out.println("FileFullpath =" + FileFullpath);
		
		Connection con =Dbcon.dbcon();
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO imageprocess.secretmessage VALUES(?,?,?,?,null,null)");
		
			
		   
		RowColomnImageno=row+""+col+""+Imagename2+"";
		
		System.out.println("RowColomnImageno ="+RowColomnImageno);
		
		
			ps.setString(1,Username);
			ps.setString(2,FileFullpath);
			ps.setString(3,RowColomnImageno);
			ps.setString(4,Imagepath);
			
			int i =ps.executeUpdate();
       
			System.out.println("i ="+i);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		//merged image next page passing
		
		String mergeimagepath="Mergeimages//"+Filename + ".jpg";
		
		System.out.println("mergeimagepath ="+mergeimagepath);
		
		//RowColomnImageno
		
		//Generating secret key 
		
		String secret_key1=row;
		String secret_key2=col;
		String secret_key3=Imagename2;
		
		System.out.println("secret_key1 ="+secret_key1);
		System.out.println("secret_key2 ="+secret_key2);
		System.out.println("secret_key3 ="+secret_key3);
		
        //RowColomnImageno=row+""+col+""+Imagename2+"";
		
		//System.out.println("RowColomnImageno ="++"&&secret_key1="+secret_key1+);
		
		response.sendRedirect("ImageMergesucess.jsp?mergeimagepath="+mergeimagepath+"&&sender="+Username+"&&secret_key1="+secret_key1+"&&secret_key2="+secret_key2+"&&secret_key3="+secret_key3+"&&Imagepath="+Imagepath+"&&FileFullpath="+Newsecretimage);
		
	}

}
