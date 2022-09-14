package br.com.grupo1.hellobank.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.grupo1.hellobank.models.Transacao;

@SpringBootTest
public class TransacoesRepoTests {
  
  @Autowired
  private TransacaoRepo repo;

  @BeforeEach
  public void setUp() {
    repo.deleteAll();
  }

  @Test
  void validarFindAll() {
    List<Transacao> transacoes = repo.findAll();

    assertEquals(0, transacoes.size());
  }
}
