package br.com.grupo1.hellobank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.hellobank.models.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long> {
  boolean existsByCpf(String cpf);
}
  
