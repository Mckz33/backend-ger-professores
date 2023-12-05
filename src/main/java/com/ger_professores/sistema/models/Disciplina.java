package com.ger_professores.sistema.models;

import com.ger_professores.sistema.enums.Trimestre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "disciplina_id")
  private Long disciplinaId;

  @Column(name = "disciplina_nome", nullable = false)
  private String disciplinaNome;

  @Column(name = "disciplina_carga", nullable = false)
  private Integer disciplinaCarga;

  @Enumerated(EnumType.STRING)
  // @Column(nullable = false, unique = true)
  private Trimestre trimestre;

  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(
    name = "disciplina_usuario",
    joinColumns = @JoinColumn(name = "disciplinaId"),
    inverseJoinColumns = @JoinColumn(name = "usuarioId")
  )
  private Usuario usuario; // REMOVER LISTA DESTE ATRIBUTO
}
