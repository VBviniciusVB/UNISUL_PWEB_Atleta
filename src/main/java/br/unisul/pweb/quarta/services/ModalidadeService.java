package br.unisul.pweb.quarta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Modalidade;
import br.unisul.pweb.quarta.repository.ModalidadeRepository;

@Service
public class ModalidadeService {
	
	@Autowired // ela vai injetar comando quando for necessário
	private ModalidadeRepository rep;
	
	//BUSCAR POR ID
	public Modalidade find (Integer id) {
		Optional<Modalidade> obj = rep.findById(id); // c = rep... n foi feito isso para n ter erro
		return obj.orElse(null);
	}
	
	//LISTAR TODAS
	public List<Modalidade> findAll(){
		return rep.findAll();
	}
	
}