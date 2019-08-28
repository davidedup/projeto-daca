package br.com.ufcg.bibliotecaccc.model;

public class ColecaoResumida {
	
	private Colecao colecao;
	private int quantidadeArtefatos;
	private String descricao;

	
	public ColecaoResumida() {
		
	}
	
	public ColecaoResumida(Colecao colecao) {
		this.colecao = colecao;
		this.quantidadeArtefatos = colecao.getArtefatos().size();
		this.descricao = colecao.toString();
	}

	@Override
	public String toString() {
		return "ColecaoResumida [colecao=" + colecao + ", quantidadeArtefatos=" + quantidadeArtefatos + ", descricao="
				+ descricao + "]";
	}
	
	
}
