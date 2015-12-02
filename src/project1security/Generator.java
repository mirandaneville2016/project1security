package project1security;
import java.util.*;

public class Generator 
{

	//* below array creates the key to create the password//
		private final byte[] keyList = new byte[] {'@','b','c','d','3','f','g','4','!','j','k','7','m','n','0','p','q','r','5','+','u','v','w','*','y','z'};
		private final byte[] alpha= new byte[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		private final byte[] caps = new byte[] {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};  

	
	
	// this method is where all of the cool stuff happens, splits the username in two then puts last half in front followed by 
	// the sitename followed by the last half of the username.  Then runs it against the key
	public String securepword(String u,String s)
	{
		
		String pword = "";
		ArrayList <Character> temp = new ArrayList<Character>();
		ArrayList <Character> newName = new ArrayList<Character>();
		int h = u.length()/2;
		//creates new word
		for (int i = 0; i < u.length(); i++)
		{
			if (i<h)
				temp.add(u.charAt(i));
			else 
				newName.add(u.charAt(i));
				
		}
		System.out.println(newName +" "+ temp);
		for (int k = 0; k < s.length(); k ++)
		{
			newName.add(s.charAt(k));
			System.out.println(newName);
		}
		for (int p = 0; p <= temp.size(); p ++)
		{
			newName.add(temp.get(p));
			System.out.println(newName);
		}
		

		//sets it against the key
		byte[] pw = new byte[newName.size()];
		for (int x = 0; x < newName.size(); x ++)
		{
			for (int z = 0; z < alpha.length; z ++)
			{
				if ( x == 5)
				{
					pw[x] = caps[z];
					System.out.println(pw);
				}
				else if(newName.get(x) == alpha[z])
				{
					pw[x] = keyList[z];
					System.out.println(pw);
					
				}
					
			}
			if(isThere(pw)== false)
			{
				pw[pw.length] = '@';
			}
			pword = pw.toString();
		}
		if (pword.length()< 9)
		{
			 int hm = 9 - pword.length();
			 while (hm < 0)
			 {
				 pword = pword + "S";
			 }
		}
		
		
		return pword;
		
				
    
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
	}
	
}
     
 



