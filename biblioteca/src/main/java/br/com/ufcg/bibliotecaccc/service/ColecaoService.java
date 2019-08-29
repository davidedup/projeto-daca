package br.com.ufcg.bibliotecaccc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ufcg.bibliotecaccc.model.Artefato;
import br.com.ufcg.bibliotecaccc.model.Colecao;

public interface ColecaoService {

	public Colecao cadastraColecao(Colecao colecao);

	public List<Colecao> findAllColecoes();

	public List<Colecao> colecoesDeUmAutorPorId(long id);

	public Colecao adicionaArtefatoEmColecao(long id, Artefato artefato);

	public int totalDeArtefatos(long id);

}
