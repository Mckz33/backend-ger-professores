package com.ger_professores.sistema.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping
    public ResponseEntity<ProfessorResponse> save(@RequestBody ProfessorRequest professorRequest) {
        Professor professor = new ModelMapper().map(professorRequest, Professor.class);
        professor = professorService.save(professor);
        ProfessorResponse professorResponse = new ModelMapper().map(professor, ProfessorResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorResponse);
    }
}
