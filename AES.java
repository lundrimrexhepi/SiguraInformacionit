package com.sample;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
public class AES {

	public static void main(String[] args) {
	
		Scanner console = new Scanner(System.in);
		System.out.println("ju Lutem jepni tekstin qe deshironi te enkriptoni: ");  
		AESAlgorithm alg = new AESAlgorithm(AESAlgorithm.KEY_SIZE_128);
		byte[] bytesKey = alg.createKey();
		int[] wordsKeyExpansion = alg.createKeyExpansion(bytesKey);
		String strMessage = console.nextLine();
		byte[] bytesMessage = strMessage.getBytes();
		byte[] bytesEncrypted = alg.cipher(bytesMessage, wordsKeyExpansion);
		byte[] bytesDecrypted = alg.invCipher(bytesEncrypted, wordsKeyExpansion);
		System.out.println("Teksti juaj i enkriptuar eshte:"+ Base64.getEncoder().encodeToString(bytesEncrypted));
		String s = new String(bytesDecrypted, StandardCharsets.UTF_8);
		 // String s = Base64.getEncoder().encodeToString(bytesDecrypted);
		System.out.println("Teksti juaj i dekriptuar eshte:"+s);
		
		
	}

}

