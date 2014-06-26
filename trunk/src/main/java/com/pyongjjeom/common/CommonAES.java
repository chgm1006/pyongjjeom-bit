/**
 * 
 */

package com.pyongjjeom.common;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * <pre>
 * com.pyongjjeom.common 
 *    |_ CommonAES.java
 * 
 * AES 암호화 복호화
 * </pre>
 * 
 * @version :
 * @author : Forrest
 */
public class CommonAES {

	private Logger log = Logger.getLogger(this.getClass());

	private static String encString = "";

	private String password = "force";
	private String keyString = null;
	private byte[] seedB = null;

	private SecureRandom sr = null;
	private KeyGenerator kgen = null;
	private SecretKey skey = null;
	private SecretKeySpec skeySpec = null;
	private Cipher cipher = null;

	/**
	 * 
	 */
	public CommonAES() {

		seedB = password.getBytes();

		try {
			sr = SecureRandom.getInstance("SHA1PRNG");
			kgen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sr.setSeed(seedB);

		kgen.init(128, sr); // 192 and 256 bits may not be available

		skey = kgen.generateKey();
		keyString = Hex.encodeHexString(skey.getEncoded());
		skeySpec = new SecretKeySpec(skey.getEncoded(), "AES");
	}

	public String getEncryptor(String encrStr) {

		byte[] encrypted = null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			encrypted = cipher.doFinal(encrStr.getBytes());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}

		encString = Hex.encodeHexString(encrypted);

		System.out.println("encrypted string: [" + keyString + "] " + encString);

		return encString;
	}

	public String getDecryptor(String decrStr) {

		byte[] decrypted = null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			decrypted = cipher.doFinal(Hex.decodeHex(decrStr.toCharArray()));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		encString = new String(decrypted);
		System.out.println("decrypted string: [" + keyString + "] " + encString);
		return encString;
	}

	public static void main(String[] args) {
		CommonAES aes = new CommonAES();
//		String str = aes.getEncryptor("chgm1006@gmail.com");
//		System.out.println(str);
		String str2 = aes.getDecryptor("57d5b38a2ce5dbda69a0e7b9206ecdeaf371394aa94eb740911145f180c00f3b");
		System.out.println(str2);
	}
}
