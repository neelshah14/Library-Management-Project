package model;

public class DeleteRack {
	private Integer rack_ID;
	private String rack_name;

public DeleteRack(){
	}
public DeleteRack (Integer rack_ID,  String rack_name)
{
	this.rack_ID=rack_ID;

	this.rack_name=rack_name;

	}
public Integer getID(){
	return rack_ID;
}
public void setId(Integer rack_ID) {
	this.rack_ID = rack_ID;
}

public String getBookName() {
	return rack_name;
}

public void setBookName(String rack_name) {
	this.rack_name = rack_name;
}

}