package br.com.grupo1.hellobank.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.grupo1.hellobank.models.Cliente;
import br.com.grupo1.hellobank.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
  
  @Autowired
  private ClienteService service;

  @GetMapping
  public List<Cliente> listarClientes() {
    return service.listarClientes();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> buscarClientePorId(@PathVariable(value = "id") Long id) {
    Cliente cliente = service.buscarClientePorId(id);

    if (cliente.getId() == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(cliente);
  }

  @PostMapping
  public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente) {
    if (service.clienteExistePorCpf(cliente.getCpf())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já cadastrado");
    }
    return ResponseEntity.ok().body(service.cadastrarCliente(cliente));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> atualizarCliente(@PathVariable(value = "id") Long id, @RequestBody Cliente cliente) {
    Cliente clienteAtual = service.buscarClientePorId(id);

    if (clienteAtual.getId() == null) {
      return ResponseEntity.notFound().build();
    }

    BeanUtils.copyProperties(cliente, clienteAtual, "id");
    return ResponseEntity.ok().body(service.atualizarCliente(clienteAtual));
  }


}
