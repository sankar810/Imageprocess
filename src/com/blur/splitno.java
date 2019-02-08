package com.blur;

public class splitno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="4412";
		
		char r =s.charAt(0);
				
		System.out.println("r ="+r); 
		
		char c =s.charAt(1);
		
		System.out.println("c ="+c);
		
		String im =s.substring(2);
		
		System.out.println("im ="+im);
		
		String s1 ="ImageSplit\\ns74.jpg";
		
		System.out.println(s1.indexOf("."));
		
		String check =s1.substring(13, s1.indexOf("."));
		
        System.out.println("check ="+check);
		
	}

}
