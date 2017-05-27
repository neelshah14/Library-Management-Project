package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.LibUser;

public class UserDao {

	// Connection object
	private Connection connection;
	// Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";

	// Method to save a bank model to database
	public LibUser create(LibUser user) {
		// Get a connection
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}

		// Query to insert a record to the bank table
		String query = "INSERT INTO n_user (ID, password) VALUES (?, ?) ;";
		// Use prepared statements to avoid SQL injection attacks
		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			// Set the parameters to the query
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			// Execute the insert
			statement.executeUpdate();
			// To get the primary key (id) of the newly inserted record
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				// Set the id field of the database to the model
				user.setId(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			user = null;
			System.out.println("Error Creating User: " + e);
		}

		// for checking user credentials
		return user;

	}

	public LibUser verify(LibUser user){
		LibUser users = null;
		   String str ="SELECT * FROM n_users WHERE name = ?;";
		  // System.out.println("outside");
		   try {
				connection = DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				System.out.println("Error creating connection to database: " + e);
				System.exit(-1);
			}
				try(PreparedStatement statement = connection.prepareStatement(str)){

			        	  statement.setString(1, user.getName());
			        	  ResultSet rs = statement.executeQuery();

			          if(rs.next()){
			        	  users = new LibUser(
			        	  rs.getInt("ID"),
			        	  rs.getString("name"),
			        	  rs.getString("password")
			        	  );
			          }

			         }
			          catch (SQLException e)
			          {
			        	  System.out.println(e);
			          }

		   return users;
	}

}
