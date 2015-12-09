package project1security;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class Decrypt {
  static String IV = "AAAAAAAAAAAAAAAA";
  static byte[] Cyphertext = {-53, -55, -24, -101, 58, -96, 91, 103, -124, 0, -84, -4, -42, 87, 24, -58}; /*Note null padding*/
  static String encryptionKey = "01a2b3c4d5e6f789";

  @SuppressWarnings("null")
public static void main(String [] args) {
	  
    try {
      
      byte[] cipher = Cyphertext;

      System.out.print("cipher:  ");
      for (int i=0; i<cipher.length; i++)
        System.out.print(new Integer(cipher[i])+" ");
      System.out.println("");

      String decrypted = decrypt(cipher, encryptionKey);

      System.out.println("decrypt: " + decrypted);

      ArrayList<Character> charDecrypt = new ArrayList<Character>();
      
      for (int i = 0; i < decrypted.length(); i++)
		{
    	  	charDecrypt.add(decrypted.charAt(i));
				
		}
      
      int num=0;
      int len=15;

      while(charDecrypt.get(len)=='0')
      {
    	  charDecrypt.remove(len);
    	  num++;
    	  System.out.println("pass"+num+" = "+charDecrypt);
    	  len--;
      }
  
      String decrypting = charDecrypt.stream().map(e->e.toString()).reduce((acc, e) -> acc + e).get();
      
      System.out.println("charDecrypt: " + charDecrypt);
      System.out.println("decrypting: " + decrypting);

    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
    byte [] newci = null;
    try{
    	newci = cipher.doFinal(cipherText);
    }catch(IllegalBlockSizeException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (BadPaddingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace(); }
  return new String(newci);
  }
}