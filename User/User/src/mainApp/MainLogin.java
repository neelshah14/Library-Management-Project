package mainApp;



//import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainLogin extends Application {

	public static Stage stage;
	@Override
	public void start(Stage primaryStage) {

		try {
			stage=primaryStage;
			//Create a loader for the UI components
			FXMLLoader loader = new FXMLLoader();
					loader.setLocation(MainLogin.class.getResource("/view/loginFx.fxml"));
			//Inflate the view using the loader
            AnchorPane root = (AnchorPane) loader.load();
            //Set window title
            primaryStage.setTitle("Welcome");
            //Create a scene with the inflated view
            Scene scene = new Scene(root);
            //Set the scene to the stage
            stage.setScene(scene);
            //Get the controller instance from the loader
            /*LoginController controller = loader.getController();
            controller.setDialogStage(primaryStage);*/
            //Show the view
            stage.show();
		} catch(Exception e) {
			//System.out.println("Error occured while inflating view: " + e);
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
