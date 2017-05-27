package model;

public class AddBook {
	private Integer book_ID;
	private Integer rack_ID;
	private String book_name;
	private String author;
	private Integer edition;
	private Integer ISBN;
	private Integer no_of_books;
	//Empty Default constructor
public AddBook(){
	}
//Fully parameterized constructor
public AddBook (Integer book_ID, Integer rack_ID, String book_name,String author,Integer edition,Integer ISBN,Integer no_of_books)
{
	this.book_ID=book_ID;
	this.rack_ID=rack_ID;
	this.book_name=book_name;
	this.author = author;
	this.edition = edition;
	this.ISBN= ISBN;
	this.no_of_books=no_of_books;
	}
//Getter / Setter methods for each attribute of the class
public Integer getbook_ID(){
	return book_ID;
}
public void setbook_ID(Integer book_ID) {
	this.book_ID = book_ID;
}
public Integer getRID(){
	return rack_ID;
}
public void setRID(Integer rack_ID) {
	this.rack_ID = rack_ID;
}
public String getBookName() {
	return book_name;
}

public void setBookName(String book_name) {
	this.book_name = book_name;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}
public Integer getEdition(){
	return edition;
}
public void setEdition(Integer edition) {
	this.edition = edition;
}

public Integer getISBN(){
	return ISBN;
}
public void setISBN(Integer ISBN) {
	this.ISBN = ISBN;
}
public Integer getNoOfBooks(){
	return no_of_books;
}
public void setNoOfBooks(Integer no_of_books) {
	this.no_of_books = no_of_books;
}

}