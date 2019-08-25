package br.com.ufcg.bibliotecaccc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.ufcg.bibliotecaccc.model.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>{

	public Autor getAutorById(long id);
	

}

