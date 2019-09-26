package br.com.ufcg.bibliotecaccc.colecao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ufcg.bibliotecaccc.artefato.Artefato;
import br.com.ufcg.bibliotecaccc.autor.Autor;

@Entity
@Table(name = "tb_colecao")
public class Colecao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToOne
	private Autor autor;
	
	@ManyToMany
	private Set<Artefato> artefatos;
	
	public Colecao() {
		
	}

	public Colecao(String nome, String descricao, Set<Artefato> artefatos, Autor autor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.artefatos = artefatos;
		this.autor = autor;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	public Set<Artefato> getArtefatos() {
		return artefatos;
	}
	public void setArtefatos(Set<Artefato> artefatos) {
		this.artefatos = artefatos;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return this.getNome() + "/n Criado por: " + this.getAutor().getNome() + "/n Trablahos: " + this.getArtefatos().toString();
	}	
	
	
}
