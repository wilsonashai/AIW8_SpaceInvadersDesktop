package edu.pitt.is1017.spaceinvaders;

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
		// set window size
		setSize(width, height);
		// specifies what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildWindow();
		add(mainPane);
		//pack();
		setVisible(true);
		
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
		
		setLayout(new BorderLayout());
		
		// create JPanel
		mainPane = new JPanel();
		
		// add all components to frame
		mainPane.add(email, BorderLayout.NORTH);
		mainPane.add(emlIn, BorderLayout.NORTH);
		mainPane.add(passwd, BorderLayout.CENTER);
		mainPane.add(pwIn, BorderLayout.CENTER);
		mainPane.add(reg, BorderLayout.SOUTH);
		mainPane.add(login, BorderLayout.SOUTH);
		mainPane.add(cancel,BorderLayout.SOUTH);
		
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
				//call User constructor for with email and password to validate against db
				User logU = new User(emailInput, passwdInput);
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
