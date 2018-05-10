package com.company.security;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = 7158961446044591948L;
	private String username;
	private String password;

	public UserDto() {
		super();
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

}
