package br.com.paulo.passwordgenerator;

import java.util.Random;

public class Generator {
	
	private static String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String Generator(final int LENGTH) {
	    StringBuilder password = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < LENGTH; i++) {
	        int index = random.nextInt(CHARS.length());
	        password.append(CHARS.charAt(index));
	    }
	    return password.toString();
	}
	public void setCHARS(String CHARS) {
		this.CHARS = CHARS;
	}
}