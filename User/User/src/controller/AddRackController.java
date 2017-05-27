package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AddRack;
import dao.RackDao;

public class AddRackController {

	private Stage dialogStage;

	//This is the Text box element in the view for name of book
			@FXML
			private TextField rack_ID;
			@FXML
			private TextField section_ID;
			@FXML
			private TextField rack_name;
			@FXML
			private TextField no_of_racks;
			@FXML
			private Button exit;


			//Method to set the parent stage of the current view
			public void setDialogStage(Stage dialogStage) {
				this.dialogStage = dialogStage;
			}

			public void AddRack(){
				Integer section_ID;
				Integer rack_ID;
				Integer no_of_racks;
				//Extract the data from the view elements
				section_ID = Integer.parseInt(this.section_ID.getText());
				rack_ID = Integer.parseInt(this.rack_ID.getText());
				no_of_racks= Integer.parseInt(this.no_of_racks.getText());
				String rack_name = this.rack_name.getText();

				//Validate the data
				if(rack_name == null || rack_name.trim().equals("")) {
					return;
				}

				if(section_ID == null || section_ID == 0){
					return;
				}
				if(rack_ID == null || rack_ID == 0){
					return;
				}

				if(no_of_racks == null || no_of_racks == 0){
					return;
				}
				//Create the model object
				AddRack rack = new AddRack();
				//Set the values from the input form
				rack.setRID(rack_ID);
				rack.setSectionId(section_ID);
				rack.setRackName(rack_name);
				rack.setNoOfRacks(no_of_racks);



				//Create a DAO instance of the model
				RackDao r = new RackDao();
				//Use the DAO to persist the model to database
				r.create(rack);
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
				//close();
			}



			//This is required as stage.close() in the program will not trigger any events.
			//To have callback listeners on the close event, we trigger the external close event
			private void close() {
				dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
			}

		}



