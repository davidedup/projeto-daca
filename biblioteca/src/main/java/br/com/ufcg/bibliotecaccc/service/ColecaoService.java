package br.com.ufcg.bibliotecaccc.service;

import java.util.List;

import br.com.ufcg.bibliotecaccc.model.Colecao;

public interface ColecaoService {

	public Colecao cadastraColecao(Colecao colecao);

	public List<Colecao> findAllColecoes();

}
