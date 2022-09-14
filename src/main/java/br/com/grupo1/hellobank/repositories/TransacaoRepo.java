package br.com.grupo1.hellobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.hellobank.models.Transacao;

@Repository
public interface TransacaoRepo extends JpaRepository<Transacao, Long>{
  
}
