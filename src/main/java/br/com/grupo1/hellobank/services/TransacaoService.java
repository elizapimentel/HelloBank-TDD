package br.com.grupo1.hellobank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupo1.hellobank.models.Transacao;
import br.com.grupo1.hellobank.repositories.TransacaoRepo;

@Service
public class TransacaoService {
  
  @Autowired
  private TransacaoRepo repo;

  public List<Transacao> listarTransacoes() {
    return repo.findAll();
  }

  public Transacao buscarTransacaoPorId(Long id) {
    return repo.findById(id).get();
  }

  @Transactional
  public Transacao fazerTransacao(Transacao transacao) {
    return repo.save(transacao);
  }

  @Transactional
  public void deletarTransacao(Long id) {
    repo.deleteById(id);
  }

  
}
