package br.com.ufcg.bibliotecaccc.authentication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import br.com.ufcg.bibliotecaccc.autor.AutorRepository;
import br.edu.ufcg.biblioteca.role.Authority;

public class AuthenticationService {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	public String signin(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
			List<Authority> authorities = autorRepository.findByEmail(email).getRoles();			
			String token = jwtTokenProvider.createToken(email, authorities);
			
			JSONObject json = new JSONObject();
			json.put(AuthenticationConfig.TOKEN.toString(), token);
			json.put(AuthenticationConfig.ROLES.toString(), authorities);
	
			return json.toString();
			
		} catch (AuthenticationException e) {
			throw new Exception("Invalid username/password supplied");
		}
	}

}
