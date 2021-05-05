package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;

public class User {
	private int id;
	@NotEmpty(message = "Username không được để trống !")
	private String username;
	@NotEmpty(message = "Fullname không được để trống !")
	private String fullname;
	private int role_id;
	@NotEmpty(message = "Password không được để trống !")
	private String password;
	private Role role;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, @NotEmpty(message = "Username không được để trống !") String username,
			@NotEmpty(message = "fullname không được để trống !") String fullname, int role_id,
			@NotEmpty(message = "password không được để trống !") String password, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.role_id = role_id;
		this.password = password;
		this.role = role;
	}

	public User(int id, String username, String fullname, String password, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.role = role;
	}

	public User(String username, String fullname, String password, int role_id) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.role_id = role_id;
	}
	public User(int id,String username, String fullname, String password, int role_id) {
		super();
		this.id=id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.role_id = role_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", role_id=" + role_id
				+ ", password=" + password + ", role=" + role + "]";
	}

}
