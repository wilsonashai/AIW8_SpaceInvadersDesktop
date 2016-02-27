package edu.pitt.is1017.spaceinvaders;

// CHANGE THE LOGIN POPUP TO FIT EXAMPLE !!!!!!!

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class LoginGUI extends JFrame {
	
	private JFrame theWindow;
	private JPanel mainPane;
	private JLabel email;
	private JLabel passwd;
	private JTextField emlIn;
	private JTextField pwIn;
	private JButton reg;
	private JButton login;
	private JButton cancel;
	private final int width = 300;
	private final int height = 125;
	
	public LoginGUI() {
		// sets title of window
		setTitle("SpaceInvaders - Login");
		// specifies what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildWindow();	
		pack();
	}

	private void buildWindow() {
		// TODO Auto-generated method stub
		
		//create Jlabels for email and password
		email = new JLabel("Email: ");
		passwd = new JLabel("Password: ");
		
		//create JTextFields for user input
		emlIn = new JTextField(15);
		pwIn = new JTextField(15);
		
		//create JButtons for register, login, and cancel
		reg = new JButton("Register");
		login = new JButton("Login");
		cancel = new JButton("Cancel");
		
		// add action listener
		reg.addActionListener(new LoginListener());
		login.addActionListener(new LoginListener());
		cancel.addActionListener(new LoginListener());
		
		// set Layout of JFrame
		setLayout(new GridLayout(3,2));
				
		// create JPanel
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		
		// add components to frame
		panel1.add(email);
		panel2.add(emlIn);
		panel3.add(passwd);
		panel4.add(pwIn);
		panel5.add(reg);
		panel6.add(login);
		//panel6.add(cancel);
		
		
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		
		setVisible(true);
	}
	
	//action listener for the login GUI
	private class LoginListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String emailInput, passwdInput, action;
			
			// set input in string variables
			emailInput = emlIn.getText();
			passwdInput = pwIn.getText();
			
			// get string action command from button pressed
			action = e.getActionCommand();
			
			if(action.equals("Register"))
			{
				// validate login against data in the database
				
			}
			else if(action.equals("Login"))
			{
				// call User constructor for with email and password to validate against db
				final User logU = new User(emailInput, passwdInput);
				
				Thread t = new Thread("gameLaunchThread"){
					public void run(){							
						// initiate & call new Game with user object as the parameter
						Game game = new Game(logU);
						game.gameLoop();
						// exit out login GUI
						//mainPane.setVisible(false);
					}
				};
				
				t.start();
			}
			// if user selects 'cancel' button
			else if(action.equals("Cancel"))
			{
				// exit game
				mainPane.setVisible(false);
				System.exit(0);
			}
			
		}
		
	}
	
	// HERE FOR DEBUG PURPOSES
	public static void main (String[] args)
	{
		new LoginGUI();
	}

}
