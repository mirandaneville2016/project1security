package project1security;




import java.awt.FlowLayout;




import javax.swing.JFrame;
import javax.swing.JLabel;

/*import javax.swing.JLabel;*/

import javax.swing.JPasswordField;

import javax.swing.JTextField;




public class NewUserLoginForm extends JFrame { 




	/**

	 * 

	 */

	private static final long serialVersionUID = -7861228710424923365L;

	

	public NewUserLoginForm(){

		// set flow layout for the frame

		this.getContentPane().setLayout(new FlowLayout());

		

		//create JTextField with default text and columns for username and password		

		JLabel helpTx = new JLabel("Please enter your prefered username and password.");

		JTextField fName1 = new JTextField("Username", 10);

		

		JTextField fName2 = new JTextField("");

		JTextField fPass = new JPasswordField(10);

		

		//add textfields to frame

		add(helpTx);
		add(fName1);

		add(fName2);

		add(fPass);

	}

	

	private static void createAndShowGUI(){

		//Create and set up window

		JFrame frame = new NewUserLoginForm();

		//Display the window

		frame.pack();

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

		

	public static void main(String[] args){

		//Schedule a job for the event-dispatching thread:

		//creating and showing this application's GUI.

		javax.swing.SwingUtilities.invokeLater(new Runnable(){

			public void run(){

				createAndShowGUI();

			}

				});

				}

	}

	

   /*User newUser = new User(userId, fName, fPass);*/

   

	/*newUser.setUsername(fName);

	newUser.setPassword(fPass);*/

