package com.ger_professores.sistema.services;

import com.ger_professores.sistema.models.Usuario;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;

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

  @Transactional
  public Usuario save(Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  @Transactional
  public void delete(Usuario usuario) {
    usuarioRepository.delete(usuario);
  }
}
