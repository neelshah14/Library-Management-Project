package model;

public class Register {
	private Integer user_ID;
	private Integer phone_no;
	private String email_ID;
	private String name;
	private String password;


	public Register(){
	}
	public Register (Integer user_ID, Integer phone_no, String email_ID,String name,String password)
	{
		this.user_ID=user_ID;
		this.phone_no=phone_no;
		this.email_ID=email_ID;
		this.name = name;
		this.password = password;

	}
	public Integer getUserID(){
		return user_ID;
	}
	public void setUserID(Integer user_ID) {
		this.user_ID = user_ID;
	}
	public Integer getPhoneNo(){
		return phone_no;
	}
	public void setPhoneNo(Integer phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmailID() {
		return email_ID;
	}

	public void setEmailID(String email_ID) {
		this.email_ID = email_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}