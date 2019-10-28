package br.com.ufcg.bibliotecaccc.authentication;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import br.com.ufcg.bibliotecaccc.autor.AutorRepository;
import br.com.ufcg.bibliotecaccc.security.AuthenticationConfig;
import br.edu.ufcg.biblioteca.role.Authority;

@Service("authenticationService")
public class AuthenticationService {

	@Autowired
	private AutorRepository autorRepository;
	
	
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public String signin(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			String token = jwtTokenProvider.createToken(email);
			
			JSONObject json = new JSONObject();
	
			return json.toString();
			
		} catch (AuthenticationException e) {
			throw new Exception("Invalid username/password supplied");
		}
	}

}
