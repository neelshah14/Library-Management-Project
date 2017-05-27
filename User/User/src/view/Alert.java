package view;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;

public class Alert {

	public static void display(String dialogBoxTitle,String msg){
		Stage win=new Stage();
		win.setTitle(dialogBoxTitle);
		win.setMinWidth(300);
		//It is to make sure user doesn't change original window before closing the alert
		win.initModality(Modality.APPLICATION_MODAL);

		Label label=new Label();
		label.setText(msg);
		Button close=new Button();
		close.setText("Close");
		close.setOnAction(e -> win.close());

		VBox layout=new VBox(15);
		layout.getChildren().addAll(label,close);
		layout.setAlignment(Pos.CENTER_LEFT);

		Scene sc=new Scene(layout);
		win.setScene(sc);
		win.showAndWait();

	}

}
