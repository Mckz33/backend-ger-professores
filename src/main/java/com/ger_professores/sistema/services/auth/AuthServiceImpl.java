package com.ger_professores.sistema.services.auth;

import com.ger_professores.sistema.dtos.SignupDTO;
import com.ger_professores.sistema.dtos.UserDTO;
import com.ger_professores.sistema.models.User;
import com.ger_professores.sistema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDTO createUser(SignupDTO signupDTO) {
    User user = new User();
    user.setEmail(signupDTO.getEmail());
    user.setPassword(
      new BCryptPasswordEncoder().encode(signupDTO.getPassword())
    );
    User createdUser = userRepository.save(user);
    UserDTO userDTO = new UserDTO();
    userDTO.setId(createdUser.getId());
    userDTO.setEmail(createdUser.getEmail());
    return userDTO;
  }
}
