package dao;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
//import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.AddBook;
import model.Book;


	public class BookDao {

		//Connection object
		private Connection connection;
		//Database connection parameters
	    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	    private String username = "fpuser";
	    private String password = "510";
	    //Method to save a book model to database
		public AddBook create(AddBook book) {
			//Get a connection
			try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch(SQLException e) {
	            System.out.println("Error creating connection to database: " + e);
	            System.exit(-1);
	        }
			//Query to insert a record to the bank table
			String query = "INSERT INTO n_books (rack_ID,book_ID,book_name,author,edition,ISBN,no_of_books) VALUES (?, ?, ?,?,?,?,?) ;";
			//Use prepared statements to avoid SQL injection attacks
			try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
				//Set the parameters to the query
				statement.setInt(1, book.getRID());
				statement.setInt(2, book.getbook_ID());
				statement.setString(3, book.getBookName());
	            statement.setString(4, book.getAuthor());
	            statement.setInt(5, book.getEdition());
	            statement.setInt(6, book.getISBN());
	            statement.setInt(7, book.getNoOfBooks());
	            //Execute the insert
	            statement.executeUpdate();
	            ResultSet resultSet = statement.getGeneratedKeys();
	            if(resultSet.next()) {
	            	//Set the id field of the database to the model
	            	book.setbook_ID(resultSet.getInt(1));
	            }
	            System.out.println("Book added successfully");
			}catch(SQLException e){
	        	book = null;
	            System.out.println("Error Creating Book: " + e);
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
			return book;
		}


	public void delete(int book_ID) {
		//Get a connection
		try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
		//Query to insert a record to the bank table
		String query = "Delete from n_books where book_ID = ?";
		//Use prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			//Set the parameters to the query

			statement.setInt(1, book_ID);

            //Execute the insert
            statement.executeUpdate();
            /*ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
            	//Set the id field of the database to the model
            	book.setbook_ID(resultSet.getInt(1));
            }*/
            System.out.println("Book deleted successfully");
		}catch(SQLException e){

            System.out.println("Error Deleting Book: " + e);
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

	public class ViewBook {

    	public SimpleIntegerProperty Book_ID=new SimpleIntegerProperty();
    	public SimpleStringProperty Book_name=new SimpleStringProperty();
    	public SimpleStringProperty Author=new SimpleStringProperty();
    	public SimpleIntegerProperty Edition=new SimpleIntegerProperty();
    	public SimpleIntegerProperty ISBN=new SimpleIntegerProperty();
    	public SimpleIntegerProperty No_of_books=new SimpleIntegerProperty();


    	public ViewBook(SimpleIntegerProperty Book_ID, SimpleStringProperty Book_name,
    			SimpleStringProperty Author,
    			SimpleIntegerProperty Edition,

    			SimpleIntegerProperty ISBN,SimpleIntegerProperty No_of_books)
    			 {
    		this.Book_ID = Book_ID;
    		this.Book_name = Book_name;
    		this.Author = Author;
    		this.Edition = Edition;
    		this.ISBN = ISBN;
    		this.No_of_books = No_of_books;
    	}

    	public ViewBook(){}

    		public int getId() {
    		return Book_ID.get();
    	}
    	public String getName() {
    		return Book_name.get();
    	}
    	public String getAuthor() {
    		return Author.get();
    	}
    	public int getEdition() {
    		return Edition.get();
    	}

    	public int getISBN()
    	{
    		return ISBN.get();
    	}

    	public int getNoOfBook()
    	{
    		return No_of_books.get();
    	}

    }


/// observable list in DAO

	private ObservableList<ViewBook> allBookList;
	public ObservableList<ViewBook> getBooks() {
		allBookList = FXCollections.observableArrayList();
		try {
			connection = DriverManager.getConnection(url, username, password);

			String query = "Select book_ID,book_name,author,edition,ISBN,no_of_books from n_books;";
			ResultSet rs = connection.createStatement().executeQuery(query);
			while (rs.next()) {
				ViewBook viewBook = new ViewBook();
				viewBook.Book_ID.set(rs.getInt("book_ID"));
				viewBook.Book_name.set(rs.getString("book_name"));
				viewBook.Author.set(rs.getString("author"));
				viewBook.Edition.set(rs.getInt("edition"));
				viewBook.ISBN.set(rs.getInt("ISBN"));
				viewBook.No_of_books.set(rs.getInt("no_of_books"));
				allBookList.add(viewBook);
			}
			rs.close();

			} catch (Exception e) {
				 e.printStackTrace();
				 System.out.println("Exception");
			 }
		return allBookList;
	}

	public void updateBook(int edition,String book_name,int no_of_books,int book_id)
	{
		//Get a connection
		try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("contcn");
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }

		// Query to insert a record to the bank table
		String query = "update n_books set book_name=?,edition=?,no_of_books=? where book_id =?;";

		// Use prepared statements to avoid SQL injection attacks
	try{
		System.out.println("qury updte");
		PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(4,book_id);
		statement.setInt(3,no_of_books);
		statement.setInt(2,edition);
			statement.setString(1,book_name);
			// Execute the insert
			statement.executeUpdate();
System.out.println("updte");
	}
	catch(SQLException e){

        System.out.println("Error Updating Book: " + e);
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

	public Book search(Object obj)
	{
		Book r = null;
		try
		{
			connection = DriverManager.getConnection(url, username, password);
		} catch(SQLException e) {
			System.out.println("Error creating connection to database: " + e);
			System.exit(-1);
		}
		//Query to insert a record to the bank table
		String query = "Select book_id,book_name,no_of_books from n_books where book_id ="+new Integer(obj.toString())+";";
		//Use prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query)){
			//Execute the insert
			ResultSet resultSet = statement.executeQuery(query);
			String paswd = null;
			if(resultSet.next()) {
				//Set the id field of the database to the model
				System.out.println(resultSet.getInt("book_id"));
				System.out.println(resultSet.getString("book_name"));
				System.out.println(resultSet.getInt("no_of_books"));
				System.out.println("Entry found");
				r = new Book();
				//check the db name for bookid
				r.setBookID(resultSet.getInt("book_id"));
				r.setBookName(resultSet.getString("book_name"));
				r.setNoOfBooks(resultSet.getInt("no_of_books"));
			}
		}catch(SQLException e){
			System.out.println("Error validating User: " + e);
		}
		return r;
	}
	}
