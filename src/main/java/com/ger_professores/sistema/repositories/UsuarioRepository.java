package com.ger_professores.sistema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ger_professores.sistema.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // // Corrigindo a consulta personalizada
    // @Query("SELECT p FROM Professor p JOIN p.disciplinas d WHERE d.disciplina_id = :disciplinaId")
    // List<Professor> findByDisciplinasId(@Param("disciplinaId") Long disciplinaId);

    // // Corrigindo a consulta personalizada
    // @Query("SELECT  p FROM Professor p LEFT JOIN p.cursos c WHERE c.curso_id = :cursoId")
    // List<Professor> findByCursosCursoId(@Param("cursoId") Long cursoId);

    // @Query("SELECT p FROM Professor p JOIN p.cursos c JOIN c.trimestre t WHERE t.trimestre_id = :trimestreId")
    // List<Professor> findByCursosTrimestreTrimestreId(@Param("trimestreId") Long trimestreId);
}
