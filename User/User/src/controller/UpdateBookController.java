package controller;

import dao.BookDao;
import view.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateBookController {

//This is the Text box element in the view for name of product
	@FXML	private TextField book_name;
	@FXML	private TextField edition;
	@FXML	private TextField no_of_books;
	@FXML   private TextField book_id;
	@FXML   private Button updateBook;
	@FXML   private Button exit;
	//Method to set the parent stage of the current view
	public void setDialogStage(Stage dialogStage) {
	}

	public void updateBook(){

		try{
			//System.out.println("ads");
			int edition;
			int no_of_books;
			int book_id;
			String book_name;

			/*if(this.edition.getText().trim().equals("") || this.edition.getText().trim()==null ||
					this.book_id.getText().trim().equals("") || this.book_id.getText().trim()==null ||
					this.book_name.getText().trim().equals("") || this.book_name.getText().trim().length()>10 ||
					this.no_of_books.getText().trim().length()>9 || this.no_of_books.getText().trim()==null)
					{
				Alert.display("Error", "Enter valid value");
				return;
			}*/

			//Extract the data from the view elements
			edition = Integer.parseInt(this.edition.getText());
			book_name=this.book_name.getText();
			no_of_books= Integer.parseInt(this.no_of_books.getText());
			book_id= Integer.parseInt(this.book_id.getText());


			if(edition == 0) {
				System.out.println("Id should be greater than 0");
				return;
			}

			//Create a DAO instance of the model
			BookDao u = new BookDao();
			//Use the DAO to persist the model to database
			try{

				u.updateBook(edition, book_name,no_of_books,book_id);
			//System.out.println("dao in");
			}
			catch(Exception e)
			{e.printStackTrace();}

			//Close the stage after saving
			Alert.display("Response", "Book updated successfully");
			close();
			}
			catch(Exception e)
			{	e.printStackTrace();
			}

	}

	public void exit(){

		try{
			Stage stage;
			Parent root;
			//get reference to the button's stage
	        stage=(Stage) exit.getScene().getWindow();
	        //load up OTHER FXML document
	        root = FXMLLoader.load(getClass().getResource("/view/WelAdmin.fxml"));
	      //create a new scene with root and set the stage
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		// close();
	}



	public void close() {
		 book_name.getScene().getWindow().hide();
		// dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
	}


}
