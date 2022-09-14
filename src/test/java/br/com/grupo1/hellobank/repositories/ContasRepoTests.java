package br.com.grupo1.hellobank.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupo1.hellobank.models.Cliente;
import br.com.grupo1.hellobank.models.Conta;

@SpringBootTest
public class ContasRepoTests {
  
  @Autowired
  private ContaRepo repo;

  @Autowired
  private ClienteRepo clienteRepo;

  @BeforeEach
  public void setUp() {
    repo.deleteAll();
    clienteRepo.deleteAll();
  }

  @Test
  void validarFindAll() {
    List<Conta> contas = repo.findAll();

    assertEquals(0, contas.size());
  }

  @Test
  void validarExistePorNumeroConta() {
    var conta = new Conta();
    var cliente = new Cliente();
    cliente.setNome("Samuel");
    cliente.setEmail("samuel@email.com");
    cliente.setCpf("12345678900");
    cliente.setRg("123456789");
    cliente.setDataNascimento("2022-10-12");
    clienteRepo.save(cliente);
    conta.setCliente(cliente);
    conta.setNumeroConta(12345678);
    conta.setSaldo(50.00);
    repo.save(conta);

    var existe = repo.existsByNumeroConta(12345678);
    assertEquals(true, existe);
  }
}
