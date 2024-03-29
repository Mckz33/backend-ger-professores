package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.StatusAtivo;
import com.ger_professores.sistema.enums.Tipo;
import com.ger_professores.sistema.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class UsuarioRequest {

  private Long usuarioId;

  private String usuarioNome;

  @CPF
  private String usuarioCpf;

  @Email
  @NotBlank
  private String usuarioEmail;

  private Integer professorCarga;

  private Contratacao tipoContratacao;

  private Tipo tipoUsuario;

  private String curEscolhidos;

  private List<String> discEscolhidos;

  private User user;

  @NotNull
  private StatusAtivo statusAtivo;
}
