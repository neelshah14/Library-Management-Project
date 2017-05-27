package dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import model.AddSection;
import model.Section;

	public class SectionDao {

		//Connection object
		private Connection connection;
		//Database connection parameters
	    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	    private String username = "fpuser";
	    private String password = "510";

	    //Method to save a book model to database
		public AddSection create(AddSection section) {
			//Get a connection
			try {
				//System.out.println("abc");
	            connection = DriverManager.getConnection(url, username, password);
	        } catch(SQLException e) {
	            System.out.println("Error creating connection to database: " + e);
	            System.exit(-1);
	        }
			//Query to insert a record to the bank table
			String query = "INSERT INTO n_sections (section_id,section_name,no_of_section) VALUES (?, ?, ?) ;";
			//Use prepared statements to avoid SQL injection attacks
			// System.out.println("qry");
			try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
				// System.out.println("fetchdata");
				//Set the parameters to the query
				statement.setInt(1, section.getSectionID());
				statement.setString(2, section.getSectionName());

	            statement.setInt(3, section.getNoOfSections());

	            //Execute the insert
	            statement.executeUpdate();
	          //To get the primary key (id) of the newly inserted record
	            ResultSet resultSet = statement.getGeneratedKeys();
	            if(resultSet.next()) {
	            	// System.out.println("rs");
	            	//Set the id field of the database to the model
	            	section.setSectionID(resultSet.getInt(1));
	            }
	            System.out.println("Section added successfully");
			}catch(SQLException e){
				section = null;
	            System.out.println("Error Creating Section: " + e);
	        }



			//Close the connection to the database - Very important!!!
			try {
	            connection.close();
	            connection = null;
	        } catch(SQLException e) {
	            System.out.println("Error closing connection: " + e);
	        }
			//Return the bank object that was inserted with the id field set.
			return section;
		}
		public Section search(Object obj)
		{
			Section r = null;
			try
			{
				connection = DriverManager.getConnection(url, username, password);
			} catch(SQLException e) {
				System.out.println("Error creating connection to database: " + e);
				System.exit(-1);
			}
			//Query to insert a record to the bank table
			String query = "Select * from n_sections where section_id ="+new Integer(obj.toString())+";";
			//Use prepared statements to avoid SQL injection attacks
			try(PreparedStatement statement = connection.prepareStatement(query)){
				//Execute the insert
				ResultSet resultSet = statement.executeQuery(query);
				String paswd = null;
				if(resultSet.next()) {
					//Set the id field of the database to the model
					System.out.println(resultSet.getInt("section_id"));
					System.out.println(resultSet.getString("section_name"));
					System.out.println(resultSet.getInt("no_of_section"));
					System.out.println("Entry found");
					r = new Section();
					//check the db name for sectionID
					r.setSectionID(resultSet.getInt("section_id"));
					r.setSectionName(resultSet.getString("section_name"));
					r.setNoOfSections(resultSet.getInt("no_of_section"));
				}
			}catch(SQLException e){
				System.out.println("Error validating User: " + e);
			}
			return r;
		}
	}

