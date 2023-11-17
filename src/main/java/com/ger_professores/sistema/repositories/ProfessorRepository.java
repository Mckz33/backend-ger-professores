package com.ger_professores.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ger_professores.sistema.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
