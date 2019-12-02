package br.com.ufcg.bibliotecaccc.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.bibliotecaccc.autor.Autor;

@RestController
@RequestMapping("/login")
public class RestAPIControllerAutenticacao {

//
//	@Autowired
//	private AutenticacaoService autenticacaoService = new AutenticacaoService();
//	
//	@RequestMapping(method = RequestMethod.POST,  consumes = 
//		{MediaType.APPLICATION_JSON_VALUE}, produces = 
//		{MediaType.APPLICATION_JSON_VALUE})
//	public String autenticar(@RequestBody Autor autor) throws Exception {
//		System.out.println("OLAAAA");
//		String token = this.autenticacaoService.singin(autor);
//		return token;
//	}
}
