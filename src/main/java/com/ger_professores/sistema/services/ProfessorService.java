package com.ger_professores.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ger_professores.sistema.models.Professor;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.ProfessorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isEmpty()) {
            throw new ResourceNotFoundException("Usuario não encontrado");
        }
        return optionalProfessor;
    }

    // public List<Professor> findProfessorByDisciplinaId(Long disciplinaId) {
    //     return professorRepository.findByDisciplinasId(disciplinaId);
    // }

    // public List<Professor> findProfessorByCursoId(Long cursoId) {
    //     return professorRepository.findByCursosCursoId(cursoId);
    // }

    // public List<Professor> findProfessorByTrimestreId(Long trimestreId) {
    //     return professorRepository.findByCursosTrimestreTrimestreId(trimestreId);
    // }

    @Transactional
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Transactional
    public void delete(Professor professor) {
        professorRepository.delete(professor);
    }
}
