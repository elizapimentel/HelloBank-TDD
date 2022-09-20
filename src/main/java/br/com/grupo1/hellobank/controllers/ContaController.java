package br.com.grupo1.hellobank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.hellobank.models.Conta;
import br.com.grupo1.hellobank.services.ClienteService;
import br.com.grupo1.hellobank.services.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

  @Autowired
  ContaService contaService;

  @Autowired
  ClienteService clienteService;

  @PostMapping
  public ResponseEntity<Object> criarConta(@RequestBody Conta conta) {
    var idCliente = conta.getCliente().getId();
    boolean contaExiste = contaService.contaExistePorNumeroConta(conta.getNumeroConta());

    // TODO Validar se o cliente já possui uma conta
    boolean clienteJaPossuiConta = conta.getCliente().getConta() != null;

    if (idCliente == null || clienteJaPossuiConta || contaExiste) {
      return ResponseEntity.badRequest().body("Conta já cadastrada ou cliente não existe!");
    }
    return ResponseEntity.ok().body(contaService.cadastrarConta(conta));
  }

  @GetMapping("/{id}")
  public Conta buscarContaPorId(@PathVariable Long id) {
    return contaService.buscarContaPorId(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletarConta(@PathVariable Long id) {
    Conta conta = clienteService.buscarClientePorId(id).getConta();

    if (conta.getId() == null) {
      return ResponseEntity.badRequest().body("Conta não encontrada!");
    }

    contaService.deletarConta(conta.getId());
    return ResponseEntity.ok().body("Conta deletada com sucesso");
  }

}
