package br.com.grupo1.hellobank.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "contas")
public class Conta {

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "cliente_id")
  @MapsId
  @JsonIgnoreProperties("conta")
  private Cliente idCliente;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 8, name = "numero_conta")
  private Integer numeroConta;

  @Column(nullable = false)
  private Double saldo;

}
