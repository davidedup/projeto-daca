package br.com.ufcg.bibliotecaccc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufcg.bibliotecaccc.model.Autor;
import br.com.ufcg.bibliotecaccc.model.Colecao;
import br.com.ufcg.bibliotecaccc.service.ColecaoService;
import br.com.ufcg.bibliotecaccc.service.ColecaoServiceImpl;

@RestController
@RequestMapping("/colecao")
public class RestAPIControllerColecao {

	@Autowired
	private ColecaoService colecaoService = new ColecaoServiceImpl();
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Colecao>> listaColecoes() {
		List<Colecao> colecoes = colecaoService.findAllColecoes();	
		return new ResponseEntity<List<Colecao>>(colecoes, HttpStatus.OK);
	}	
	
	@RequestMapping(method = RequestMethod.POST, consumes = 
	{MediaType.APPLICATION_JSON_VALUE} , produces = 
	{MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<?> casdastraColecao(@RequestBody Colecao colecao) {
		this.colecaoService.cadastraColecao(colecao);
		return new ResponseEntity<>(colecao, HttpStatus.CREATED);
	}
	
	
	
}
