package com.ger_professores.sistema.repositories;

import com.ger_professores.sistema.enums.StatusAprovacao;
import com.ger_professores.sistema.models.AssociacaoProfessorDisciplina;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociacaoProfessorDisciplinaRepository
    extends JpaRepository<AssociacaoProfessorDisciplina, Long> {
  List<AssociacaoProfessorDisciplina> findByStatusAprovacao(
      StatusAprovacao statusAprovacao);
}
