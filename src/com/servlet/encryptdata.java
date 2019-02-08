package com.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;

import javax.crypto.Cipher;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.Part;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class encryptdata {
	public static String encrypt(String Data) throws Exception
	{       
		    System.out.println("Encrypted in coming");
	        Key key = Publickey.generateKey();
	        Cipher c = Cipher.getInstance("AES");
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encVal = c.doFinal(Data.getBytes());
	        String encryptedValue = new BASE64Encoder().encode(encVal);
	        return encryptedValue;
	 }
	
	public static String decrypt(String encryptedData) throws Exception 
	{
        Key key = Publickey.generateKey();
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        //System.out.println("key is :::"+ABEKey.generateKey());
        return decryptedValue;
	}
	public static int mergeFiles(File[] files, File mergedFile) {
		
		FileWriter fstream = null;
		BufferedWriter out = null;
      String aline=null;
//		String filename=null;
//		String filetype=null;
      String filesize=null;
//		String filepath=null;
		try {
			fstream = new FileWriter(mergedFile, true);
			out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (File f : files) {
			System.out.println(".................."+f);
			//System.out.println("mergin: " + f.getName());
		       
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));

				//String aline;
				while ((aline = in.readLine()) != null) {
					//fstream.write(aline.substring(4));
				out.write(aline);
				//FilePart filePart =aline;
				
					   //  int x= aline.length();
					     //System.out.println(x);
					//out.newLine();
					
					System.out.println("out................"+aline);
				}

				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;

	}

	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		



