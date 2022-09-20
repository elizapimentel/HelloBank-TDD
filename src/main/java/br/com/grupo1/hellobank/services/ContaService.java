package br.com.grupo1.hellobank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupo1.hellobank.models.Cliente;
import br.com.grupo1.hellobank.models.Conta;
import br.com.grupo1.hellobank.repositories.ContaRepo;

@Service
public class ContaService {

  @Autowired
  private ContaRepo repo;

  public List<Conta> listarContas() {
    return repo.findAll();
  }

  public Conta buscarContaPorId(Long id) {
    return repo.findById(id).get();
  }

  @Transactional
  public Conta cadastrarConta(Conta conta) {
    return repo.save(conta);
  }

  public boolean contaExistePorNumeroConta(int numeroConta) {
    return repo.existsByNumeroConta(numeroConta);
  }

  public boolean clienteJaPossuiConta(Cliente cliente) {
    return repo.findByCliente(cliente).size() > 0;
  }

  public Conta atualizarConta(Conta conta) {
    return repo.save(conta);
  }

  @Transactional
  public void deletarConta(Long id) {
    repo.deleteById(id);
  }
  
}
