package controller;

import model.Rack;

public class RackController {

	//make a button in ui for this
	public void clickSearch()
	{
		Rack r = new Rack();
		r.search("//get this item from the ui text field");
	}
	
	//Do this same for Section and Book
}
