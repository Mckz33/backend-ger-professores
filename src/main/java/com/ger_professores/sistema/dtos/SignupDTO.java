package com.ger_professores.sistema.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupDTO {

  @NotBlank
  private String email;

  @NotBlank
  private String password;
}
