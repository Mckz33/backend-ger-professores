package com.ger_professores.sistema.models;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.StatusAtivo;
import com.ger_professores.sistema.enums.Tipo;
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
import jakarta.persistence.OneToOne;
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

  @Column(name = "usuario_cpf", unique = true)
  private String usuarioCpf;

  @Column(name = "usuario_email", nullable = false, unique = true)
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
  private String curEscolhidos;

  @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "usuario_login", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "id"))
  private User user;

  @Column(name = "disciplinas_escolhidas")
  private List<String> discEscolhidos;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private StatusAtivo statusAtivo;
}
