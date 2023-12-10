package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.Tipo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class UsuarioResponse {

  private Long usuarioId;

  @NotBlank
  private String usuarioNome;

  @NotBlank
  @CPF
  private String usuarioCpf;

  @NotBlank
  @Email
  private String usuarioEmail;

  @NotBlank
  private Integer professorCarga;

  private Contratacao tipoContratacao;

  private Tipo tipoUsuario;

  private String curEscolhidos;

  private List<String> discEscolhidos;
}
