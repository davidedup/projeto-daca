package br.com.ufcg.bibliotecaccc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufcg.bibliotecaccc.model.Autor;
import br.com.ufcg.bibliotecaccc.repositories.AutorRepository;

@Service("autoService")
public class AutorServiceImpl implements AutorService{

	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<Autor> findAllAutores() {
		Iterable<Autor> autores = this.autorRepository.findAll();
		List<Autor> produtosList = toList(autores);
		
		return produtosList;
	}
	
	
	//colocar em classe util
	public static <T> List<T> toList(Iterable<T> iterable) {
		ArrayList<T> list = new ArrayList<T>();

		for (T t : iterable) {
			list.add(t);
		}

		return list;
	}

}
