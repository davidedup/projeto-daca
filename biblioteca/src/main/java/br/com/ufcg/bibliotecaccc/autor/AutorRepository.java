package br.com.ufcg.bibliotecaccc.autor;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long>{

	public Autor getAutorById(long id);

	public Autor getAutorByEmail(String email);

	public Object findByEmail(String email);
	

}

