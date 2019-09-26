package br.com.ufcg.bibliotecaccc.colecao;

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

import br.com.ufcg.bibliotecaccc.artefato.Artefato;
import br.com.ufcg.bibliotecaccc.autor.Autor;

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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listaColecoesDeAutorById(@PathVariable("id") long id) {
		List<Colecao> colecoesDoAutor = this.colecaoService.colecoesDeUmAutorPorId(id);
		return new ResponseEntity<List<Colecao>>(colecoesDoAutor, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = 
	{MediaType.APPLICATION_JSON_VALUE}, produces = 
	{MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> adicionaArtefatoEmColecao(@PathVariable("id") long id,	@RequestBody Artefato artefato ) {
		Colecao colecao =  this.colecaoService.adicionaArtefatoEmColecao(id, artefato);
		return new ResponseEntity<Colecao>(colecao, HttpStatus.OK);	
	}
	
	@RequestMapping(value = "total/{id}", method = RequestMethod.GET, consumes = 
		{MediaType.APPLICATION_JSON_VALUE}, produces = 
		{MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<?> informacoesDeUmaColecao(@PathVariable("id") long id) {
		int a =  this.colecaoService.totalDeArtefatos(id);
		return new ResponseEntity<>(a, HttpStatus.OK);	
	}
		
	
}
