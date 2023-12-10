package com.ger_professores.sistema.services;

import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.Usuario;
import com.ger_professores.sistema.models.exceptions.CargaHorariaExcedidaException;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.DisciplinaRepository;
import com.ger_professores.sistema.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DisciplinaService {

  @Autowired
  DisciplinaRepository disciplinaRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

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

  @Transactional
  public void associarProfessor(Long disciplinaId, Long professorId) {
    Disciplina disciplina = findById(disciplinaId)
      .orElseThrow(() ->
        new ResourceNotFoundException("Disciplina não encontrada")
      );
    Usuario professor = usuarioRepository
      .findById(professorId)
      .orElseThrow(() ->
        new ResourceNotFoundException("Professor não encontrado")
      );

    // Verificar carga horária disponível do professor
    if (professor.getProfessorCarga() >= disciplina.getDisciplinaCarga()) {
      // Atualizar a carga horária disponível do professor
      professor.setProfessorCarga(
        professor.getProfessorCarga() - disciplina.getDisciplinaCarga()
      );

      // Associar o professor à disciplina
      disciplina.setUsuario(professor);
      save(disciplina); // Salvar a disciplina atualizada

      // Atualizar o professor
      usuarioRepository.save(professor);
    } else {
      throw new CargaHorariaExcedidaException(
        "Carga horária do professor excedida"
      );
    }
  }
}
