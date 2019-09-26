package br.com.ufcg.bibliotecaccc.artefato;

import org.springframework.data.repository.CrudRepository;

public interface ArtefatoRepository extends CrudRepository<Artefato, Long> {

	Artefato getArtefatoById(long id);

}
