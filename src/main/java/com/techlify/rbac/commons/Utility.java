package com.techlify.rbac.commons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kamal
 *
 */
public class Utility {
	/**
	 * @param pwd
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encryptPassword(String pwd) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(pwd.getBytes());
		
		byte byteData[] = md.digest();
 
		//convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
		 sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
    
		String encryptedPassword	=	sb.toString();
		return encryptedPassword;
	}
}
