package model;
import dao.BookDao;
public class Book implements Searchable{
	private Integer BookID;
	private String book_name;
	private static int no_of_books;
	//Empty Default constructor
public Book(){
	}


public Book (Integer BookID,String book_name,Integer no_of_books)
{
	this.BookID=BookID;

	this.book_name=book_name;
	no_of_books++;

	}
//Getter / Setter methods for each attribute of the class
public int getBookID(){
	return BookID;
}
public void setBookID(Integer BookID) {
	this.BookID = BookID;
}

public String getBookName() {
	return book_name;
}

public void setBookName(String book_name) {
	this.book_name = book_name;
}

public int getNoOfBooks(){
	return no_of_books;
}
public int setNoOfBooks(Integer no_of_books) {
	return no_of_books;
}
@Override
public void search(Object item) {
	// TODO Auto-generated method stub
	BookDao obj = new BookDao();
	Book r = obj.search(item);
}
}