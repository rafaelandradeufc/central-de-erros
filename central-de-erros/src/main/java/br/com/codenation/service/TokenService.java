package br.com.codenation.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.codenation.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	private static final long EXPIRATION_TIME = 1800000;
	private static final String KEY_SECRET = "alguma chave secreta";
	private static final String TOKEN_PREFIX = "Bearer ";
	private static final String HEADER_STRING = "Authorization";

	public String generateToken(User user) {
		return Jwts.builder()
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setSubject(String.valueOf(user.getUsername()))
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, KEY_SECRET)
				.compact();
	}
	
	public Claims decodeToken (String token) {
		return Jwts.parser()
				.setSigningKey(KEY_SECRET)
				.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
				.getBody();
	}

}
