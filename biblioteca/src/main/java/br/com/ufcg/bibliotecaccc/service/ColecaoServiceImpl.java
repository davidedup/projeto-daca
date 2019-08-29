package br.com.ufcg.bibliotecaccc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ufcg.bibliotecaccc.model.Artefato;
import br.com.ufcg.bibliotecaccc.model.Colecao;
import br.com.ufcg.bibliotecaccc.repositories.ColecaoRepository;

@Service("colecaoService")
public class ColecaoServiceImpl implements ColecaoService {

	@Autowired
	private ColecaoRepository colecaoRepository;

	@Override
	public Colecao cadastraColecao(Colecao colecao) {
		this.colecaoRepository.save(colecao);
		return colecao;

	}

	@Override
	public List<Colecao> findAllColecoes() {
		Iterable<Colecao> colecoes = this.colecaoRepository.findAll();
		List<Colecao> colecoesList = toList(colecoes);

		return colecoesList;
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
	public List<Colecao> colecoesDeUmAutorPorId(long id) {
		Iterable<Colecao> colecoesIterable = this.colecaoRepository.findAll();
		List<Colecao> colecoesList =  new ArrayList<Colecao>();
		
		for (Colecao colecao : colecoesIterable) {
			if(colecao.getAutor().getId() == id) {
				colecoesList.add(colecao);
			}
		}
		
		return colecoesList;
		
	}

	@Override
	public Colecao adicionaArtefatoEmColecao(long id, Artefato artefato) {
		Colecao colecao = this.colecaoRepository.getColecaoById(id);
		colecao.getArtefatos().add(artefato);
		this.colecaoRepository.save(colecao);
		return colecao;
	}
	
	@Override
	public int totalDeArtefatos(long id) {
		return this.colecaoRepository.getColecaoById(id).getArtefatos().size();
	}
	
	
	

}
