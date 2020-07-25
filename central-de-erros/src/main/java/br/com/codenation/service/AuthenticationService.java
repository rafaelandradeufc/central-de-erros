package br.com.codenation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codenation.model.User;
import br.com.codenation.repository.UserRepository;
import io.jsonwebtoken.Claims;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	public User authenticate(String username, String password) {
		User user = userRepository.findByUsername(username);

		if (user.getPassword().equals(password)) {
			//ver so o token é válido
			return user;
		} else {
			return null;

		}
	}
	
	private  boolean validateToken(String token) {
		Claims claims = tokenService.decodeToken(token);
	
		
		return true;
	}

}
