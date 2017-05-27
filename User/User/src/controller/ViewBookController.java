package controller;

import java.net.URL;
import java.util.ResourceBundle;

import dao.BookDao;
import dao.BookDao.ViewBook;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ViewBookController implements Initializable{
	Stage dialogStage;
	@FXML private TableView<ViewBook> ViewBook;
	@FXML private TableColumn<ViewBook, Integer> Book_ID;
	@FXML private TableColumn<ViewBook, String> Book_name;
	@FXML private TableColumn<ViewBook, String> Author;
	@FXML private TableColumn<ViewBook, Integer> ISBN;
	@FXML private TableColumn<ViewBook, Integer> Edition;
	@FXML private TableColumn<ViewBook, Integer> No_of_books;

	//@FXML private Button back;
	//@FXML private Button logout;

	//Database connection parameters
	public ObservableList<ViewBook> data;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Book_ID.setCellValueFactory(new PropertyValueFactory<ViewBook,Integer>("Book_ID"));
		Book_name.setCellValueFactory(new PropertyValueFactory<ViewBook,String>("Book_name"));
		Author.setCellValueFactory(new PropertyValueFactory<ViewBook,String>("Author"));
		Edition.setCellValueFactory(new PropertyValueFactory<ViewBook,Integer>("Edition"));
		ISBN.setCellValueFactory(new PropertyValueFactory<ViewBook,Integer>("ISBN"));
		No_of_books.setCellValueFactory(new PropertyValueFactory<ViewBook,Integer>("No_of_books"));
		data=new BookDao().getBooks();
		ViewBook.setItems(data);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}