package br.com.grupo1.hellobank.controllers;

import java.util.List;

import org.apache.http.HttpStatus;
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

  @GetMapping
  public List<Conta> buscarContas() {
    return contaService.listarContas();
  }

  @PostMapping
  public ResponseEntity<Object> criarConta(@RequestBody Conta conta) {
    var idCliente = conta.getCliente().getId();
    var cliente = clienteService.buscarClientePorId(idCliente);
    boolean contaExiste = contaService.contaExistePorNumeroConta(conta.getNumeroConta());

    // TODO Validar se o cliente já possui uma conta
    boolean clienteJaPossuiConta = conta.getCliente().getConta() != null;
    
    if (contaExiste || clienteJaPossuiConta || cliente == null) {
      return ResponseEntity.status(HttpStatus.SC_CONFLICT).body("Requisição inválida. Uma conta com esse número já existe ou o cliente informado já possui uma conta, ou o cliente informado não existe.");
    }
    return ResponseEntity.status(HttpStatus.SC_CREATED).body(contaService.cadastrarConta(conta));
  }

  @GetMapping("/{id}")
  public Conta buscarPorId(@PathVariable Long id) {
    return clienteService.buscarClientePorId(id).getConta();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deletarConta(@PathVariable Long id) {
    Conta conta = clienteService.buscarClientePorId(id).getConta();

    if (conta.getId() == null) {
      return ResponseEntity.notFound().build();
    }

    contaService.deletarConta(conta.getId());
    return ResponseEntity.ok().body("Conta deletada com sucesso");
  }

}
