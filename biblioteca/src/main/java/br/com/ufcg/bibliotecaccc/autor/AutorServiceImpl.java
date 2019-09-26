package br.com.ufcg.bibliotecaccc.autor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufcg.bibliotecaccc.util.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("autorService")
public class AutorServiceImpl implements AutorService{

	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public List<Autor> findAllAutores() {
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

	@Override
	public Autor cadastraAutor(Autor autor) {
		return this.autorRepository.save(autor);
	}


	public Autor findById(long id) {
		return this.autorRepository.getAutorById(id);
	}

	public Token autenticarAutor(Autor autor) throws Exception {
		String email = autor.getEmail();
        String senha = autor.getSenha();
        
        if(!this.autorRepository.getAutorByEmail(email).getSenha().equals(senha)) {
        	throw new Exception(); 
        } 
        Token token = this.gerarToken(email);
        return token;
	}
	
	private Token gerarToken(String email) {
        String tokenString = Jwts.builder()
                .setSubject(email)
                .claim("email", email)
                .signWith(SignatureAlgorithm.HS512, "samambaia")
                .compact();

        Token token = new Token(tokenString);

        return token;
    }

	@Override
	public String getNomeAutor(String autorizacao) {
		Autor autor = this.getAutor(autorizacao);
		String nomeAdmin = autor.getNome();
		return nomeAdmin;
	}
	
	public Autor getAutor(String autorizacao) {
        String email = getEmail(autorizacao);
        Autor autor = autorRepository.getAutorByEmail(email);
        return autor;
    }
	
	public String getEmail(String autorizacao) {
        String login = (String) Jwts.parser().setSigningKey("samambaia").parseClaimsJws(autorizacao).getBody().get("email");
        return login;
    }
	

}
