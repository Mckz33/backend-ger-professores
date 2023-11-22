package com.ger_professores.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ger_professores.sistema.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{ 
    List<Disciplina> findByProfessorId(Long idProfessor);
}
