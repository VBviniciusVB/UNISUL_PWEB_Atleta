package br.unisul.pweb.quarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unisul.pweb.quarta.domain.Modalidade;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {

}