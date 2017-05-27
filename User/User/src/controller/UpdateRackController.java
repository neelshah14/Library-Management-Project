package controller;

import dao.RackDao;
import view.Alert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateRackController {

//This is the Text box element in the view for name of product
	@FXML	private TextField rack_name;

	@FXML	private TextField no_of_rack;
	@FXML   private TextField rack_id;
	@FXML   private Button updateRack;
	@FXML   private Button exit;

	//Method to set the parent stage of the current view
	public void setDialogStage(Stage dialogStage) {
	}

	public void updateRack(){

		try{
			//System.out.println("ads");

			int no_of_rack;
			int rack_id;
			String rack_name;

			/*if(this.edition.getText().trim().equals("") || this.edition.getText().trim()==null ||
					this.book_id.getText().trim().equals("") || this.book_id.getText().trim()==null ||
					this.book_name.getText().trim().equals("") || this.book_name.getText().trim().length()>10 ||
					this.no_of_books.getText().trim().length()>9 || this.no_of_books.getText().trim()==null)
					{
				Alert.display("Error", "Enter valid value");
				return;
			}*/

			//Extract the data from the view elements

			rack_name=this.rack_name.getText();
			no_of_rack= Integer.parseInt(this.no_of_rack.getText());
			rack_id= Integer.parseInt(this.rack_id.getText());

//System.out.println("assa");
			if(no_of_rack == 0) {
				System.out.println("Id should be greater than 0");
				return;
			}

			//Create a DAO instance of the model
			RackDao ur = new RackDao();
			//Use the DAO to persist the model to database
			try{

				ur.updateRack( rack_name,no_of_rack,rack_id);
			// System.out.println("dao in");
			}
			catch(Exception e)
			{e.printStackTrace();}

			//Close the stage after saving
			Alert.display("Response", "Rack updated successfully");
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

	}
	public void close() {
		 rack_name.getScene().getWindow().hide();
		//dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
	}


}
