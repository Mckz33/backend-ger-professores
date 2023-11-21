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

import com.ger_professores.sistema.dtos.requests.CoordenadorRequest;
import com.ger_professores.sistema.dtos.responses.CoordenadorResponse;
import com.ger_professores.sistema.models.Coordenador;
import com.ger_professores.sistema.services.CoordenadorService;

import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(("/api/coordenador"))
@RequiredArgsConstructor
public class CoordenadorController {

    private final CoordenadorService coordenadorService;

    @GetMapping
    public ResponseEntity<List<CoordenadorResponse>> findAll() {
        List<Coordenador> coordenadores = coordenadorService.findAll();
        List<CoordenadorResponse> usuarioResponses = coordenadores.stream()
                .map(a -> new ModelMapper().map(a, CoordenadorResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordenadorResponse> findById(@PathVariable Long id) {
        Optional<Coordenador> coordenadorOptional = coordenadorService.findById(id);
        CoordenadorResponse coordenadorResponse = new ModelMapper().map(coordenadorOptional, CoordenadorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorResponse);
    }

    @PostMapping
    public ResponseEntity<CoordenadorResponse> save(@RequestBody CoordenadorRequest coordenadorRequest) {
        Coordenador coordenador = new ModelMapper().map(coordenadorRequest, Coordenador.class);
        coordenador = coordenadorService.save(coordenador);
        CoordenadorResponse coordenadorResponse = new ModelMapper().map(coordenador, CoordenadorResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(coordenadorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Coordenador> coordenadorOptional = coordenadorService.findById(id);
        Coordenador coordenador = new ModelMapper().map(coordenadorOptional, Coordenador.class);
        coordenadorService.delete(coordenador);
        return ResponseEntity.status(HttpStatus.OK).body("Coordenador deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoordenadorResponse> update(@PathVariable Long id,
            @RequestBody CoordenadorRequest coordenadorRequest) {
        Optional<Coordenador> profeOptional = coordenadorService.findById(id);
        Coordenador coordenador = new ModelMapper().map(coordenadorRequest, Coordenador.class);
        coordenador.setId(profeOptional.get().getId());
        coordenadorService.save(coordenador);
        CoordenadorResponse coordenadorResponse = new ModelMapper().map(coordenador, CoordenadorResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(coordenadorResponse);
    }
}
