package model;

public class LibUser {

	private Integer id;
	private String username;
	private String password;
	// private Boolean admin;

	public LibUser() {
		//Empty Default constructor
	}

	public LibUser(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}