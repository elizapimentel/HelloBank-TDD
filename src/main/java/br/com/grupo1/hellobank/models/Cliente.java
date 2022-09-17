package br.com.grupo1.hellobank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 50)
  private String nome;

  @Column(nullable = false, length = 50, unique = true)
  private String email;

  @Column(nullable = false, length = 11, unique = true)
  private String cpf;

  @Column(nullable = false, name = "registro_geral", length = 15, unique = true)
  private String rg;

  @Column(nullable = false, name = "data_nascimento")
  private String dataNascimento;

  @OneToOne(mappedBy = "cliente")
  @JsonIgnoreProperties("cliente")
  private Conta conta;

  private String telefone;

  @Column(length = 2)
  private String estado;
  private String cidade;
  private String cep;
}
