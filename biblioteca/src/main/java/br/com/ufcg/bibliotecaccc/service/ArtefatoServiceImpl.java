package br.com.ufcg.bibliotecaccc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufcg.bibliotecaccc.model.Artefato;
import br.com.ufcg.bibliotecaccc.repositories.ArtefatoRepository;
import br.com.ufcg.bibliotecaccc.repositories.AutorRepository;

@Service("artefatoService")
public class ArtefatoServiceImpl implements ArtefatoService {

	@Autowired
	private ArtefatoRepository artefatoRepository;
	@Override
	public List<Artefato> findAllArtefatos() {
		Iterable<Artefato> artefatos = this.artefatoRepository.findAll();
		List<Artefato> artefatosList =  this.toList(artefatos);
		return artefatosList;
	}

	@Override
	public void cadastraArtefato(Artefato artefato) {
		this.artefatoRepository.save(artefato);
	}	
	
	// colocar em classe util
	public static <T> List<T> toList(Iterable<T> iterable) {
		ArrayList<T> list = new ArrayList<T>();

		for (T t : iterable) {
			list.add(t);
		}

		return list;
	}
}
