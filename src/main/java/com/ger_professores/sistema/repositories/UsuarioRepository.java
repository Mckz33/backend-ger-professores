package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findFirstByUsuarioEmail(String email);
}
