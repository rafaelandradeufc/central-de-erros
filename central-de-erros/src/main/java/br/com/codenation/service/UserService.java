package br.com.codenation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.codenation.model.User;
import br.com.codenation.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenService tokenService;

	public User add(User newUser) {

		String token = tokenService.generateToken(newUser);
		return userRepository.save(newUser);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getById(Long id) {
		return userRepository.getOne(id);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
