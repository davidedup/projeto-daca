package br.com.ufcg.bibliotecaccc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.bibliotecaccc.model.Autor;
import br.com.ufcg.bibliotecaccc.service.AutorService;
import br.com.ufcg.bibliotecaccc.service.AutorServiceImpl;

@RestController
@RequestMapping("/autor")
public class RestAPIControllerAutor {
	
	@Autowired
	private AutorService autorService = new AutorServiceImpl();
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> listarAutores() {
		List<Autor> autores = autorService.findAllAutores();	
		return new ResponseEntity<List<Autor>>(autores, HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.POST, consumes = 
	{MediaType.APPLICATION_JSON_VALUE} , produces = 
	{MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> casdastraAutor(@RequestBody Autor autor) {
		this.autorService.cadastraAutor(autor);	
		return new ResponseEntity<>(autor, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarProduto(@PathVariable("id") long id) {
		Autor autor = this.autorService.findById(id);
		return new ResponseEntity<Autor>(autor, HttpStatus.OK);	
	}
	
	
	//	Autor autorAux = new Autor();
	//	autorAux.setEmail(autor.getEmail());
	//	autorAux.setNome(autor.getNome());	
	
}
