package com.ger_professores.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ger_professores.sistema.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
