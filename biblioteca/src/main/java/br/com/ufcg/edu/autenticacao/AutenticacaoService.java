package br.com.ufcg.edu.autenticacao;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.json.JSONObject;

import br.com.ufcg.bibliotecaccc.autor.Autor;

@Service
public class AutenticacaoService {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	public String singin(Autor autor) throws Exception {
		String email = autor.getEmail();
		String senha = autor.getSenha();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));	
			String token = jwtTokenProvider.createToken(email);
			
			JSONObject json = new JSONObject();
			json.put("TOKEN", token);
	
			return json.toString();
			
		} catch (AuthenticationException e) {
			throw new Exception("Senha ou email estão incorretos");
		}
	}
	
	
}
