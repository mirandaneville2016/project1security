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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class NewUser extends JFrame {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  JButton create;
  JPanel newUserPanel;
  JTextField txuserer;
  JTextField passer;


  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);


    setSize(300,200);
    setLocation(500,280);
    newUserPanel.setLayout (null); 


    txuserer.setBounds(70,30,150,20);
    passer.setBounds(70,65,150,20);
    create.setBounds(110,100,80,20);

    newUserPanel.add(create);
    newUserPanel.add(txuserer);
    newUserPanel.add(passer);

    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
      File encfile = new File("p1secure.txt");
      File file = new File("userPass.txt");
      Scanner scan = new Scanner(file);;
      
      FileWriter filewrite = new FileWriter(file, true);
      FileWriter encfilewrite = new FileWriter(encfile, true);

      String usertxter = " ";
      String passtxter = " ";
      String punamer = txuserer.getText();
      String ppaswder = passer.getText();
      while (scan.hasNext()) {
        usertxter = scan.nextLine();
        passtxter = scan.nextLine();
      } 
      scan.close();
        if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          txuserer.setText("");
          passer.setText("");
          txuserer.requestFocusInWindow();

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        //write plaintext to userpass 
        filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
        filewrite.close();
        //write encrypted pass to p1secure
        Encrypt.main(ppaswder);
        byte[] cipass= Encrypt.encrypt(ppaswder, Encrypt.encryptionKey);
        encfilewrite.write(punamer+"\r\n" +cipass+ "\r\n");
        encfilewrite.close();
        JOptionPane.showMessageDialog(null,"Account has been created.");
        dispose();
        new Login();



        }
        } catch (IOException d) {
      d.printStackTrace();
    } catch (Exception cipass) {
			// TODO Auto-generated catch bloc
			cipass.printStackTrace();
		}

      }
    });
  } 

}