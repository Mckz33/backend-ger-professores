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

    private final ProfessorRepository usuarioRepository;

    public List<Professor> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        Optional<Professor> optionalProfessor = usuarioRepository.findById(id);
        if (optionalProfessor.isEmpty()) {
            throw new ResourceNotFoundException("Usuario não encontrado");
        }
        return optionalProfessor;
    }

    @Transactional
    public Professor save(Professor professor) {
        return usuarioRepository.save(professor);
    }

    @Transactional
    public void delete(Professor professor) {
        usuarioRepository.delete(professor);
    }
}
