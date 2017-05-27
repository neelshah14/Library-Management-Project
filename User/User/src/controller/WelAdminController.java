package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

//import dao.BookDao;

public class WelAdminController {


			@FXML
			private Button searchBook;
			@FXML
			private Button addSection;
			@FXML
			private Button addBook;
			@FXML
			private Button addRack;
			@FXML
			private Button deleteBook;
			@FXML
			private Button deleteRack;
			@FXML
			private Button updateBook;
			@FXML
			private Button updateRack;
			@FXML
			private Button search;
			@FXML
			private Button exit;

			 //@Override

			 public void addSection()
			 {
					try{

						Stage stage;
						Parent root;
						//get reference to the button's stage
				        stage=(Stage) addSection.getScene().getWindow();
				        //load up OTHER FXML document
				        root = FXMLLoader.load(getClass().getResource("/view/AddSection.fxml"));

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
				 public void addBook()
				 {
					 try{

							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) addBook.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/AddBook.fxml"));

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

				 public void addRack()
				 {
					 try{

							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) addRack.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/AddRack.fxml"));

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

				 public void deleteBook()
				 {
					 try{

							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) deleteBook.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/DeleteRack.fxml"));

					      //create a new scene with root and set the stage
					        Scene scene = new Scene(root);
					        stage.setScene(scene);
					        stage.show();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}							}

				 public void deleteRack()
				 {
					 try{

							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) deleteRack.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/DeleteRack.fxml"));

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
					        stage=(Stage) search.getScene().getWindow();
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

				 public void updateBook()
				 {
					 try{

							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) updateBook.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/updateBook.fxml"));

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

				 public void updateRack()
				 {
					 try{

							Stage stage;
							Parent root;
							//get reference to the button's stage
					        stage=(Stage) updateRack.getScene().getWindow();
					        //load up OTHER FXML document
					        root = FXMLLoader.load(getClass().getResource("/view/updateRack.fxml"));

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
					        root = FXMLLoader.load(getClass().getResource("/View/loginFx.fxml"));
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
				 //This is required as stage.close() in the program will not trigger any events.
					//To have callback listeners on the close event, we trigger the external close event

			 }
