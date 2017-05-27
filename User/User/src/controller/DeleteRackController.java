package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import dao.RackDao;


public class DeleteRackController {

	private Stage dialogStage;

	//This is the Text box element in the view for name of book
			@FXML
			private TextField rack_ID;
			@FXML
			private Button DeleteRack;
			@FXML
			private Button exit;

			//Method to set the parent stage of the current view
			public void setDialogStage(Stage dialogStage) {
				this.dialogStage = dialogStage;
			}
			public void DeleteRack(){
				Integer rack_ID;
				//Extract the data from the view elements
				rack_ID = Integer.parseInt(this.rack_ID.getText());
				//validate
				if(rack_ID == null || rack_ID == 0){
					return;
				}
				//Create a DAO instance of the model
				RackDao b = new RackDao();
				//Use the DAO to persist the model to database
				b.delete(rack_ID);
				//Close the stage after saving
				//close();
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
				//close();
			}

}
