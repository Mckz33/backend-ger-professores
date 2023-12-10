package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
  // Método personalizado com @Query para buscar Disciplina por UsuarioId
  @Query(
    "SELECT d.usuario FROM Disciplina d WHERE d.disciplinaId = :disciplinaId"
  )
  Usuario findUsuarioByDisciplinaId(@Param("disciplinaId") Long disciplinaId);
}
