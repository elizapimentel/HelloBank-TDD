package br.com.grupo1.hellobank.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContasTests {
  
  @Test
  void validarAtributos() {
    var conta = new Conta();

    conta.setNumeroConta(12345678);
    conta.setSaldo(1000.0);

    assertEquals(12345678, conta.getNumeroConta());
    assertEquals(1000.0, conta.getSaldo());

  }
}
