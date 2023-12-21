package com.ger_professores.sistema.services;

import com.ger_professores.sistema.enums.StatusAtivo;
import com.ger_professores.sistema.models.User;
import com.ger_professores.sistema.models.Usuario;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.UserRepository;
import com.ger_professores.sistema.repositories.UsuarioRepository;

import ch.qos.logback.core.status.Status;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  UserRepository userRepository;

  public List<Usuario> findAll() {
    return usuarioRepository.findAll();
  }

  public Optional<Usuario> findById(Long id) {
    Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
    if (optionalUsuario.isEmpty()) {
      throw new ResourceNotFoundException("Usuario não encontrado");
    }
    return optionalUsuario;
  }

  public Optional<Usuario> findFirstByEmail(String email) {
    return Optional.ofNullable(usuarioRepository.findFirstByUsuarioEmail(email));
  }

  public List<Usuario> buscarObjetosAtivos() {
    return usuarioRepository.findByStatusAtivo(StatusAtivo.ATIVADO);
  }

  @Transactional
  public Usuario save(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  @Transactional
  public void delete(Usuario usuario) {
    usuarioRepository.delete(usuario);
  }

  @Transactional
  public void associarUser(Long usuarioId, Long id) {
    Usuario usuario = usuarioRepository.findById(usuarioId)
        .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User não encontrado"));
    usuario.setUser(user);
    usuarioRepository.save(usuario);
  }
}
