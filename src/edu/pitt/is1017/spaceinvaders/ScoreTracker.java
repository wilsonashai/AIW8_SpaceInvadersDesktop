package edu.pitt.is1017.spaceinvaders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.JOptionPane;

public class ScoreTracker {
	private User user;
	private int currentScore;
	private int highestScore;
	private String gameID;
	private DbUtilities db;
	
	// constructor
	public ScoreTracker(User u)
	{
		this.user = u;
		//System.out.println(u.getLName());
		currentScore = 0;
		gameID = String.valueOf(UUID.randomUUID());
		db = new DbUtilities();
		
//		String statement = "SELECT MAX(scoreValue) FROM alieninvasion.finalscores WHERE fk_userID = '" + user.getUserID() + "';";
//		ResultSet rs = db.getResultSet(statement);
//		
//		// for debugging purposes
//		try {
//			rs.next();
//				System.out.println("Your high score: " + rs.getInt("MAX(scoreValue)"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		db.closeConnection();
	}
	
	public void recordScore(int point)
	{
		// update current score
		currentScore = currentScore + point;
		// insert new score to table
		db = new DbUtilities();
		String statement = "UPDATE alieninvasion.runningscores SET scoreValue=" + currentScore + " WHERE gameID = '" + gameID + "';";
		// update current score in the db
		db.executeQuery(statement);
	}

	public void recordFinalScore()
	{
		db = new DbUtilities();
		// insert final score into final score table
		String statement = "INSERT INTO alieninvasion.finalscores (gameID, scoreValue, fk_userID, dateTimeEntered) VALUES ('" + gameID + "'," + currentScore + "," + user.getUserID() + ", now());";
		db.executeQuery(statement);
		System.out.println("Your final score is: " + currentScore);
		
	}
	
	// getter method for current score
	public int getCurrScore()
	{
		return currentScore;
	}
	
	// getter method for highest score
	public int getHighScore()
	{
		return highestScore;
	}
}
