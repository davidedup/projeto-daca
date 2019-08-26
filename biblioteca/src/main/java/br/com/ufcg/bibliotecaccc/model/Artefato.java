package br.com.ufcg.bibliotecaccc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_artefato")
public class Artefato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
//	@OneToMany
//	@Column(name = "autores")
//	private Set<Autor> autores;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "palavras")
	private String palavrasChaves;
	
	@Column(name = "data")
	private String data;

	public Artefato() {
		
	}
	
	public Artefato(Set<Autor> autores, String titulo, String palavrasChaves, String data) {
		//this.autores = autores;
		this.titulo = titulo;
		this.palavrasChaves = palavrasChaves;
		this.data = data;
	}

//	public Set<Autor> getAutores() {
//		return autores;
//	}

//	public void setAutores(Set<Autor> autores) {
//		this.autores = autores;
//	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPalavrasChaves() {
		return palavrasChaves;
	}

	public void setPalavrasChaves(String palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
		
}