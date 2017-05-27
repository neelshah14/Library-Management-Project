package model;

public class Member extends LibUser {

	private int phoneNo;
	private String emailID;

public Member(){

}
public Member(Integer id, String username, String password, int phoneNo, String emailID) {
	super(id, username, password);
	this.phoneNo = phoneNo;
	this.emailID = emailID;
}
public int phoneNo() {
	return phoneNo;
}

public void setphoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}

public String getemailID() {
	return emailID;
}

public void setemailID(String emailID) {
	this.emailID = emailID;
}
}