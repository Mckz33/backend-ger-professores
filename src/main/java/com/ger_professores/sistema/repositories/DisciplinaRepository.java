package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.models.Disciplina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ger_professores.sistema.enums.StatusAtivo;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    List<Disciplina> findByStatusAtivo(StatusAtivo statusAtivo);
}
