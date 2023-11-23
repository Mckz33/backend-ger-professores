package com.ger_professores.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ger_professores.sistema.models.Curso;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.CursoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CursoService {
    private final CursoRepository cursoRepository;

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

    // public List<Curso> findByTrimestreId(Long trimestreId) {
    //     return cursoRepository.findByTrimestreId(trimestreId);
    // }

    // public List<Curso> findByDisciplinaId(Long disciplinaId) {
    //     return cursoRepository.findByDisciplinasDisciplinaId(disciplinaId);
    // }

    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }
}
