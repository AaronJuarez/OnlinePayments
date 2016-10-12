package io.conekta.OnlinePayments.utils;


import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;

public class CipherHandler {
	private static final byte[] raw = new byte[]{'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
    private static final SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
    protected static Logger logger = Logger.getLogger("CipherHandler");
	
	public static String decryptData(String encrypted) {
		byte[] original = {0};
		
		try {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(skeySpec.getEncoded(), "AES"));
	        original = cipher.doFinal(encrypted.getBytes());
	        
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return new String(original);
	}
	
	public static String encryptData(String value) {
		byte[] encrypted = {0};
		
		try{
			
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
	        encrypted = cipher.doFinal(value.getBytes());
	             
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return new String(encrypted);
		
	}

}
