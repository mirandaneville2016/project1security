package project1security;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class Encrypt {
  static String IV = "AAAAAAAAAAAAAAAA";
  static String plaintext = "0123456789abcd00"; /*Note null padding*/
  static String encryptionKey = "01a2b3c4d5e6f789";
  static int maxLength=16;
  static int textLength=plaintext.length();
  public static void main(String [] args) {
	  
	  while (textLength<maxLength)
	  {
		  plaintext = plaintext + "0";
		  textLength = plaintext.length();
	  }
	  
    try {
      
      System.out.println("plain:   " + plaintext);

      byte[] cipher = encrypt(plaintext, encryptionKey);

      System.out.print("cipher:  ");
      for (int i=0; i<cipher.length; i++)
        System.out.print(new Integer(cipher[i])+" ");
      System.out.println("");
      
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }

  public static byte[] encrypt(String plainText, String encryptionKey) throws Exception {
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return cipher.doFinal(plainText.getBytes("UTF-8"));
  }
}