package edu.pitt.is1017.spaceinvaders;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class RegisterGUI extends JFrame {
	
	private JPanel mainPane;
	private JLabel fName, lName, email, pwrd, confirmPw;
	private JTextField fNameIn, lNameIn, emailIn, pwrdIn, confirmPwIn;
	private JButton regisBut, cancelBut;
	private int width = 300;
	private int height = 400;
	
	public RegisterGUI() {
		// sets title of window
		setTitle("SpaceInvaders - Registration");
				
		// specifies what happens when the close button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildWindow();
		//add(mainPane);
		pack();
		//setVisible(true);
	}
	
	private void buildWindow() {
		
		// create JLabels
		fName = new JLabel("First Name: ");
		lName = new JLabel("Last Name: ");
		email = new JLabel("Email: ");
		pwrd = new JLabel("Password: ");
		confirmPw = new JLabel("Confirm Password: ");
		
		// create JTextFields
		fNameIn = new JTextField(15);
		lNameIn = new JTextField(15);
		emailIn = new JTextField(15);
		pwrdIn = new JTextField(15);
		confirmPwIn = new JTextField(15);
		
		// create JButtons
		regisBut = new JButton("Register");
		cancelBut = new JButton("Cancel");
		// add actionlistener to buttons
		regisBut.addActionListener(new RegisListener());
		cancelBut.addActionListener(new RegisListener());
		
		// set Layout of JFrame
		setLayout(new GridLayout(6,2));
		
		// create JPanels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panel10 = new JPanel();
		JPanel panel11 = new JPanel();
		JPanel panel12 = new JPanel();
		
		// add components to frame
		panel1.add(fName);
		panel2.add(fNameIn);
		panel3.add(lName);
		panel4.add(lNameIn);
		panel5.add(email);
		panel6.add(emailIn);
		panel7.add(pwrd);
		panel8.add(pwrdIn);
		panel9.add(confirmPw);
		panel10.add(confirmPwIn);
		panel12.add(regisBut);
		panel12.add(cancelBut);
		
		// add panels to main frame
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);
		add(panel6);
		add(panel7);
		add(panel8);
		add(panel9);
		add(panel10);
		add(panel11);
		add(panel12);
		
		setVisible(true);	
		
	}
	
	private class RegisListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			String action;
			
			//save input from text fields into string variables
			String fNInpt = fNameIn.getText();
			String lNInpt = lNameIn.getText();
			String pwInpt = pwrdIn.getText();
			String emInpt = emailIn.getText();
			
			User us;
			
			action = e.getActionCommand();
			
			// if user selects register
			if(action.equals("Register"))
			{
				// call constructor to create/add a new user
				us = new User(lNInpt, fNInpt, emInpt, pwInpt);
			}
			// if user selects cancel
			else if(action.equals("Cancel"))
			{
				// exit game
				setVisible(false);
				System.exit(0);
			}
		}
	}
	
	
	// FOR DEBUG PUPOSES
	public static void main(String[] args) {
		new RegisterGUI();
	}
}
