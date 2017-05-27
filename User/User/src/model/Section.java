package model;

import dao.SectionDao;

public class Section implements Searchable{
	private Integer sectionId;
	private String SectionName;

	private static int NoOfSections;
	//private List<Book> books = new ArrayList<Book>();

	public Section()
	{

	}

	public Section(Integer sectionId, String SectionName)
	{
	//	this.book = books;

		this.SectionName = SectionName;
		this.sectionId = sectionId;
		NoOfSections++;
	}

	public void setSectionID(int sectionID)
	{
		this.sectionId = sectionID;
	}

	public int getSectionID()
	{
		return sectionId;
	}

	public void setSectionName(String SectionName)
	{
		this.SectionName = SectionName;
	}

	public String getSectionName()
	{
		return SectionName;
	}

	public int getNoOfSections()
	{
		return NoOfSections;
	}

	public int setNoOfSections(int NoOfSections)
	{
		return NoOfSections;
	}

	@Override
	public void search(Object item) {
		// TODO Auto-generated method stub
		SectionDao obj = new SectionDao();
		Section r = obj.search(item);
	}
}
