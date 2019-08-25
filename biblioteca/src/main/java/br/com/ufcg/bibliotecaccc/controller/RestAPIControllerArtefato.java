package br.com.ufcg.bibliotecaccc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.bibliotecaccc.model.Artefato;
import br.com.ufcg.bibliotecaccc.model.Autor;
import br.com.ufcg.bibliotecaccc.service.ArtefatoService;
import br.com.ufcg.bibliotecaccc.service.ArtefatoServiceImpl;

@RestController
@RequestMapping("/artefato")
public class RestAPIControllerArtefato {

	@Autowired
	private ArtefatoService artefatoService = new ArtefatoServiceImpl(); 
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Artefato>> listaArtefatos() {
		List<Artefato> artefatos = artefatoService.findAllArtefatos();
		
		System.out.print("FUNFOU");
	
		return new ResponseEntity<List<Artefato>>(artefatos, HttpStatus.OK);
	}	
}
