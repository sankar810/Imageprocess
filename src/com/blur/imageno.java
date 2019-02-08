package com.blur;

public class imageno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String file ="ns11.jpg";
		
		String ns=file.substring(file.indexOf("s"), file.indexOf("."));
		
		System.out.println("ns ="+ns);
		
		String ns1=ns.substring(1);
		
		System.out.println("ns1 ="+ns1);
		
	}

}
