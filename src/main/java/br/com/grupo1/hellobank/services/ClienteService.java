package br.com.grupo1.hellobank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupo1.hellobank.models.Cliente;
import br.com.grupo1.hellobank.repositories.ClienteRepo;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepo repo;

  public List<Cliente> listarClientes() {
    return repo.findAll();
  }

  public Cliente buscarClientePorId(Long id) {
    return repo.findById(id).get();
  }

  @Transactional
  public Cliente cadastrarCliente(Cliente cliente) {
    return repo.save(cliente);
  }

  public boolean clienteExistePorCpf(String cpf) {
    return repo.existsByCpf(cpf);
  }

  public Cliente atualizarCliente(Cliente cliente) {
    return repo.save(cliente);
  }

  @Transactional
  public void deletarCliente(Long id) {
    repo.deleteById(id);
  }
}
