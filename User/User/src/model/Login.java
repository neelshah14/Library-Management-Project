package model;

public class Login {
	private Integer id; //Primary column of the table
	private String username; //Name of the user
	private String password; //pwrd of the user

	public Login(){
	}
	public Login (Integer id, String name, String password) {
		this.id = id;
		this.username = name;
		this.password = password;
	}
	public Integer getID(){
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
