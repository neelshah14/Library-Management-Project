package mainApp;


import controller.ViewBookController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainViewBook extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Create a loader for the UI components
			FXMLLoader loader = new FXMLLoader();
					loader.setLocation(MainLogin.class.getResource("/view/ViewBook.fxml"));
			//Inflate the view using the loader
            AnchorPane root = (AnchorPane) loader.load();
            //Set window title
            primaryStage.setTitle("Welcome");
            //Create a scene with the inflated view
            Scene scene = new Scene(root);
            //Set the scene to the stage
            primaryStage.setScene(scene);

           ViewBookController controller = loader.getController();
            controller.setDialogStage(primaryStage);
            //Show the view
            primaryStage.show();
		} catch(Exception e) {
			//System.out.println("Error occured while inflating view: " + e);
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}

