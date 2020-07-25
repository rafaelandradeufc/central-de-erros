package br.com.codenation.model.dto;

import br.com.codenation.model.User;

public class UserRequestDTO {

	private String username;
	private String password;

	public UserRequestDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public static UserRequestDTO toDTO(User user) {
		return new UserRequestDTO(user.getUsername(), user.getUsername());
	}

}
