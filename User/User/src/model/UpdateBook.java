package model;

public class UpdateBook {
	private String book_name;

	private Integer edition;

	private Integer no_of_books;
	//Empty Default constructor
public UpdateBook(){
	}
//Fully parameterized constructor
public UpdateBook ( String book_name,Integer edition,Integer no_of_books)
{


	this.book_name=book_name;

	this.edition = edition;

	this.no_of_books=no_of_books;
	}
//Getter / Setter methods for each attribute of the class

public String getBookName() {
	return book_name;
}

public void setBookName(String book_name) {
	this.book_name = book_name;
}

public Integer getEdition(){
	return edition;
}
public void setEdition(Integer edition) {
	this.edition = edition;
}


public Integer getNoOfBooks(){
	return no_of_books;
}
public void setNoOfBooks(Integer no_of_books) {
	this.no_of_books = no_of_books;
}

}