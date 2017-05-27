package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import model.AddSection;
import dao.SectionDao;

public class AddSectionController {



	//This is the Text box element in the view for name of book

			@FXML
			private TextField section_ID;
			@FXML
			private TextField section_name;
			@FXML
			private TextField no_of_sections;
			@FXML
			private Button exit;

			//Method to set the parent stage of the current view
			public void setDialogStage(Stage dialogStage) {
			}

			public void AddSection(){
				//System.out.println("hie");
				Integer section_ID;
				Integer no_of_sections;
				//Extract the data from the view elements
				section_ID = Integer.parseInt(this.section_ID.getText());
				no_of_sections= Integer.parseInt(this.no_of_sections.getText());
				String section_name = this.section_name.getText();
				//System.out.println("hi2");
				//Validate the data
				if(section_name == null || section_name.trim().equals("")) {
					return;
				}

				if(section_ID == null || section_ID == 0){
					return;
				}


				if(no_of_sections == null || no_of_sections == 0){
					return;
				}
				//Create the model object
				AddSection section = new AddSection();
				//Set the values from the input form
				//section.setRID(rack_ID);
				section.setSectionID(section_ID);
				section.setSectionName(section_name);
				section.setNoOfSections(no_of_sections);

				//System.out.println("hi3");

				//Create a DAO instance of the model
				SectionDao r = new SectionDao();
				//Use the DAO to persist the model to database
				r.create(section);
				//Close the stage after saving
				close();
			}

			//Method to exit the action
			public void Exit(){
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
				 section_name.getScene().getWindow().hide();
				//dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
			}

		}
