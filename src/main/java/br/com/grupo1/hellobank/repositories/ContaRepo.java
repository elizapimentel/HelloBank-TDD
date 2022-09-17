package br.com.grupo1.hellobank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.grupo1.hellobank.models.Cliente;
import br.com.grupo1.hellobank.models.Conta;

@Repository
public interface ContaRepo extends JpaRepository<Conta, Long> {
  boolean existsByNumeroConta(int numeroConta);
  List<Conta> findByCliente(Cliente cliente);
}
  

