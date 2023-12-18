package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
