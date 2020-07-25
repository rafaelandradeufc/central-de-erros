package br.com.codenation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codenation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String Username);

}
