package project1security;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

import javax.crypto.Cipher;

public class Decrypt {
  static String IV = "AAAAAAAAAAAAAAAA";
  static byte[] Cyphertext = {-53, -55, -24, -101, 58, -96, 91, 103, -124, 0, -84, -4, -42, 87, 24, -58}; /*Note null padding*/
  static String encryptionKey = "01a2b3c4d5e6f789";

  @SuppressWarnings("null")
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
      
      byte [] byteDecrypt = decrypted.getBytes();
      
//      System.out.println("length of bytes " + byteDecrypt.length);
      
      int num=0;
      int len=15;

      while(byteDecrypt[len]=='0')
      {
    	  byteDecrypt[len]=(Byte) null;
    	  num++;
    	  System.out.println(num);
    	  len--;
      }
//      for(int len=15;len>8;len--)
//      {
//    	  if(byteDecrypt[len]='0')
    		  
//    	  num++;
//      }
      
      
//      System.out.println("position number 16 "+byteDecrypt [0]);
      decrypted = new String(byteDecrypt);
      
      
      
//      int len=15;
          
//      System.out.println(decrypted.substring(len));
      
//      for(int len = 15;len>8;len --)
//      {
//    	  num ++;
//    	  System.out.println(num);  
//    	  if(decrypted.substring(len)=="0")
//    	  {
//    	    	  decrypted=decrypted.replace(decrypted.substring(len),"");
//    	  }
//    	  else
//    		  break;
//     }
      
      System.out.println("decrypt: " + decrypted);
//      while(decrypted.substring(len)=="48")
//      {
//    	  System.out.println("decrypt: " + decrypted);
//    	  num = 0;
//    	  num++;
//    	  System.out.println(num);
//    	  len --;
//      }
      
//      decrypted = decrypted.substring(0, decrypted.length()-num);
      
//      if(decrypted.substring(15)=="0")
//      {
//    	  decrypted=decrypted.replace(decrypted.substring(15),"");
//      }
           
      
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