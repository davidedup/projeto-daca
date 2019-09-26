package br.com.ufcg.bibliotecaccc.colecao;

import org.springframework.data.repository.CrudRepository;

public interface ColecaoRepository extends CrudRepository<Colecao, Long>{

	Colecao getColecaoById(long id);

}
