package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Register;
import view.Alert;
//import dao.BookDao;
import dao.RegisterDao;

public class RegisterController {

	private Stage dialogStage;

	//This is the Text box element in the view for name of book
			@FXML
			private TextField name;
			//Method to set the parent stage of the current view
			@FXML
			private TextField password;
			@FXML
			private TextField email_ID;
			@FXML
			private TextField user_ID;
			@FXML
			private TextField phone;
			@FXML
			private Button back;
			//Method to set the parent stage of the current view
			public void setDialogStage(Stage dialogStage) {
				this.dialogStage = dialogStage;
			}

			public void loginPage()
			{
				try{
					Stage stage;
					Parent root;
					//get reference to the button's stage
			        stage=(Stage) name.getScene().getWindow();
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
			}

			public void submit(){
				Integer user_ID;
				Integer phone_no;
				//Extract the data from the view elements
				user_ID = Integer.parseInt(this.user_ID.getText());
				phone_no = Integer.parseInt(this.phone.getText());

				String name = this.name.getText();
				String password = this.password.getText();
				String email_ID = this.email_ID.getText();
				//Validate the data
				if(name == null || name.trim().equals("")) {
					Alert.display("Error","Username cannot be Null or Empty");
					return;
				}
				if(password == null || password.trim().equals("")) {
					Alert.display("Error","Password cannot be Null or Empty");
					return;
				}
				if(email_ID == null || email_ID.trim().equals("")) {
					Alert.display("Error","Email ID cannot be Null or Empty");
					return;
				}
				if(user_ID == null || user_ID == 0){
					Alert.display("Error","UserID cannot be Null or Zero");
					return;
				}
				if(phone_no == null || phone_no == 0){
					Alert.display("Error","PhoneNo cannot be Null or Zero");
					return;
				}
				//Create the model object
				Register register = new Register();
				//Set the values from the input form
				register.setName(name);
				register.setPassword(password);
				register.setEmailID(email_ID);
				register.setUserID(user_ID);
				register.setPhoneNo(phone_no);



				//Create a DAO instance of the model
				RegisterDao r = new RegisterDao();
				//Use the DAO to persist the model to database
				r.create(register);


				//Close the stage after saving
				close();
			}

			//Method to exit the action
			public void Exit(){
				close();
			}



			//This is required as stage.close() in the program will not trigger any events.
			//To have callback listeners on the close event, we trigger the external close event
			private void close() {
				// name.getScene().getWindow().hide();
				dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
			}

		}



