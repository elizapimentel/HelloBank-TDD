package br.com.grupo1.hellobank.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupo1.hellobank.models.Cliente;

@SpringBootTest
public class ClientesRepoTests {
  
  @Autowired
  private ClienteRepo repo;

  @BeforeEach
  public void setUp() {
    repo.deleteAll();
  }

  @Test
  void validarFindAll() {
    List<Cliente> clientes = repo.findAll();

    assertEquals(0, clientes.size());
  }

  @Test
  void validarExistePorCpf() {
    var cliente = new Cliente();
    cliente.setNome("Samuel");
    cliente.setEmail("samuel@email.com");
    cliente.setCpf("12345678900");
    cliente.setRg("123456789");
    cliente.setDataNascimento("2022-10-12");
    repo.save(cliente);

    var existe = repo.existsByCpf("12345678900");
    assertEquals(true, existe);
  }
}
