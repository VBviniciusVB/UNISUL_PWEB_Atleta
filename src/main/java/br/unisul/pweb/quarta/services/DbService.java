package br.unisul.pweb.quarta.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.pweb.quarta.domain.Atleta;
import br.unisul.pweb.quarta.domain.Modalidade;
import br.unisul.pweb.quarta.repository.AtletaRepository;
import br.unisul.pweb.quarta.repository.ModalidadeRepository;

@Service
public class DbService {
	
	@Autowired
	private AtletaRepository atlRep;
	
	public void inicializaBancoDeDados() throws ParseException {
		
		Modalidade m1 = new Modalidade(null, "Salto em Distância",null);
		Modalidade m2 = new Modalidade(null, "Salto em Altura",null);
		Modalidade m3 = new Modalidade(null, "Corrida de 100 Metros",null);
		
		Atleta a1 = new Atleta(null, "Pedro",null);
		Atleta a2 = new Atleta(null, "Maria",null);
		Atleta a3 = new Atleta(null, "Vinicius",null);
		
		a1.getModalidade().addAll(Arrays.asList(m1));
		
		a1.getAtleta().addAll(Arrays.asList(m1));
		
		Cidade c1 = new Cidade(null, "Curitiba", e1);
		Cidade c2 = new Cidade(null, "Tubarão", e2);
		Cidade c3 = new Cidade(null, "Gravatal", e2);
		Cidade c4 = new Cidade(null, "Laguna", e2);
		Cidade c5 = new Cidade(null, "Porto Alegre", e3);
		Cidade c6 = new Cidade(null, "Guaíba", e3);
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2, c3, c4));
		e3.getCidades().addAll(Arrays.asList(c5, c6));
		
		Atleta cli1 = new Atleta(null, "João", "JoaoLindo@gmail.com", "10234690968", ModalidadeAtleta.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("48999939252", "48988120771"));
		
		Endereco en1 = new Endereco(null, "Gustavo ", "919", "Apto 422", "Corso"     , "8820580", cli1, c2);
		Endereco en2 = new Endereco(null, "Filipe", "283", "Condomínio"    , "Laguna", "88748020", cli1, c3);
		cli1.getEnderecos().addAll(Arrays.asList(en1, en2));
		
		estRep.saveAll(Arrays.asList(e1,e2,e3));
		cidRep.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
		
		clieRep.saveAll(Arrays.asList(cli1));
		endRep.saveAll(Arrays.asList(en1, en2));
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		atlRep.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRep.saveAll(Arrays.asList(p1,p2,p3));
	}

}