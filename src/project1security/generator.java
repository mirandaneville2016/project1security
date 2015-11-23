package project1security;
import java.util.*;
import java.io.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class generator 
{
	
	
	 //* below array creates the key to create the password//
	private final byte[] keyList = new byte[]{'@','b','c','d','3','f','g','4','!','j','k','7','m','n','0','p','q','r','5','+','u','v','w','*','y','z'};
	private final byte[] alpha= new byte[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private final byte[] caps = new byte[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	// this method is where all of the cool stuff happens, splits the username in two then puts last half in front followed by 
	// the sitename followed by the last half of the username.  Then runs it against the key
	public String securepword(String u,String s)
try	{	
		String securepword = null;
		byte[] temp = null;
		byte[] newName = null;
		int h = u.length()/2;
		//creates new word
		for (int i = 0; i < u.length(); i++)
		{
			if (i<h)
				temp[i]= (byte) u.charAt(i);
			else 
				newName[i] = (byte) u.charAt(i);
				
		}
		for (int k = 0, j = newName.length; k < s.length(); k ++, j++)
		{
			newName[j] = (byte) s.charAt(k);
		}
		for (int p = 0, t = newName.length; p <= temp.length; p ++, t ++)
		{
			newName[t] = temp [p];
		}
		//sets it against the key
		byte[] pw = null;
		for (int x = 0; x < newName.length; x ++)
		{
			for (int z = 0; z < alpha.length; z ++)
			{
				if ( x == 5)
				{
					pw[x] = caps[z];
				}
				else if(newName[x] == alpha[z])
				{
					pw[x] = keyList[z];
					
				}
					
			}
			if(isThere(pw)== false)
			{
				pw[pw.length] = '@';
			}
			securepword = pw.toString();
		}
		if (securepword.length()< 9)
		{
			 int hm = 9 - securepword.length();
			 while (hm < 0)
			 {
				 securepword = securepword + "S";
			 }
		}
		
		return securepword;
				
    
	}
	public boolean isThere(byte[] s)
	{
		boolean yon = false;
		for (int i = 0; i < s.length; i++)
		{
			if (s[i]== 'a' || s[i]== '!' || s[i]=='+' || s[i] == '*'  )
			{
				yon = true;
			}
			
		}
		return yon;
	}throw (NullPointerException);
	
}
     
    




