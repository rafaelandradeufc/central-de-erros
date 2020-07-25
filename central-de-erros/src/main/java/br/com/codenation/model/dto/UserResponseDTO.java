package br.com.codenation.model.dto;

import br.com.codenation.model.User;

public class UserResponseDTO {

	private String username;
	private String token;

	public UserResponseDTO(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static UserResponseDTO toDTO(User user, String token) {
		return new UserResponseDTO(user.getUsername(), token);
	}

}
