package project1security;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {
	
	public class Screen extends JFrame implements ActionListener {

		private static final long serialVersionUID = 1L;




		int width, height;




		JButton login = new JButton("Login");

		JButton exit = new JButton("Exit");







		CardLayout layout = new CardLayout();




		JPanel panel = new JPanel();

		JPanel menu = new JPanel(); 




		public Screen(int width, int height) {

		   this.width = width;

		   this.height = height;




		   panel.setLayout(layout);        

		   addButtons();




		   setSize(width, height);

		   setResizable(false);

		   setLocationRelativeTo(null);

		   setVisible(true);

		   setTitle("Password Genie");

		   setDefaultCloseOperation(EXIT_ON_CLOSE);

		   requestFocus();




		}




		private void addButtons() {




		   login.addActionListener(this);

		   exit.addActionListener(this);




		   //menu buttons

		   menu.add(Login);

		   menu.add(Exit);







		   //background colors

		   panel.setBackground(Color.BLUE);

		   menu.setBackground(Color.GREEN);




		   //adding children to parent Panel

		   panel.add(menu,"Menu");




		   add(panel);

		   layout.show(panel,"Menu");




		}




		public void actionPerformed(ActionEvent event) {




		   Object source = event.getSource();




		   if (source == Exit) {

		       System.exit(0);

		   } else if (source == Login) {

		       layout.show(panel, "");

		   } else if (source == settings){




		   }

		}

}
