package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Register;

public class RegisterDao {


	//Connection object
	private Connection connection;
	//Database connection parameters
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	public Register create(Register r)
	{
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}
		//Query to insert a record to the bank table
		String query = "INSERT INTO n_users (ID,password,emailId,phoneNo,name) VALUES (?,?,?,?,?) ;";
		//Use prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			//Set the parameters to the query
			statement.setInt(1, r.getUserID());
			statement.setString(2, r.getPassword());
			statement.setString(3, r.getEmailID());
			statement.setInt(4, r.getPhoneNo());
			statement.setString(5, r.getName());

			//Execute the insert
			statement.executeUpdate();
			//			ResultSet resultSet = statement.getGeneratedKeys();
			//			if(resultSet.next()) {
			//				//Set the id field of the database to the model
			//				book.setbook_ID(resultSet.getInt(1));
			//			}
			System.out.println("User added successfully into register");
		}catch(SQLException e){
			r = null;
			System.out.println("Error Creating User: " + e);
		}

		String query1 = "INSERT INTO n_members (ID,phoneNo,email_ID) VALUES (?,?,?) ;";
		//Use prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement1 = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)){
			//Set the parameters to the query
			statement1.setInt(1, r.getUserID());
			statement1.setInt(2, r.getPhoneNo());
			statement1.setString(3, r.getEmailID());

			//Execute the insert
			statement1.executeUpdate();

			System.out.println("User added successfully into member");
		}catch(SQLException e){
			r = null;
			System.out.println("Error Creating User: " + e);
		}
		//To get the primary key (id) of the newly inserted record


		//Close the connection to the database - Very important!!!
		try {
			connection.close();
			connection = null;
		} catch(SQLException e) {
			System.out.println("Error closing connection: " + e);
		}
		return r;
	}
}
