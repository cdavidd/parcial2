package edu.eci.pdsw.entities;

public class User {
	private String login;
	private String name;
	private String lastName;
	
	public User(String login, String name, String lastName) {
		super();
		this.login = login;
		this.name = name;
		this.lastName = lastName;
	}
        
        public User(){}
        
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		 return "User { login: "+login+", name: "+name+", lastName: "+lastName+" }";
	}

	

}
