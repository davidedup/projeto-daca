package br.com.ufcg.bibliotecaccc.artefato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import br.com.ufcg.edu.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.bibliotecaccc.autor.Autor;
import br.com.ufcg.edu.kafka.Producer;

@RestController
@RequestMapping("/artefato")
public class RestAPIControllerArtefato {

	@Autowired
	private ArtefatoService artefatoService = new ArtefatoServiceImpl();
	
//	@Autowired
//	private final Producer producer;
//	
//	public RestAPIControllerArtefato(Producer producer) {
//		this.producer = producer;
//	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Artefato>> listaArtefatos() {
		List<Artefato> artefatos = artefatoService.findAllArtefatos();
		return new ResponseEntity<List<Artefato>>(artefatos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> casdastraArtefato(@RequestBody Artefato artefato) {
		artefato = this.artefatoService.cadastraArtefato(artefato);
//
//		this.producer.sendMessage("OLAA");
		
		return new ResponseEntity<>(artefato, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultaArtefato(@PathVariable("id") long id) {
		Artefato artefato = this.artefatoService.findById(id);
		return new ResponseEntity<Artefato>(artefato, HttpStatus.OK);
	}

}
