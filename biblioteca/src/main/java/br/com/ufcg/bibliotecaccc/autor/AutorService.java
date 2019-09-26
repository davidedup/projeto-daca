package br.com.ufcg.bibliotecaccc.autor;
import java.util.List;

import br.com.ufcg.bibliotecaccc.util.Token;

public interface AutorService {
	
	public List<Autor> findAllAutores();

	public Autor cadastraAutor(Autor autor);

	public Autor findById(long id);

	public Token autenticarAutor(Autor autor) throws Exception;

	public String getNomeAutor(String autorizacao);
	
}
