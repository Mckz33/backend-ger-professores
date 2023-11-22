package com.ger_professores.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ger_professores.sistema.models.Coordenador;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.CoordenadorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CoordenadorService {
    private final CoordenadorRepository coordenadorRepository;

    public List<Coordenador> findAll() {
        return coordenadorRepository.findAll();
    }

    public Optional<Coordenador> findById(Long id) {
        Optional<Coordenador> optionalCurso = coordenadorRepository.findById(id);
        if (optionalCurso.isEmpty()) {
            throw new ResourceNotFoundException("Usuario não encontrado");
        }
        return optionalCurso;
    }

    @Transactional
    public Coordenador save(Coordenador coordenador) {
        return coordenadorRepository.save(coordenador);
    }

    @Transactional
    public void delete(Coordenador coordenador) {
        coordenadorRepository.delete(coordenador);
    }
}
