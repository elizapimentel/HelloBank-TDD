package br.com.grupo1.hellobank.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientesTests {
  
  @Test
  void validarAtributos() {
    var cliente = new Cliente();

    cliente.setNome("Samuel");
    cliente.setEmail("samuel@email.com");
    cliente.setCpf("12345678900");
    cliente.setRg("123456789");
    cliente.setDataNascimento("04/08/2003");
    cliente.setTelefone("123456789");
    cliente.setEstado("SP");
    cliente.setCidade("São Paulo");
    cliente.setCep("12345678");

    assertEquals("Samuel", cliente.getNome());
    assertEquals("samuel@email.com", cliente.getEmail());
    assertEquals("12345678900", cliente.getCpf());
    assertEquals("123456789", cliente.getRg());
    assertEquals("04/08/2003", cliente.getDataNascimento());
    assertEquals("123456789", cliente.getTelefone());
    assertEquals("SP", cliente.getEstado());
    assertEquals("São Paulo", cliente.getCidade());
    assertEquals("12345678", cliente.getCep());
  }
}
