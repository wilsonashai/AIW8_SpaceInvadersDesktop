package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;

public class trying {

	public static void main(String[] args) throws SQLException {

		DbUtilities dbU = new DbUtilities();
		String q = "SELECT * FROM users WHERE email = 'ASMITH@GMAIL.COM' AND password = 'aSmith123^'";
		ResultSet rs = dbU.getResultSet(q);
		System.out.println("hi.");
		
		if(rs.next() == false)
			System.out.println("Nope.");
		else
		{
			rs.first();
			//while(rs.next())
				System.out.println(rs.getString("firstName") + " " + rs.getString("lastName"));
		}
		
		dbU.closeConnection();
	}

}
