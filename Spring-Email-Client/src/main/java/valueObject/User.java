package valueObject;

import models.Email;

public class User{
	
	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Email email;
	
	public User () {
		
	}
	
	public User (int userId, String username, String password, String firstName, String lastName, Email email) {
		this.setUserId(userId);
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public  Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

}