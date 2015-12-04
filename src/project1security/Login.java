package project1security;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton blogin;
  JPanel loginpanel;
  JTextField txuser;
  JTextField pass;
  JButton newUser;
  JLabel username;
  JLabel password;


  public Login(){
    super("Login Authentification");

    blogin = new JButton("Login");
    loginpanel = new JPanel();
    txuser = new JTextField(15);
    pass = new JPasswordField(15);
    newUser = new JButton("New User?");
    username = new JLabel("User - ");
    password = new JLabel("Pass - ");

    setSize(300,200);
    setLocation(500,280);
    loginpanel.setLayout (null); 


    txuser.setBounds(70,30,150,20);
    pass.setBounds(70,65,150,20);
    blogin.setBounds(110,100,80,20);
    newUser.setBounds(110,135,80,20);
    username.setBounds(20,28,80,20);
    password.setBounds(20,63,80,20);

    loginpanel.add(blogin);
    loginpanel.add(txuser);
    loginpanel.add(pass);
    loginpanel.add(newUser);
    loginpanel.add(username);
    loginpanel.add(password);

    getContentPane().add(loginpanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("p1secure.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("p1secure.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    blogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          File file = new File("p1secure.txt");
          Scanner scan = new Scanner(file);;
          //String line = null;
          //FileWriter filewrite = new FileWriter(file, true);

          String usertxt = " ";
          //String passtxt = " ";
          String puname = txuser.getText();
          String ppaswd = new String(pass.getText());


          while (scan.hasNext()) {
        	  	usertxt = scan.nextLine();
            	byte [] passtxt1 = scan.nextLine().getBytes();
            	String decrypted = Decrypt.decrypt(passtxt1, Decrypt.encryptionKey).toString();
        	  if(puname.equals(usertxt) && ppaswd.equals(decrypted)) {
        		new MainMenu();
        		dispose(); }   
            	} scan.close();




          
          if(puname.equals("") && ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            txuser.setText("");
            pass.setText("");
            txuser.requestFocus();
          }
        } catch (IOException d) {
          d.printStackTrace();
        } catch (Exception decrypted) {
			// TODO Auto-generated catch block
			decrypted.printStackTrace();
		}

      }
    });

    newUser.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
       new NewUser();
        dispose();

      }
    });
  } 

}