package br.com.ufcg.bibliotecaccc.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.ufcg.bibliotecaccc.artefato.ArtefatoService;
import br.com.ufcg.bibliotecaccc.artefato.ArtefatoServiceImpl;
import br.com.ufcg.bibliotecaccc.autor.AutorService;
import br.com.ufcg.bibliotecaccc.autor.AutorServiceImpl;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	
	@Autowired
	private AutorService autorService = new AutorServiceImpl();

	@KafkaListener(topics = "notificacao", groupId = "group_id")
	public void consume(String message) {
		
		this.autorService.notificaNovoArtefato(message);
		logger.info(String.format("$$ -> Consumed Message -> %s", message));
	}
}