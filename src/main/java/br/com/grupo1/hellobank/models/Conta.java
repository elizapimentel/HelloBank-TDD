package br.com.grupo1.hellobank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "conta")
public class Conta {

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 8, name = "num_conta")
  private Integer numeroConta;

  @Column(nullable = false)
  private Double saldo;

}
