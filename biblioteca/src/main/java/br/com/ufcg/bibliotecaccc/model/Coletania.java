package br.com.ufcg.bibliotecaccc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

public class Coletania {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "publicador")
	@Column(name = "artigos")
	private Set<Artefato> artigos;
	
	@Column(name = "autor")
	private Autor autor;
	
	public Coletania() {
		super();
	}

	public Coletania(String nome, String descricao, Set<Artefato> artigos, Autor autor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.artigos = artigos;
		this.autor = autor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Artefato> getArtigos() {
		return artigos;
	}
	public void setArtigos(Set<Artefato> artigos) {
		this.artigos = artigos;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}	
}
