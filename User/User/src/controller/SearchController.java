package controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BookDao;
import dao.RackDao;
import dao.SectionDao;


//import java.awt.Label;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController implements Initializable{


	@FXML
	private Button searchSection;
	@FXML
	private Button searchBook;
	@FXML
	private Button exit;
	@FXML
	private Button searchRack;
	@FXML
	private TextField searchField;
	//	searchBox.setValue("Sections");
	//	searchBox.setItems(SearchList);

	//make an ui for search page


	//if a book has to be searched
	public void searchBook()
	{
		String key = searchField.getText();
		BookDao r = new BookDao();
		r.search(key);
	}

	//if a rack has to be searched
	public void searchRack()
	{
		String key = searchField.getText();
		RackDao r = new RackDao();
		r.search(key);
	}

	//if a section has to be searched
	public void searchSection()
	{
		String key = searchField.getText();
		SectionDao r = new SectionDao();
		r.search(key);
	}

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

			// close();
		}

	//Method to set the parent stage of the current view
	public void setDialogStage(Stage dialogStage) {
	}
	//@Override
	public void initializable(URL url, ResourceBundle rb){

	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}