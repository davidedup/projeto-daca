package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Autor;
import service.AutorService;
import service.AutorServiceImpl;

@RestController
@RequestMapping("/autor")
public class RestAPIControllerAutor {
	
	@Autowired
	private AutorService autorService = new AutorServiceImpl();
	

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Autor>> listarAutores() {
		List<Autor> autores = autorService.findAllAutores();
		
		System.out.print("FUNFOU");
	
		return new ResponseEntity<List<Autor>>(autores, HttpStatus.OK);
	}	
	


}
