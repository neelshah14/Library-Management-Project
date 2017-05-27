package controller;

import dao.UserDao;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mainApp.MainLogin;
import model.LibUser;
import view.Alert;

public class LoginController {
		@FXML
		private static LibUser user;
		@FXML
		private TextField username;
		//Method to set the parent stage of the current view
		@FXML
		private TextField password;
		@FXML
		private Button loginbutton;
		//Method to set the parent stage of the current view
		 private Stage dialogStage;

		//Method to set the parent stage of the current view
		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}
		public void loginbutton()
		{
			LibUser u;
			LibUser input=new LibUser();;

			String username = this.username.getText();
			String password = this.password.getText();
			// System.out.println("ads");
			//Validations
			if(username == null || username.trim().equals("")) {
				Alert.display("Error", "Username Cannot be empty or spaces");
				//System.out.println("Username Cannot be empty or spaces");
				return;
			}
			if(password == null || password.trim().equals("")) {
				Alert.display("Error", "Password Cannot be empty or spaces");
				//System.out.println("Password Cannot be empty or spaces");
				return;
			}
			input.setName(username);
			input.setPassword(password);

			//LibUser l = new LibUser();
			UserDao ud = new UserDao();
			//String username = this.username.getText();
			//String password = this.password.getText();
			u = ud.verify(input);

			//If user not found
			if(u == null) {
				Alert.display("Error","Username cannot be found");
				//System.out.println("Username cannot be found");
				return;
			}
			//If passwords dont match
			if(!(u.getPassword().equals(password.trim()))) {
				Alert.display("Error","Username and Password dont match");
				//System.out.println("Username and Password dont match");
				return;
			}
			//System.out.println(l.toString());

			user = u;
			try {
				AnchorPane root;
				if(username.equals("admin")&&password.equals("admin")) {
					//If user is admin, inflate admin view
					root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/WelAdmin.fxml"));
				} else {
					//If user is customer, inflate customer view
					//System.out.println("abc");
					root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/WelUser.fxml"));
				}
				Scene scene = new Scene(root);
				MainLogin.stage.setScene(scene);
				MainLogin.stage.setTitle("Welcome");
			} catch(Exception e) {
				System.out.println("Error occured while fetching view: " + e);
			}
		}

		public void register()
		{
			try{
				Stage stage;
				Parent root;
				//get reference to the button's stage
		        stage=(Stage) loginbutton.getScene().getWindow();
		        //load up OTHER FXML document
		        root = FXMLLoader.load(getClass().getResource("/View/Register.fxml"));
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
		//This is required as stage.close() in the program will not trigger any events.
		//To have callback listeners on the close event, we trigger the external close event
		private void close() {
			// username.getScene().getWindow().hide();
			dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
		}
}