package br.com.codenation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.model.User;
import br.com.codenation.model.dto.UserResponseDTO;
import br.com.codenation.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping
	public ResponseEntity<UserResponseDTO> add(@RequestBody User user) {

		User responseUser = authenticationService.authenticate(user.getUsername(), user.getPassword());

		if (responseUser != null) {
			return new ResponseEntity<UserResponseDTO>(UserResponseDTO.toDTO(responseUser,"token"), HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<UserResponseDTO>(HttpStatus.UNAUTHORIZED);

	}
}
