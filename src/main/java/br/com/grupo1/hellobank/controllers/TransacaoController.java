package br.com.grupo1.hellobank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.hellobank.models.Conta;
import br.com.grupo1.hellobank.models.Transacao;
import br.com.grupo1.hellobank.services.ContaService;
import br.com.grupo1.hellobank.services.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

  @Autowired
  TransacaoService transacaoService;

  @Autowired
  ContaService contaService;

  @GetMapping
  public List<Transacao> listarTransacoes() {
    return transacaoService.listarTransacoes();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Transacao> listarTransacaoPorId(@PathVariable Long id) {
    Transacao transacao = transacaoService.buscarTransacaoPorId(id);

    if (transacao.getId() == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(transacao);
  }

  @PostMapping
  public ResponseEntity<Object> criarTransacao(@RequestBody Transacao transacao) {
    Conta contaOrigem = contaService.buscarContaPorId(transacao.getRemetente().getId());
    Conta contaDestino = contaService.buscarContaPorId(transacao.getDestinatario().getId());

    if (contaOrigem.getSaldo() > transacao.getValor()) {
      contaOrigem.setSaldo(contaOrigem.getSaldo() - transacao.getValor());
      contaDestino.setSaldo(contaDestino.getSaldo() + transacao.getValor());
      transacaoService.fazerTransacao(transacao);
      return ResponseEntity.ok().body("Transação realizada com sucesso!");
    }
    return ResponseEntity.badRequest().body("O remetente não possui saldo suficiente para realizar essa transação.");

  }
}
