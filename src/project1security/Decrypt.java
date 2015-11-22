package project1security;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class Decrypt {
  static String IV = "AAAAAAAAAAAAAAAA";
  static byte[] Cyphertext = {-45, 72, 120, -34, -84, 100, -93, 44, 90, 32, -98, -77, -92, -62, 6, -4}; /*Note null padding*/
  static String encryptionKey = "01a2b3c4d5e6f789";
  public static void main(String [] args) {
    try {
      
//      System.out.println("==Java==");
//      System.out.println("plain:   " + plaintext);

      byte[] cipher = Cyphertext;

      System.out.print("cipher:  ");
      for (int i=0; i<cipher.length; i++)
        System.out.print(new Integer(cipher[i])+" ");
      System.out.println("");

      String decrypted = decrypt(cipher, encryptionKey);

      System.out.println("decrypt: " + decrypted);

    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    return new String(cipher.doFinal(cipherText),"UTF-8");
  }
}