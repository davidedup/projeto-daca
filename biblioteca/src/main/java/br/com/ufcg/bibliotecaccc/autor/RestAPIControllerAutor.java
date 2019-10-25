package br.com.ufcg.bibliotecaccc.autor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class RestAPIControllerAutor {
	
	@Autowired
	private AutorService autorService = new AutorServiceImpl();
	
	@RequestMapping(value = "/nome-autor", method = RequestMethod.GET)
	public String getNomeAutor(@RequestHeader("Authorization") String autorizacao) {
		return this.autorService.getNomeAutor(autorizacao);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> listarAutores() {
		List<Autor> autores = autorService.findAllAutores();	
		return new ResponseEntity<List<Autor>>(autores, HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.POST, consumes = 
	{MediaType.APPLICATION_JSON_VALUE}, produces = 
	{MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> casdastraAutor(@RequestBody Autor autor) {
		autor = this.autorService.cadastraAutor(autor);	
		return new ResponseEntity<>(autor, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarAutor(@PathVariable("id") long id) {
		Autor autor = this.autorService.findById(id);
		return new ResponseEntity<Autor>(autor, HttpStatus.OK);	
	}
	
	@DeleteMapping(path =  "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		autorService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
