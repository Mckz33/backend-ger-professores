package com.ger_professores.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ger_professores.sistema.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    // // Corrigindo a consulta personalizada
    // @Query("SELECT c FROM Curso c WHERE c.trimestre.trimestre_id = :trimestreId")
    // List<Curso> findByTrimestreId(@Param("trimestreId") Long trimestreId);

    // // Corrigindo a consulta personalizada
    // @Query("SELECT c FROM Curso c JOIN c.disciplinas d WHERE d.disciplina_id = :disciplinaId")
    // List<Curso> findByDisciplinasDisciplinaId(@Param("disciplinaId") Long disciplinaId);
}
