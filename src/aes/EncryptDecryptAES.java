/**
* Copyright 2015 Big Data Enterprise. All Rights Reserved 
*
* All intellectual properties not limited to patents, trademarks, industrial designs,
* copyrights, know-how including layout of images and contents contained herein 
* belong to 'Big Data Enterprise'. Any reproduction, modification, distribution 
* or republishing materials without prior written consent is prohibited.
*   
* Class name: aes.EncryptDecryptAES
* Description: 
* <TODO: What the class does>
* 
*/

package aes;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
/**
 * @author Mohammad Nuruzzaman
 * @email  dr.zaman1981@gmail.com 
 * @date   27 Nov 2015 15:54:53
 */

public class EncryptDecryptAES {
	static Cipher cipher;

	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		cipher = Cipher.getInstance("AES");

		String plainText = "AES Symmetric Encryption Decryption";
		System.out.println("Plain Text Before Encryption: " + plainText);

		String encryptedText = encrypt(plainText, secretKey);
		System.out.println("Encrypted Text After Encryption: " + encryptedText);

		String decryptedText = decrypt(encryptedText, secretKey);
		System.out.println("Decrypted Text After Decryption: " + decryptedText);
	}

	public static String encrypt(String plainText, SecretKey secretKey)
			throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	public static String decrypt(String encryptedText, SecretKey secretKey)
			throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}
}
