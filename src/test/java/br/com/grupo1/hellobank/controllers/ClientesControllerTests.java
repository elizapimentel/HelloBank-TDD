package br.com.grupo1.hellobank.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupo1.hellobank.libs.httpRequests;
import br.com.grupo1.hellobank.models.Cliente;
import br.com.grupo1.hellobank.repositories.ClienteRepo;

@SpringBootTest
public class ClientesControllerTests {
  
  @Autowired
  private ClienteRepo repo;
  
  @BeforeEach
  private void setUp() {
    repo.deleteAll();
  }

  @Test
  void getRequest() throws URISyntaxException, IOException, InterruptedException {
    var request = httpRequests.get("/clientes/");
    
    assertEquals(200, request);
  }

  // @Test
  // void postRequest() throws URISyntaxException, IOException, InterruptedException {
  //   var cliente = new Cliente();

  //   cliente.setNome("Samuel");
  //   cliente.setEmail("samuel@email.com");
  //   cliente.setCpf("12345678901");
  //   cliente.setRg("123456789");
  //   cliente.setDataNascimento("2003-08-04");
  //   cliente.setTelefone("123456789");
  //   cliente.setEstado("SP");
  //   cliente.setCidade("São Paulo");
  //   cliente.setCep("12345678");
  //   repo.save(cliente);

  //   var request = httpRequests.post("/clientes/", cliente);
    
  //   assertEquals(201, request);
  // }

  // @Test
  // void putRequest() throws URISyntaxException, IOException, InterruptedException {
  //   var cliente = new Cliente();

  //   cliente.setNome("Samuel");
  //   cliente.setEmail("samuel@email.com");
  //   cliente.setCpf("12345678902");
  //   cliente.setRg("123456789");
  //   cliente.setDataNascimento("04/08/2003");
  //   cliente.setTelefone("123456789");
  //   cliente.setEstado("SP");
  //   cliente.setCidade("São Paulo");
  //   cliente.setCep("12345678");
  //   repo.save(cliente);

  //   cliente.setNome("Luiz");
  //   cliente.setEmail("samuel@email.com");
  //   cliente.setCpf("12345678900");
  //   cliente.setRg("123456789");
  //   cliente.setDataNascimento("04/08/2003");
  //   cliente.setTelefone("123456789");
  //   cliente.setEstado("SP");
  //   cliente.setCidade("São Paulo");
  //   cliente.setCep("12345678");
  //   repo.save(cliente);

  //   var request = httpRequests.put("/clientes/" + cliente.getId(), cliente);
    
  //   assertEquals(200, request);
  // }
}
