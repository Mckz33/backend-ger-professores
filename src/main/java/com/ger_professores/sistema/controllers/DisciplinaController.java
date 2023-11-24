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

import com.ger_professores.sistema.dtos.requests.DisciplinaRequest;
import com.ger_professores.sistema.dtos.responses.DisciplinaResponse;
import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.services.DisciplinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/disciplina")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaResponse>> findAll() {
        List<Disciplina> disciplinas = disciplinaService.findAll();
        List<DisciplinaResponse> disciplinaResponses = disciplinas.stream()
                .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> findById(@PathVariable Long id) {
        Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
        DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplinaOptional.orElseThrow(), DisciplinaResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
    }

    // @GetMapping("/porCursoId/{cursoId}")
    // public ResponseEntity<List<DisciplinaResponse>> findByCursoId(@PathVariable Long cursoId) {
    //     List<Disciplina> disciplinas = disciplinaService.findByCursoId(cursoId);
    //     List<DisciplinaResponse> disciplinaResponses = disciplinas.stream()
    //             .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
    // }

    // @GetMapping("/porProfessorId/{professorId}")
    // public ResponseEntity<List<DisciplinaResponse>> findByProfessorId(@PathVariable Long professorId) {
    //     List<Disciplina> disciplinas = disciplinaService.findByProfessorId(professorId);
    //     List<DisciplinaResponse> disciplinaResponses = disciplinas.stream()
    //             .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
    // }

    @PostMapping
    public ResponseEntity<DisciplinaResponse> save(@RequestBody @Valid DisciplinaRequest disciplinaRequest) {
        Disciplina disciplina = new ModelMapper().map(disciplinaRequest, Disciplina.class);
        disciplina = disciplinaService.save(disciplina);
        DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplina, DisciplinaResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
        Disciplina disciplina = new ModelMapper().map(disciplinaOptional.orElseThrow(), Disciplina.class);
        disciplinaService.delete(disciplina);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponse> update(@PathVariable @Valid Long id,
            @RequestBody  DisciplinaRequest disciplinaRequest) {
        Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
        Disciplina disciplina = new ModelMapper().map(disciplinaRequest, Disciplina.class);
        disciplina.setDisciplina_id(disciplinaOptional.orElseThrow().getDisciplina_id());
        disciplinaService.save(disciplina);
        DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplina, DisciplinaResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
    }
}