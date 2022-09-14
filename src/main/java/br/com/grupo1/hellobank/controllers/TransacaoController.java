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

import br.com.grupo1.hellobank.models.Transacao;
import br.com.grupo1.hellobank.services.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

  @Autowired
  TransacaoService service;
  
  @GetMapping
  public List<Transacao> listarTransacoes() {
    return service.listarTransacoes();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Transacao> listarTransacaoPorId(@PathVariable Long id) {
    Transacao transacao = service.buscarTransacaoPorId(id);

    if (transacao.getId() == null) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(transacao);
  }

  @PostMapping
  public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
    return ResponseEntity.ok(service.fazerTransacao(transacao));
  }
}
