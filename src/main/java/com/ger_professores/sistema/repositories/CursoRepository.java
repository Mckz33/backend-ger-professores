package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
