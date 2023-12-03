package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.Tipo;
import com.ger_professores.sistema.models.Curso;
import com.ger_professores.sistema.models.Disciplina;
import java.util.List;
import lombok.Data;

@Data
public class UsuarioResponse {

  private Long usuarioId;

  private String usuarioNome;

  private String usuarioCpf;

  private String usuarioEmail;

  private Integer professorCarga;

  private Contratacao tipoContratacao;

  private Tipo tipoUsuario;

  private String curEscolhidos;

  private List<String> discEscolhidos;
}
