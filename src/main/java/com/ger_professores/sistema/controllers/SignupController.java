package com.ger_professores.sistema.controllers;

import com.ger_professores.sistema.dtos.SignupDTO;
import com.ger_professores.sistema.dtos.UserDTO;
import com.ger_professores.sistema.services.auth.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

  @Autowired
  private AuthService authService;

  @PostMapping("/sign-up")
  public ResponseEntity<?> signupUser(@RequestBody @Valid SignupDTO signupDTO) {
    UserDTO createdUser = authService.createUser(signupDTO);
    if (createdUser == null) {
      return new ResponseEntity<>(
          "User not created, come again later!",
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
  }
}
