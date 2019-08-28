package br.com.ufcg.bibliotecaccc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
		return new ResponseEntity<List<Artefato>>(artefatos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = 
	{ MediaType.APPLICATION_JSON_VALUE }, produces = {
	MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> casdastraArtefato(@RequestBody Artefato artefato) {
		artefato = this.artefatoService.cadastraArtefato(artefato);
		return new ResponseEntity<>(artefato, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultaAtefato(@PathVariable("id") long id) {
		Artefato artefato = this.artefatoService.findById(id);
		return new ResponseEntity<Artefato>(artefato, HttpStatus.OK);	
	}

	
	
}
