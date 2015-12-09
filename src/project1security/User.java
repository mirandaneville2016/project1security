package project1security;
/*import java.util.Scanner;*/

/*Create user account, attempt login/logout, view sites associated with account as well as passwords*/
public class User{
	
	public User(int aId, String aUsername, String aPassword){
		 userId = aId;
	     username = aUsername;
	     password = aPassword;
	}
		
	public int getId(){
		return userId;
	}

	public void setId(int id){
		this.userId = id;
	}

	public static String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public static String getUsername(){
		return username;
	}

	public void setUsername(String username) {
		User.username = username;
	}
	
	private int userId;
	private static String username;
	private static String password;
}
