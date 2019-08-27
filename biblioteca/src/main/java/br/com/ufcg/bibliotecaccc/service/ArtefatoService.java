package br.com.ufcg.bibliotecaccc.service;

import java.util.ArrayList;
import java.util.List;

import br.com.ufcg.bibliotecaccc.model.Artefato;

public interface ArtefatoService {

	public List<Artefato> findAllArtefatos();

	public void cadastraArtefato(Artefato artefato);

}
