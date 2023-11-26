package com.ger_professores.sistema.services.auth;

import com.ger_professores.sistema.dtos.SignupDTO;
import com.ger_professores.sistema.dtos.UserDTO;

public interface AuthService {
  UserDTO createUser(SignupDTO signupDTO);
}
