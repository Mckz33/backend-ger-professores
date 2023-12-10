package com.ger_professores.sistema.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CargaHorariaExcedidaException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public CargaHorariaExcedidaException(String message) {
    super(message);
  }
}
