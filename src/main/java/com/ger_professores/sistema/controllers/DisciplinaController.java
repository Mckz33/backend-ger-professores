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
import com.ger_professores.sistema.dtos.requests.DisciplinaRequest;
import com.ger_professores.sistema.dtos.requests.ProfessorRequest;
import com.ger_professores.sistema.dtos.responses.DisciplinaResponse;
import com.ger_professores.sistema.models.Curso;
import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.Professor;
import com.ger_professores.sistema.services.CursoService;
import com.ger_professores.sistema.services.DisciplinaService;
import com.ger_professores.sistema.services.ProfessorService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/disciplina"))
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final ProfessorService professorService;
    private final CursoService cursoService;

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
        DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplinaOptional, DisciplinaResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
    }

    @GetMapping("/porProfessor/{idProfessor}")
    public ResponseEntity<List<DisciplinaResponse>> findByProfessor(@PathVariable Long idProfessor) {
        List<Disciplina> disciplinas = disciplinaService.findByProfessor(idProfessor);
        List<DisciplinaResponse> disciplinaResponses = disciplinas.stream()
                .map(a -> new ModelMapper().map(a, DisciplinaResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponses);
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponse> save(@RequestBody DisciplinaRequest disciplinaRequest) {
        Disciplina disciplina = new ModelMapper().map(disciplinaRequest, Disciplina.class);
        disciplina = disciplinaService.save(disciplina);
        DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplina, DisciplinaResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Disciplina> disciplinarOptional = disciplinaService.findById(id);
        Disciplina disciplina = new ModelMapper().map(disciplinarOptional, Disciplina.class);
        disciplinaService.delete(disciplina);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso.");
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<DisciplinaResponse> update(@PathVariable Long id,
    //         @RequestBody DisciplinaRequest disciplinaRequest) {
    //     Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
        
    //     Disciplina disciplina = new ModelMapper().map(disciplinaRequest, Disciplina.class);
    //     disciplina.setDisciplina_id(disciplinaOptional.get().getDisciplina_id());
    //     disciplinaService.save(disciplina);
    //     DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplina, DisciplinaResponse.class);
    //     return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
    // }


    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id,
            @RequestBody DisciplinaRequest disciplinaRequest) {
        // 1. Busca a disciplina existente pelo ID
        Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);

        if (disciplinaOptional.isEmpty()) {
            // Se a disciplina não existir, retornar um ResponseEntity com status 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 2. Verifica se o professor fornecido existe no banco de dados
        ProfessorRequest professorRequest = disciplinaRequest.getProfessor();

        if (professorRequest != null) {
            Optional<Professor> professorOptional = professorService.findById(professorRequest.getId());
            if (professorOptional.isEmpty()) {
                // Se o professor não existir, retornar um ResponseEntity com status 400 Bad Request
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado");
            }
        }

        // 3. Verifica se o curso fornecido existe no banco de dados
        CursoRequest cursoRequest = disciplinaRequest.getCurso();
        if (cursoRequest != null) {
            Optional<Curso> cursoOptional = cursoService.findById(cursoRequest.getCurso_id());
            if (cursoOptional.isEmpty()) {
                // Se o curso não existir, retornar um ResponseEntity com status 400 Bad Request
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado");
            }
        }

        // Continuação do código para mapear, configurar, salvar e responder conforme a sua lógica

        // 4. Mapeia os dados da requisição (DisciplinaRequest) para um objeto Disciplina
        Disciplina disciplina = new ModelMapper().map(disciplinaRequest, Disciplina.class);

        // 5. Configura o ID da disciplina com o ID existente da disciplina a ser atualizada
        disciplina.setDisciplina_id(disciplinaOptional.get().getDisciplina_id());

        // 6. Atualiza os relacionamentos com professor e curso, se fornecidos
        disciplinaService.save(disciplina);

        // 7. Salva a disciplina atualizada no banco de dados
        disciplinaService.save(disciplina);

        // 8. Mapeia a disciplina atualizada para o formato de resposta (DisciplinaResponse)
        DisciplinaResponse disciplinaResponse = new ModelMapper().map(disciplina, DisciplinaResponse.class);

        // 9. Retorna uma resposta HTTP 200 OK com os dados da disciplina atualizada
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaResponse);
    }



}
