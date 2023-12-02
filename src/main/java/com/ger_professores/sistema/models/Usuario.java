package com.ger_professores.sistema.models;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.Tipo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "usuario_id")
  private Long usuarioId;

  @Column(name = "usuario_nome")
  private String usuarioNome;

  @Column(name = "usuario_cpf")
  private String usuarioCpf;

  @Column(name = "usuario_email")
  private String usuarioEmail;

  @Column(name = "professor_carga")
  private Integer professorCarga;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_contratacao")
  private Contratacao tipoContratacao;

  @Enumerated(EnumType.STRING)
  @Column(name = "tipo_usuario")
  private Tipo tipoUsuario;

  @Column(name = "cursos_escolhidos")
  private List<String> curEscolhidos;

  @Column(name = "disciplinas_escolhidas")
  private List<String> discEscolhidas;
}
