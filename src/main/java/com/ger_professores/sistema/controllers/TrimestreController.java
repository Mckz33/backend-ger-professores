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

import com.ger_professores.sistema.dtos.requests.TrimestreRequest;
import com.ger_professores.sistema.dtos.responses.TrimestreResponse;
import com.ger_professores.sistema.models.Trimestre;
import com.ger_professores.sistema.services.TrimestreService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/trimestre")
@RequiredArgsConstructor
public class TrimestreController {

    private final TrimestreService trimestreService;

    @GetMapping
    public ResponseEntity<List<TrimestreResponse>> findAll() {
        List<Trimestre> trimestres = trimestreService.findAll();
        List<TrimestreResponse> trimestreResponses = trimestres.stream()
                .map(a -> new ModelMapper().map(a, TrimestreResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(trimestreResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrimestreResponse> findById(@PathVariable Long id) {
        Optional<Trimestre> trimestreOptional = trimestreService.findById(id);
        TrimestreResponse trimestreResponse = new ModelMapper().map(trimestreOptional.get(), TrimestreResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(trimestreResponse);
    }

    @PostMapping
    public ResponseEntity<TrimestreResponse> save(@RequestBody @Valid TrimestreRequest trimestreRequest) {
        Trimestre trimestre = new ModelMapper().map(trimestreRequest, Trimestre.class);
        trimestre = trimestreService.save(trimestre);
        TrimestreResponse trimestreResponse = new ModelMapper().map(trimestre, TrimestreResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(trimestreResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Trimestre> trimestreOptional = trimestreService.findById(id);
        Trimestre trimestre = trimestreOptional.get();
        trimestreService.delete(trimestre);
        return ResponseEntity.status(HttpStatus.OK).body("Trimestre deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrimestreResponse> update(@PathVariable @Valid Long id,
            @RequestBody TrimestreRequest trimestreRequest) {
        Optional<Trimestre> trimestreOptional = trimestreService.findById(id);
        Trimestre trimestre = new ModelMapper().map(trimestreRequest, Trimestre.class);
        trimestre.setTrimestre_id(trimestreOptional.get().getTrimestre_id());
        trimestreService.save(trimestre);
        TrimestreResponse trimestreResponse = new ModelMapper().map(trimestre, TrimestreResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(trimestreResponse);
    }
}
