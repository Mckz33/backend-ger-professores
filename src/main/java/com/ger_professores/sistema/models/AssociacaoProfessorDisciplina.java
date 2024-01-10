package com.ger_professores.sistema.models;

import com.ger_professores.sistema.enums.StatusAprovacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
public class AssociacaoProfessorDisciplina implements Serializable {
  private static final long SerialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "associacao_id")
  private Long associacaoId;

  @Column(name = "data_registro", nullable = false)
  private LocalDateTime dataRegistro;

  @ManyToOne
  @JoinColumn(name = "disciplina_id")
  private Disciplina disciplina;

  @ManyToOne
  @JoinColumn(name = "usuario_id")
  private Usuario usuario;

  @Enumerated(EnumType.STRING)
  @Column(name = "status_aprovacao")
  private StatusAprovacao statusAprovacao;
}
