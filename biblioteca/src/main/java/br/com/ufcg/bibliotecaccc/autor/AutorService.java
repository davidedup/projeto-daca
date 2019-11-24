package br.com.ufcg.bibliotecaccc.autor;
import java.util.List;

import br.com.ufcg.bibliotecaccc.util.Token;

public interface AutorService {
	
	public List<Autor> findAllAutores();

	public Autor cadastraAutor(Autor autor);

	public Autor findById(long id);

	public void delete(Long id);

	public List<Autor> findAllAutores2();
	
}
