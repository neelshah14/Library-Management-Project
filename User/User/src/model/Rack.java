package model;

import dao.RackDao;

public class Rack implements Searchable{
	private Integer sectionId;
	private String rackName;
	private Integer rackId;
	private static int NoOfRacks;
	//private List<Book> books = new ArrayList<Book>();

	public Rack()
	{

	}

	public Rack(Integer sectionId, String rackName, Integer rackId)
	{
	//	this.book = books;
		this.rackId = rackId;
		this.rackName = rackName;
		this.sectionId = sectionId;
		NoOfRacks++;
	}

	public void setSectionId(int sectionId)
	{
		this.sectionId = sectionId;
	}

	public int getSectionID()
	{
		return sectionId;
	}

	public int getRackID()
	{
		return rackId;
	}

	public void setRackID(int rackID)
	{
		this.rackId = rackID;
	}

	public void setRackName(String rackName)
	{
		this.rackName = rackName;
	}

	public String getRackName()
	{
		return rackName;
	}

	public int getNoOfRacks()
	{
		return NoOfRacks;
	}

	public int setNoOfRacks(int NoOfRacks)
	{
		return NoOfRacks;
	}

	@Override
	public void search(Object item) {
		// TODO Auto-generated method stub
		RackDao obj = new RackDao();
		Rack r = obj.search(item);
	}
}
