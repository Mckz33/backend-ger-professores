package com.ger_professores.sistema.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {

  private Long id;

  @NotBlank
  private String email;
}
