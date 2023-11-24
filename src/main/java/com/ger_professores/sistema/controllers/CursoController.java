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

import com.ger_professores.sistema.dtos.requests.CursoRequest;
import com.ger_professores.sistema.dtos.responses.CursoResponse;
import com.ger_professores.sistema.models.Curso;
import com.ger_professores.sistema.services.CursoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoResponse>> findAll() {
        List<Curso> cursos = cursoService.findAll();
        List<CursoResponse> cursoResponses = cursos.stream()
                .map(a -> new ModelMapper().map(a, CursoResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findById(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoService.findById(id);
        CursoResponse cursoResponse = new ModelMapper().map(cursoOptional.orElseThrow(), CursoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponse);
    }

    // @GetMapping("/porTrimestreId/{trimestreId}")
    // public ResponseEntity<List<CursoResponse>> findByTrimestreId(@PathVariable Long trimestreId) {
    //     List<Curso> cursos = cursoService.findByTrimestreId(trimestreId);
    //     List<CursoResponse> cursoResponses = cursos.stream()
    //             .map(a -> new ModelMapper().map(a, CursoResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(cursoResponses);
    // }

    // @GetMapping("/porDisciplinaId/{disciplinaId}")
    // public ResponseEntity<List<CursoResponse>> findByDisciplinaId(@PathVariable Long disciplinaId) {
    //     List<Curso> cursos = cursoService.findByDisciplinaId(disciplinaId);
    //     List<CursoResponse> cursoResponses = cursos.stream()
    //             .map(a -> new ModelMapper().map(a, CursoResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(cursoResponses);
    // }

    @PostMapping
    public ResponseEntity<CursoResponse> save(@RequestBody @Valid CursoRequest cursoRequest) {
        Curso curso = new ModelMapper().map(cursoRequest, Curso.class);
        curso = cursoService.save(curso);
        CursoResponse cursoResponse = new ModelMapper().map(curso, CursoResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoService.findById(id);
        Curso curso = new ModelMapper().map(cursoOptional.orElseThrow(), Curso.class);
        cursoService.delete(curso);
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponse> update(@PathVariable @Valid Long id, @RequestBody CursoRequest cursoRequest) {
        Optional<Curso> cursoOptional = cursoService.findById(id);
        Curso curso = new ModelMapper().map(cursoRequest, Curso.class);
        curso.setCurso_id(cursoOptional.orElseThrow().getCurso_id());
        cursoService.save(curso);
        CursoResponse cursoResponse = new ModelMapper().map(curso, CursoResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(cursoResponse);
    }
}