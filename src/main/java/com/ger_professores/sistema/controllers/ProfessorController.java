package com.ger_professores.sistema.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ger_professores.sistema.dtos.requests.ProfessorRequest;
import com.ger_professores.sistema.dtos.responses.ProfessorResponse;
import com.ger_professores.sistema.models.Professor;
import com.ger_professores.sistema.services.ProfessorService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/professor"))
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> findAll() {
        List<Professor> professores = professorService.findAll();
        List<ProfessorResponse> usuarioResponses = professores.stream()
                .map(a -> new ModelMapper().map(a, ProfessorResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponse> findById(@PathVariable Long id) {
        Optional<Professor> professorOptional = professorService.findById(id);
        ProfessorResponse professorResponse = new ModelMapper().map(professorOptional, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(professorResponse);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> save(@RequestBody ProfessorRequest professorRequest) {
        Professor professor = new ModelMapper().map(professorRequest, Professor.class);
        professor = professorService.save(professor);
        ProfessorResponse professorResponse = new ModelMapper().map(professor, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Professor> professorOptional = professorService.findById(id);
        Professor professor = new ModelMapper().map(professorOptional, Professor.class);
        professorService.delete(professor);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> update(@PathVariable Long id,
            @RequestBody ProfessorRequest professorRequest) {
        Optional<Professor> profeOptional = professorService.findById(id);
        Professor professor = new ModelMapper().map(professorRequest, Professor.class);
        professor.setId(profeOptional.get().getId());
        professorService.save(professor);
        ProfessorResponse professorResponse = new ModelMapper().map(professor, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(professorResponse);
    }
}
