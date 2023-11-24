package com.ger_professores.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ger_professores.sistema.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{ 
    // // Corrigindo a consulta personalizada
    // @Query("SELECT d FROM Disciplina d WHERE d.curso.curso_id = :cursoId")
    // List<Disciplina> findByCursoId(@Param("cursoId") Long cursoId);

    // // Corrigindo a consulta personalizada
    // @Query("SELECT d FROM Disciplina d JOIN d.professores p WHERE p.id = :professorId")
    // List<Disciplina> findByProfessoresId(@Param("professorId") Long professorId);
}
