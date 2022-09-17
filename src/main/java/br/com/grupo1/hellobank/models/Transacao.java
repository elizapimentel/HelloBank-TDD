package br.com.grupo1.hellobank.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;


@Data
@Entity
@Table(name = "transacao")
public class Transacao {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String tipo;
  private Double valor;
  
  @CreationTimestamp
  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime data; // String for tests, LocalDateTime for production

  private String descricao;

  @OneToOne
  @JoinColumn(name = "id_destinatario")
  private Cliente destinatario;

  @OneToOne
  @JoinColumn(name = "id_remetente")
  private Cliente remetente;
  
}
