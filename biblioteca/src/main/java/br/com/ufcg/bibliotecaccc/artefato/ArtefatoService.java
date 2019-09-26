package br.com.ufcg.bibliotecaccc.artefato;

import java.util.List;

public interface ArtefatoService {

	public List<Artefato> findAllArtefatos();

	public Artefato cadastraArtefato(Artefato artefato);

	public Artefato findById(long id);

}
