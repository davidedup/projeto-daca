package br.com.ufcg.bibliotecaccc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	//TODO: manda o autor na requisição ou pega ele do BD ?
	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> casdastraArtefato(@RequestBody Artefato artefato) {
		System.out.println("Cadastra artefato");
		
		ArrayList idsDosAutores = new ArrayList();
		Set<Autor> set =  artefato.getAutores();
		for (Iterator<Autor> it = set.iterator(); it.hasNext(); ) {
	        Autor a = it.next();
	        idsDosAutores.add(a.getId());
	        System.out.println(a.getId());
	    }
		
		this.artefatoService.cadastraArtefato(artefato, idsDosAutores);
		return new ResponseEntity<>(artefato, HttpStatus.CREATED);
	}
	
}
