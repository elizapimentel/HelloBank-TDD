package br.com.grupo1.hellobank.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacoesTests {
  
  @Test
  void validarAtributos() {
    var transacao = new Transacao();

    transacao.setTipo("Depósito");
    transacao.setValor(50.00);
    transacao.setDescricao("Depósito de R$50,00");

    assertEquals("Depósito", transacao.getTipo());
    assertEquals(50.00, transacao.getValor());
    assertEquals("Depósito de R$50,00", transacao.getDescricao());

  }
}
