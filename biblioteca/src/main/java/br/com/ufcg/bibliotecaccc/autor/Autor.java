package br.com.ufcg.bibliotecaccc.autor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "tb_autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "senha")
	private String senha;

	@Column(name = "email")
	private String email;

	@ElementCollection
	@CollectionTable(name = "notificacao", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "notificacao")
	private Set<String> notificacao;

	public Autor(String nome, String email, Set<String> notificacao) {
		this.nome = nome;
		this.email = email;
		this.notificacao = notificacao;
	}

	public Autor() {

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public Set<String> getNotificacao() {
		return this.notificacao;
	}

	public void setNotificacao(Set<String> notificacao) {
		this.notificacao = notificacao;
	}

	@Override
	public String toString() {
		return this.nome + " ";
	}
	

}
