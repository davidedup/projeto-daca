package br.com.ufcg.bibliotecaccc.model;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_artefato")
public class Artefato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToMany
	@Column(name = "autores")
	private Set<Autor> autores;
	
	@Column(name = "titulo")
	private String titulo;
	
	@ElementCollection
	@CollectionTable(name="palavras", joinColumns=@JoinColumn(name="id"))
	@Column(name = "palavras")
	private Set<String> palavrasChaves;
	
	@Column(name = "data")
	private String data;

	public Artefato() {
		
	}
	
	public Artefato(Set<Autor> autores, String titulo, Set<String> palavrasChaves, String data) {
		this.autores = autores;
		this.titulo = titulo;
		this.palavrasChaves = palavrasChaves;
		this.data = data;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<String> getPalavrasChaves() {
		return palavrasChaves;
	}

	public void setPalavrasChaves(Set<String> palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
		
}