package br.com.ufcg.bibliotecaccc.autor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("autorService")
public class AutorServiceImpl implements AutorService {

	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<Autor> findAllAutores() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Iterable<Autor> autores = this.autorRepository.findAll();
		List<Autor> autoresList = toList(autores);
		
		return autoresList;
	}
	
	//colocar em classe util
	public static <T> List<T> toList(Iterable<T> iterable) {
		ArrayList<T> list = new ArrayList<T>();

		for (T t : iterable) {
			list.add(t);
		}

		return list;
	}

	@CacheEvict(cacheNames = "Autor", allEntries = true)
	@Override
	public Autor cadastraAutor(Autor autor) {
		return this.autorRepository.save(autor);
	}


	public Autor findById(long id) {
		return this.autorRepository.getAutorById(id);
	}
	

	@CacheEvict(cacheNames = "Autor", allEntries = true)
	@Override
	public void delete(Long id) {
		this.autorRepository.deleteById(id);	
	}
	
	@Cacheable(cacheNames = "Autor", key="#root.method.name")
	@Override
	public List<Autor> findAllAutores2() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Iterable<Autor> autores = this.autorRepository.findAll();
		List<Autor> autoresList = toList(autores);
		
		return autoresList;
	}
	
	@Transactional
	@Override
	public void notificaNovoArtefato(String message) {
		Iterable<Autor> autores = this.autorRepository.findAll();
		System.out.println(autores);
		for (Autor autor : autores) {
			System.out.println(autor.getNome());
			autor.getNotificacao().add(message);
			System.out.println(autor.getNotificacao());
			this.autorRepository.save(autor);
		}
		
	}

}
