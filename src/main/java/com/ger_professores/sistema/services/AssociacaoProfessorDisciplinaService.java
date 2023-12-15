package com.ger_professores.sistema.services;

import com.ger_professores.sistema.enums.StatusAprovacao;
import com.ger_professores.sistema.models.AssociacaoProfessorDisciplina;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.AssociacaoProfessorDisciplinaRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociacaoProfessorDisciplinaService {

  @Autowired
  AssociacaoProfessorDisciplinaRepository associacaoRepository;

  public List<AssociacaoProfessorDisciplina> obterAssociaçõesPendentes() {
    return associacaoRepository.findByStatusAprovacao(StatusAprovacao.PENDENTE);
  }

  @Transactional
  public AssociacaoProfessorDisciplina save(
    AssociacaoProfessorDisciplina associacao
  ) {
    return associacaoRepository.save(associacao);
  }

  public Optional<AssociacaoProfessorDisciplina> findById(Long associacaoId) {
    Optional<AssociacaoProfessorDisciplina> optionalAssociacao = associacaoRepository.findById(
      associacaoId
    );
    if (optionalAssociacao.isEmpty()) {
      throw new ResourceNotFoundException("Associação não encontrado");
    }
    return optionalAssociacao;
  }

  public void aprovarAssociação(Long associaçãoId) {
    AssociacaoProfessorDisciplina associação = associacaoRepository
      .findById(associaçãoId)
      .orElseThrow(() ->
        new ResourceNotFoundException("Associação não encontrada")
      );

    // Verifique se a associação está pendente antes de aprovar.
    if (associação.getStatusAprovacao() == StatusAprovacao.PENDENTE) {
      associação.setStatusAprovacao(StatusAprovacao.APROVADO);
      associação.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
      associacaoRepository.save(associação);
    } else {
      throw new IllegalStateException(
        "Esta associação não está pendente de aprovação."
      );
    }
  }

  public void reprovarAssociação(Long associaçãoId) {
    AssociacaoProfessorDisciplina associação = associacaoRepository
      .findById(associaçãoId)
      .orElseThrow(() ->
        new ResourceNotFoundException("Associação não encontrada")
      );
    // Verifique se a associação está pendente antes de aprovar.
    if (associação.getStatusAprovacao() == StatusAprovacao.PENDENTE) {
      associação.setStatusAprovacao(StatusAprovacao.RECUSADO);
      associacaoRepository.save(associação);
    } else {
      throw new IllegalStateException(
        "Esta associação não está pendente de aprovação."
      );
    }
  }
}
