package com.ger_professores.sistema.services;

import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.DisciplinaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DisciplinaService {

  private final DisciplinaRepository disciplinaRepository;

  public List<Disciplina> findAll() {
    return disciplinaRepository.findAll();
  }

  public Optional<Disciplina> findById(Long id) {
    Optional<Disciplina> optionalDisciplina = disciplinaRepository.findById(id);
    if (optionalDisciplina.isEmpty()) {
      throw new ResourceNotFoundException("Disciplina não encontrado");
    }
    return optionalDisciplina;
  }

  @Transactional
  public Disciplina save(Disciplina disciplina) {
    return disciplinaRepository.save(disciplina);
  }

  @Transactional
  public void delete(Disciplina disciplina) {
    disciplinaRepository.delete(disciplina);
  }
}
