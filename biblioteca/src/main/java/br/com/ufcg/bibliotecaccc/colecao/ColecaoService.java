package br.com.ufcg.bibliotecaccc.colecao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ufcg.bibliotecaccc.artefato.Artefato;

public interface ColecaoService {

	public Colecao cadastraColecao(Colecao colecao);

	public List<Colecao> findAllColecoes();

	public List<Colecao> colecoesDeUmAutorPorId(long id);

	public Colecao adicionaArtefatoEmColecao(long id, Artefato artefato);

	public int totalDeArtefatos(long id);

}
