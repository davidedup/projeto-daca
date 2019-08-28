package br.com.ufcg.bibliotecaccc.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.ufcg.bibliotecaccc.model.Artefato;

public interface ArtefatoRepository extends CrudRepository<Artefato, Long> {

	Artefato getArtefatoById(long id);

}
