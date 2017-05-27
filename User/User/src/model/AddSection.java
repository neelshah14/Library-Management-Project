package model;

public class AddSection {
	private Integer section_ID;

	private String section_name;

	private Integer no_of_sections;

public AddSection(){
	}
public AddSection (Integer section_ID, String section_name,Integer no_of_sections)
{
	this.section_ID=section_ID;

	this.section_name=section_name;
	this.no_of_sections=no_of_sections;
	}
public Integer getSectionID(){
	return section_ID;
}
public void setSectionID(Integer section_ID) {
	this.section_ID = section_ID;
}

public String getSectionName() {
	return section_name;
}

public void setSectionName(String section_name) {
	this.section_name = section_name;
}

public Integer getNoOfSections(){
	return no_of_sections;
}
public void setNoOfSections(Integer no_of_sections) {
	this.no_of_sections = no_of_sections;
}

}