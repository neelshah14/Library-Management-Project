package model;

public class AddRack {
	private Integer section_ID;
	private Integer rack_ID;
	private String rack_name;

	private Integer no_of_racks;

public AddRack(){
	}
public AddRack (Integer section_ID, Integer rack_ID, String rack_name,Integer no_of_racks)
{
	this.section_ID=section_ID;
	this.rack_ID=rack_ID;
	this.rack_name=rack_name;
	this.no_of_racks=no_of_racks;
	}
public Integer getSectionID(){
	return section_ID;
}
public void setSectionId(Integer section_ID) {
	this.section_ID = section_ID;
}
public Integer getRID(){
	return rack_ID;
}
public void setRID(Integer rack_ID) {
	this.rack_ID = rack_ID;
}
public String getRackName() {
	return rack_name;
}

public void setRackName(String rack_name) {
	this.rack_name = rack_name;
}

public Integer getNoOfRacks(){
	return no_of_racks;
}
public void setNoOfRacks(Integer no_of_racks) {
	this.no_of_racks = no_of_racks;
}

}