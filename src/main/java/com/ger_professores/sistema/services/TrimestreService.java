package com.ger_professores.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ger_professores.sistema.models.Trimestre;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.repositories.TrimestreRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrimestreService {

    private final TrimestreRepository trimestreRepository;

    public List<Trimestre> findAll() {
        return trimestreRepository.findAll();
    }

    public Optional<Trimestre> findById(Long id) {
        Optional<Trimestre> optionalTrimestre = trimestreRepository.findById(id);
        if (optionalTrimestre.isEmpty()) {
            throw new ResourceNotFoundException("Trimestre não encontrado");
        }
        return optionalTrimestre;
    }

    @Transactional
    public Trimestre save(Trimestre trimestre) {
        return trimestreRepository.save(trimestre);
    }

    @Transactional
    public void delete(Trimestre trimestre) {
        trimestreRepository.delete(trimestre);
    }
}
