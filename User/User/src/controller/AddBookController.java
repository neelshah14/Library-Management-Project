package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.Alert;
import javafx.stage.Stage;
import model.AddBook;
import dao.BookDao;

public class AddBookController {

	//This is the Text box element in the view for name of book
			@FXML
			private TextField book_ID;
			//Method to set the parent stage of the current view
			@FXML
			private TextField rack_ID;
			@FXML
			private TextField book_name;
			@FXML
			private TextField author;
			@FXML
			private TextField edition;
			@FXML
			private TextField ISBN;
			@FXML
			private TextField no_of_books;
			@FXML
			private Button exit;


			//Method to set the parent stage of the current view
			public void setDialogStage(Stage dialogStage) {
			}

			public void AddButton(){
				Integer book_ID;
				Integer rack_ID;
				Integer edition;
				Integer ISBN;
				Integer no_of_books;
				//Extract the data from the view elements
				book_ID = Integer.parseInt(this.book_ID.getText());
				rack_ID = Integer.parseInt(this.rack_ID.getText());
				edition = Integer.parseInt(this.edition.getText());
				ISBN = Integer.parseInt(this.ISBN.getText());
				no_of_books = Integer.parseInt(this.no_of_books.getText());
				String author = this.author.getText();
				String book_name = this.book_name.getText();
				//Validate the data
				if(author == null || author.trim().equals("")) {
					Alert.display("Error"," Please valid Enter Author");
					return;
				}
				if(book_name == null || book_name.trim().equals("")) {
					Alert.display("Error","Enter valid Book Name");
					return;
				}
				if(book_ID == null || book_ID == 0){
					Alert.display("Error","Enter valid Book ID");
					return;
				}
				if(rack_ID == null || rack_ID == 0){
					Alert.display("Error","Enter valid Rack ID");
					return;
				}
				if(edition == null || edition == 0){
					Alert.display("Error","Enter valid Edition");
					return;
				}
				if (ISBN == null || ISBN.equals("") || ISBN.equals("0")){
					Alert.display("Error","Enter valid ISBN");
					return;
				}
				if(no_of_books == null || no_of_books == 0){
					Alert.display("Error","Enter No of books");
					return;
				}
				if(book_ID== null || author== null || ISBN==null || edition== null || rack_ID== null || no_of_books==null || book_name==null || author==null)
				{
					Alert.display("Error", "Please enter valid details");;
				}
				//Create the model object
				AddBook book = new AddBook();
				//Set the values from the input form
				book.setbook_ID(book_ID);
				book.setRID(rack_ID);
				book.setBookName(book_name);
				book.setAuthor(author);
				book.setEdition(edition);
				book.setNoOfBooks(no_of_books);
				book.setISBN(ISBN);


				//Create a DAO instance of the model
				BookDao b = new BookDao();
				//Use the DAO to persist the model to database
				b.create(book);


				//Close the stage after saving
				close();
			}

			//Method to exit the action
			public void exit(){
				try{
					Stage stage;
					Parent root;
					//get reference to the button's stage
			        stage=(Stage) exit.getScene().getWindow();
			        //load up OTHER FXML document
			        root = FXMLLoader.load(getClass().getResource("/View/WelAdmin.fxml"));
			      //create a new scene with root and set the stage
			        Scene scene = new Scene(root);
			        stage.setScene(scene);
			        stage.show();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				//close();
			}

			//This is required as stage.close() in the program will not trigger any events.
			//To have callback listeners on the close event, we trigger the external close event
			private void close() {
				 book_name.getScene().getWindow().hide();
			//	dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
			}

		}



