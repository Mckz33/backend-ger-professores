package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.enums.StatusAtivo;
import com.ger_professores.sistema.models.Curso;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByStatusAtivo(StatusAtivo statusAtivo);
}
