package model;

public class DeleteBook {
	private Integer book_ID;
	private String book_name;

public DeleteBook(){
	}
public DeleteBook (Integer book_ID,  String book_name)
{
	this.book_ID=book_ID;

	this.book_name=book_name;

	}
public Integer getbook_ID(){
	return book_ID;
}
public void setId(Integer book_ID) {
	this.book_ID = book_ID;
}

public String getBookName() {
	return book_name;
}

public void setBookName(String book_name) {
	this.book_name = book_name;
}


}