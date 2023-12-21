package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.models.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ger_professores.sistema.enums.StatusAtivo;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findFirstByUsuarioEmail(String email);

    List<Usuario> findByStatusAtivo(StatusAtivo statusAtivo);
}
