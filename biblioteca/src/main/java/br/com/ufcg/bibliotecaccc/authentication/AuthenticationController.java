package br.com.ufcg.bibliotecaccc.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.bibliotecaccc.util.AuthenticationUser;


@RestController
@CrossOrigin
@RequestMapping(value="/authentication")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/signin")
	@ResponseStatus(HttpStatus.OK)
	public String signin(@RequestBody AuthenticationUser userAuth) throws Exception {
		String email = userAuth.getEmail();
		String password = userAuth.getPassword();
		String json = this.authenticationService.signin(email, password);
		return json;
	}
	
}
