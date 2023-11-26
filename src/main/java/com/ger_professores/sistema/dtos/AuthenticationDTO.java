package com.ger_professores.sistema.dtos;

import lombok.Data;

@Data
public class AuthenticationDTO {

  private String email;

  private String password;
}
