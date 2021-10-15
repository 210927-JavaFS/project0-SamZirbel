package com.revature.util;

public class encryptDecryptUtil {

	public static String encryptDecrypt(String runagainst) {
	
		byte[] buffer = runagainst.getBytes();
		
		for (int i = 0; i < buffer.length; ++ i) {
		
			buffer[i] = (byte) (buffer[i] ^ 0b10101010);
			
		}
	
		String result = new String(buffer);
		
		return result;
	
	}

}
