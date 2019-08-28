package br.com.ufcg.bibliotecaccc.service;

import java.util.List;

import br.com.ufcg.bibliotecaccc.model.Artefato;

public interface ArtefatoService {

	public List<Artefato> findAllArtefatos();

	public Artefato cadastraArtefato(Artefato artefato);

	public Artefato findById(long id);

}
