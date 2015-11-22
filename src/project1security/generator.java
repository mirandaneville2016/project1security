package project1security;
import java.util.*;
import java.io.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class generator 
{

	private static final String Google = null;
	public String siteName = Google;
	public String use = User.getUsername();
	public String si = siteName;
	
	
	 
	private final byte[] keyList = new byte[]{'@','b','c','d','3','f','g','4','!','j','k','7','m','n','0','p','q','r','5','+','u','v','w','*','y','z'};
	
	public String newName(String u,String s)
	{
		byte[] temp = null;
		byte[] newName = null;
		int h = u.length()/2;
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
    
	}
	
}
     
    




