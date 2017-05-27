package dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import model.AddRack;
import model.Rack;

	public class RackDao {

		//Connection object
		private Connection connection;
		//Database connection parameters
	    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	    private String username = "fpuser";
	    private String password = "510";



	    //Method to save a book model to database
		public AddRack create(AddRack rack) {
			//Get a connection
			try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch(SQLException e) {
	            System.out.println("Error creating connection to database: " + e);
	            System.exit(-1);
	        }
			//Query to insert a record to the bank table
			String query = "INSERT INTO n_rack (section_id,rack_id,rack_name,no_of_rack) VALUES (?, ?, ?,?) ;";
			//Use prepared statements to avoid SQL injection attacks
			try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
				//Set the parameters to the query
				statement.setInt(1, rack.getSectionID());
				statement.setInt(2, rack.getRID());
				statement.setString(3, rack.getRackName());
	            statement.setInt(4, rack.getNoOfRacks());

	            //Execute the insert
	            statement.executeUpdate();
	            ResultSet resultSet = statement.getGeneratedKeys();
	            if(resultSet.next()) {
	            	//Set the id field of the database to the model
	            	rack.setRID(resultSet.getInt(1));
	            }
	            System.out.println("Rack added successfully");
			}catch(SQLException e){
	        	rack = null;
	            System.out.println("Error Creating Rack: " + e);
	        }
	            //To get the primary key (id) of the newly inserted record


			//Close the connection to the database - Very important!!!
			try {
	            connection.close();
	            connection = null;
	        } catch(SQLException e) {
	            System.out.println("Error closing connection: " + e);
	        }
			//Return the bank object that was inserted with the id field set.
			return rack;
		}



	public void delete(int rack_ID) {
		//Get a connection
		try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
		//Query to insert a record to the bank table
		String query = "Delete from n_rack where rack_ID = ?";
		//Use prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			//Set the parameters to the query

			statement.setInt(1, rack_ID);

            //Execute the insert
            statement.executeUpdate();
            /*ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
            	//Set the id field of the database to the model
            	book.setbook_ID(resultSet.getInt(1));
            }*/
            System.out.println("Rack deleted successfully");
		}catch(SQLException e){

            System.out.println("Error Deleting Rack: " + e);
        }
           //To get the primary key (id) of the newly inserted record


		//Close the connection to the database - Very important!!!
		try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }

	}
	public Rack search(Object obj)
	{
		Rack r = null;
		try
		{
			connection = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}
		//Query to insert a record to the bank table
		String query = "Select * from n_rack where rack_id ="+new Integer(obj.toString())+";";
		//Use prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query)){
			//Execute the insert
			ResultSet resultSet = statement.executeQuery(query);
			String paswd = null;
			if(resultSet.next()) {
				//Set the id field of the database to the model
				System.out.println(resultSet.getInt("rack_id"));
				System.out.println(resultSet.getString("rack_name"));
				System.out.println(resultSet.getInt("no_of_rack"));
				System.out.println("Entry found");
				r = new Rack();
				//check the db name for rackid
				r.setRackID(resultSet.getInt("rack_id"));
				r.setRackName(resultSet.getString("rack_name"));
				r.setNoOfRacks(resultSet.getInt("no_of_rack"));
			}
		}catch(SQLException e){
			System.out.println("Error validating User: " + e);
		}
		return r;
	}

	public void updateRack(String rack_name,int no_of_rack,int rack_id)
	{
		//Get a connection
		try {
            connection = DriverManager.getConnection(url, username, password);
            //System.out.println("contcn");
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }

		// Query to insert a record to the bank table
		String query = "update n_rack set rack_name=?,no_of_rack=? where rack_id =?;";

		// Use prepared statements to avoid SQL injection attacks
	try{
		System.out.println("qury updte");
		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(3,rack_id);
		statement.setInt(2,no_of_rack);
		statement.setString(1,rack_name);
			// Execute the insert
		statement.executeUpdate();
		System.out.println("updte");
	}
	catch(SQLException e){

        System.out.println("Error Updating Rack: " + e);
    }
       //To get the primary key (id) of the newly inserted record


	//Close the connection to the database - Very important!!!
	try {
        connection.close();
        connection = null;
    } catch(SQLException e) {
        System.out.println("Error closing connection: " + e);
    }
	}


}
