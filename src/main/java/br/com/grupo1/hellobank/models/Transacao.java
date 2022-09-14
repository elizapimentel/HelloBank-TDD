package br.com.grupo1.hellobank.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
@Table(name = "transacoes")
public class Transacao {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String tipo;
  private Double valor;
  private LocalDate data; // String for tests, LocalDate for production
  private String descricao;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_destinatario")
  @MapsId
  @JsonIgnoreProperties("id")
  private Cliente destinatario;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_remetente")
  @MapsId
  @JsonIgnoreProperties("id")
  private Cliente remetente;
  
}
