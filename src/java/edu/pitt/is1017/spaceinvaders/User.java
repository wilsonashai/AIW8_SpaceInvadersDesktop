package edu.pitt.is1017.spaceinvaders;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User {
	private int userId;
	private String lastName, firstName, email, password;
	private boolean loggedIn = false;
	private DbUtilities dbU = new DbUtilities();
	
	public User(int u){
		
            String q = "SELECT * FROM users WHERE userID = " + u + ";";
            ResultSet rs = dbU.getResultSet(q);

            // for debug purposes
            try {
                    while(rs.next())
                    {
                            userId = rs.getInt("UserID");
                            lastName = rs.getString("lastName");
                            firstName = rs.getString("firstName");
                            email = rs.getString("email");
                            password = rs.getString("password");
                            //System.out.println(rs.getString("firstName") + " " + rs.getString("lastName"));
                    }
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            dbU.closeConnection();
		
	}
	
	public User(String e, String p){
            String q = "SELECT * FROM users WHERE email = '" + e + "' AND password = '" + p + "'";
            ResultSet rs = dbU.getResultSet(q);

            try {
                                
                // if database returned is empty
                if(rs.next() == false)
                {
                    loggedIn = false;
                    //JOptionPane.showMessageDialog(null, "Invalid login credentials.");
                }
                else
                {
                        loggedIn = true;
                        // return resultset pointer back to beginning
                        rs.first();

                        //System.out.println(rs.getString("firstName"));

                        firstName = rs.getString("firstName");
                        lastName = rs.getString("lastName");
                        userId = rs.getInt("userID");

                        //JOptionPane.showMessageDialog(null, "Valid credentials.");
                }
            } catch (HeadlessException | SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
            }

            // close the db connection
            dbU.closeConnection();
	}
	
	// called when there is a new user
	public User(String l, String f, String e, String p) {
		// set
		setLName(l);
		setFName(f);
		setEmail(e);
		setPw(p);
		
		saveUserInfo(); 		
	}
	
	public void saveUserInfo() {
		// create query string to save new user info to database
		String q = "INSERT INTO users (lastName,firstName,email,password) VALUES ('"
				+ lastName + "','" + firstName + "','" + email + "','" + password + "')";
		//System.out.println(q);
		
		// call Query to insert values into database
		dbU.executeQuery(q);
		
	}

	public int getUserID(){
		
		return this.userId;
	}
	
	// various getter and setter methods
	
	public String getLName(){
		return this.lastName;
	}
	
	public void setLName(String l){
		this.lastName = l;
	}
	
	public String getFName(){
		return this.firstName;
	}
	
	public void setFName(String f){
		this.firstName = f;
	}
	
	public void setEmail(String e)
	{
		this.email = e;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPw(String p){
		this.password = p;
	}
	
	public String getPw() {
		return this.password;
	}
        
        public boolean isLoggedIn(){
            return loggedIn;
        }
}