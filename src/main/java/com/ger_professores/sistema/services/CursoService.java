package com.ger_professores.sistema.services;

import com.ger_professores.sistema.models.Curso;
import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.AssociacaoProfessorDisciplinaRepository;
import com.ger_professores.sistema.repositories.CursoRepository;
import com.ger_professores.sistema.repositories.DisciplinaRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CursoService {

  @Autowired
  CursoRepository cursoRepository;

  @Autowired
  AssociacaoProfessorDisciplinaRepository associacaoRepository;

  @Autowired
  DisciplinaRepository disciplinaRepository;

  public List<Curso> findAll() {
    return cursoRepository.findAll();
  }

  public Optional<Curso> findById(Long id) {
    Optional<Curso> optionalCurso = cursoRepository.findById(id);
    if (optionalCurso.isEmpty()) {
      throw new ResourceNotFoundException("Usuario não encontrado");
    }
    return optionalCurso;
  }

  @Transactional
  public Curso save(Curso curso) {
    return cursoRepository.save(curso);
  }

  @Transactional
  public void delete(Curso curso) {
    cursoRepository.delete(curso);
  }

  @Transactional
  public void associarDisciplina(Long cursoId, Long disciplinaId) {
    Curso curso = findById(cursoId)
      .orElseThrow(() -> new ResourceNotFoundException("Curso Não Encontrado.")
      );
    Disciplina disciplina = disciplinaRepository
      .findById(disciplinaId)
      .orElseThrow(() ->
        new ResourceNotFoundException("Disciplina Não Encontrado.")
      );

    List<Disciplina> disciplinas = curso.getDisciplinas();
    if (disciplinas == null) {
      disciplinas = new ArrayList<>();
    }
    disciplinas.add(disciplina);
    curso.setDisciplinas(disciplinas);
    save(curso);
  }
}
