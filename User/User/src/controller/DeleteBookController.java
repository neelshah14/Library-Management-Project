package controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import dao.BookDao;


public class DeleteBookController {

	private Stage dialogStage;

	//This is the Text box element in the view for name of book
			@FXML
			private TextField book_ID;

			//Method to set the parent stage of the current view
			public void setDialogStage(Stage dialogStage) {
				this.dialogStage = dialogStage;
			}
			public void DeleteButton(){
				Integer book_ID;
				//Extract the data from the view elements
				book_ID = Integer.parseInt(this.book_ID.getText());
				//validate
				if(book_ID == null || book_ID == 0){
					return;
				}
				//Create a DAO instance of the model
				BookDao b = new BookDao();
				//Use the DAO to persist the model to database
				b.delete(book_ID);
				//Close the stage after saving
				close();
			}
			public void Exit(){
				close();
			}
			private void close(){
				dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
			}
}
