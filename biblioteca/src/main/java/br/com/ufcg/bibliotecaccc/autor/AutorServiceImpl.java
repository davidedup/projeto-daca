package br.com.ufcg.bibliotecaccc.autor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.ufcg.edu.autenticacao.JwtTokenProvider;

@Service("autorService")
public class AutorServiceImpl implements AutorService {

	private JwtTokenProvider jwtTokenProvider;
	
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

	@Override
	public String getNomeAutor(String autorizacao) {
		Autor autor = this.getAutor(autorizacao);
		String nomeAdmin = autor.getNome();
		return nomeAdmin;
	}
	
	public Autor getAutor(String autorizacao) {
        String email = this.jwtTokenProvider.getEmail(autorizacao);
        Autor autor = autorRepository.getAutorByEmail(email);
        return autor;
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

}
