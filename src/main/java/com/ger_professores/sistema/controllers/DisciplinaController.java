package com.ger_professores.sistema.controllers;

import com.ger_professores.sistema.dtos.requests.DisciplinaRequest;
import com.ger_professores.sistema.dtos.responses.DisciplinaResponse;
import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.exceptions.CargaHorariaExcedidaException;
import com.ger_professores.sistema.models.exceptions.ResourceNotFoundException;
import com.ger_professores.sistema.services.DisciplinaService;
import com.ger_professores.sistema.services.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/disciplina")
public class DisciplinaController {

  @Autowired
  DisciplinaService disciplinaService;

  @Autowired
  UsuarioService usuarioService;

  @GetMapping
  public ResponseEntity<List<DisciplinaResponse>> findAll() {
    List<Disciplina> disciplinas = disciplinaService.findAll();
    List<DisciplinaResponse> disciplinaResponses = disciplinas
        .stream()
        .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
  }

  @GetMapping("/disciplinas-ativos")
  public ResponseEntity<List<DisciplinaResponse>> listarObjetosAtivos() {
    List<Disciplina> disciplinas = disciplinaService.buscarObjetosAtivos();
    List<DisciplinaResponse> disciplinaResponses = disciplinas
        .stream()
        .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DisciplinaResponse> findById(@PathVariable Long id) {
    Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
    DisciplinaResponse disciplinaResponse = new ModelMapper()
        .map(disciplinaOptional.orElseThrow(), DisciplinaResponse.class);
    return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
  }

  @PostMapping
  public ResponseEntity<DisciplinaResponse> save(
      @RequestBody @Valid DisciplinaRequest disciplinaRequest) {
    Disciplina disciplina = new ModelMapper()
        .map(disciplinaRequest, Disciplina.class);
    disciplina = disciplinaService.save(disciplina);
    DisciplinaResponse disciplinaResponse = new ModelMapper()
        .map(disciplina, DisciplinaResponse.class);
    return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
    Disciplina disciplina = new ModelMapper()
        .map(disciplinaOptional.orElseThrow(), Disciplina.class);
    disciplinaService.delete(disciplina);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body("Disciplina deletada com sucesso.");
  }

  @PutMapping("/{id}")
  public ResponseEntity<DisciplinaResponse> update(
      @PathVariable @Valid Long id,
      @RequestBody DisciplinaRequest disciplinaRequest) {
    Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
    Disciplina disciplina = new ModelMapper()
        .map(disciplinaRequest, Disciplina.class);
    disciplina.setDisciplinaId(
        disciplinaOptional.orElseThrow().getDisciplinaId());
    disciplinaService.save(disciplina);
    DisciplinaResponse disciplinaResponse = new ModelMapper()
        .map(disciplina, DisciplinaResponse.class);
    return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
  }

  @PutMapping("/{disciplinaId}/professor/{professorId}")
  public ResponseEntity<?> associarProfessor(
      @PathVariable Long disciplinaId,
      @PathVariable Long professorId) {
    try {
      // Lógica para verificar carga horária disponível do professor
      disciplinaService.associarProfessor(disciplinaId, professorId);
      return ResponseEntity.ok("Professor associado com sucesso à disciplina.");
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    } catch (CargaHorariaExcedidaException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Erro interno do servidor");
    }
  }
}
