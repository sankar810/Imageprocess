package com.hide;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class hidemsg {

	public void stegnography(BufferedImage bimg,String msg,String filename)
    {

      int w=bimg.getWidth();
      int h=bimg.getHeight();
     //*************************************** 
     // String msg="Hide this message:)";
      System.out.println("message="+msg+" length="+msg.length());
    //*************************************** 

      if(msg.length()>255 )
      {
         System.out.println("MESSAGE IS LARGE THAN 255 CHARACTERS");            
      }
      else if( msg.length()*11 >w*h)
      {
    	  System.out.println("Image is too small");    
      }
      else{

  //-------------------------------------------
           byte[] msgbytes= msg.getBytes();

        int msglendecode= (bimg.getRGB(0,0)>>8)<<8;

         msglendecode |= msg.length();
        bimg.setRGB(0, 0,msglendecode );//hidig msg length at first position

         //System.out.println("\npixel at position (0,0) ");
         // bitpattern(bimg.getRGB(0,0) );

         for(int i=1,msgpos=0,row=0,j=0;   row<h   ;row++  )
      {
          for(int col=0;col<w && j<msgbytes.length ;col++,i++ )
          {      

               if (i%11==0) {

                    int rgb = bimg.getRGB(col,row);


                    int a=((rgb >> 24) & 0xff);

                    int r = (((rgb >> 16) & 0xff)>>3)<<3;
                    r=r|(msgbytes[msgpos]>>5);

                    int g = (((rgb >> 8) & 0xff)>>3)<<3;
                    g=g|((msgbytes[msgpos]>>2)& 7);

                     int b = ((rgb & 0xff)>>2)<<2;
                    b=b|(msgbytes[msgpos]&0x3);


                    rgb=0;
                    rgb=(rgb|(a<<24));
                    rgb=(rgb|(r<<16));
                    rgb=(rgb|(g<<8));

                    rgb=(rgb|b);

                    bimg.setRGB(col,row,rgb);

                    msgpos++;
                    j++;

                  //bitpattern(bimg.getRGB(col,row));

              }


          }//for 2
      }//for 1


      ImageIcon image = new ImageIcon(bimg);
      System.out.println(image);  

     try {

  //  File outputfile = new File("c:/Users/yathestha/Documents/"+filename);
     File outputfile = new File("Images/outpngaaa.png");
     ImageIO.write(bimg, "png", outputfile);
     System.out.println(" bimg is ="+bimg);
     System.out.println("Working ");
         } catch (IOException e) {
         System.out.println("error in saving image ");
}

  //-------------------------------------------------
      }//else
 // decoding part----------------------------------------------------------------------   

    }
///////////////////////////////////////////////////////////////////////
private void decodestegnography(BufferedImage bimg) {

     System.out.println("in decode");

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

              System.out.print(""+ (char)charatpos);
              
              System.out.print("");

             j++;
          }
      }
  } 
      System.out.println("");
     System.out.println("decoding done");
}//function
	
	
	private void bitpattern(int rgb) {
	// TODO Auto-generated method stub
	
}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		hidemsg ms = new hidemsg();
					
		String msg="A rome can't connect to it.  ";
		
		String filename ="output.png"; 
		
		File file = new File("Images/hd_nature.jpg"); // I have bear.jpg in my working directory  
        
		FileInputStream fis = new FileInputStream(file);  
		
		System.out.println("fis ="+ fis.toString());
        
		BufferedImage bimg = ImageIO.read(fis); //reading the image file  
		
		//ms.stegnography(bimg, msg, filename);
		
        File file1 = new File("E:\\prabaworkspace\\ImageProcess\\WebContent\\Repeat\\ImageSplit\\KGOD\\ns8.jpg"); // I have bear.jpg in my working directory  
        
        System.out.println("file1 ="+file1);
        
		FileInputStream fis1 = new FileInputStream(file1); 
		
		System.out.println("fis1 ="+fis1);
        
		BufferedImage bimg1 = ImageIO.read(fis1); //reading the image file
		
		System.out.println("bimg1 ="+bimg1);
		
		
        ms.decodestegnography(bimg1);
		
	}

}
