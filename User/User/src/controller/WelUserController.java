package controller;


import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class WelUserController {

	private Stage dialogStage;


			@FXML
			private Button viewBook;
			@FXML
			private Button transaction;
			@FXML
			private Button issueBook;
			@FXML
			private Button searchBook;
			@FXML
			private Button exit;

			 //@Override

			 public void viewBook()
			 {
					try{
						//FXMLLoader loader;
						Stage stage;
					//	Parent root;
						//get reference to the button's stage
				        stage=(Stage) viewBook.getScene().getWindow();
				        //load up OTHER FXML document
				        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ViewBook.fxml"));
				        AnchorPane root = (AnchorPane) loader.load();
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
				 public void searchBook()
				 {
						try{
							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) searchBook.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/Search.fxml"));
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

				 public void transaction()
				 {
						try{
							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) transaction.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/transaction.fxml"));
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


				 public void exit(){
						try{
							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) exit.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/loginFx.fxml"));
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
				 public void cancel()
				 {
					 close();
				 }


					//This is required as stage.close() in the program will not trigger any events.
					//To have callback listeners on the close event, we trigger the external close event
					private void close() {
						dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
					}
			 }
