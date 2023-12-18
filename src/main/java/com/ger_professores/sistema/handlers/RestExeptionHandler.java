package com.ger_professores.sistema.handlers;

import com.ger_professores.sistema.models.error.ErrorMessage;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExeptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(
      ResourceNotFoundException ex) {
    ErrorMessage errorMessage = new ErrorMessage(
        "Not Found",
        HttpStatus.NOT_FOUND.value(),
        ex.getMessage());
    return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
  }
}
