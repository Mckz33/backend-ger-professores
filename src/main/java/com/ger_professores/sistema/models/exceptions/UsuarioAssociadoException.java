package com.ger_professores.sistema.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UsuarioAssociadoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UsuarioAssociadoException(String message) {
    super(message);
  }
}
