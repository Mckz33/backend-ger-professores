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

import com.ger_professores.sistema.dtos.requests.UsuarioRequest;
import com.ger_professores.sistema.dtos.responses.UsuarioResponse;
import com.ger_professores.sistema.models.Usuario;
import com.ger_professores.sistema.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        List<Usuario> usuarioes = usuarioService.findAll();
        List<UsuarioResponse> usuarioResponses = usuarioes.stream()
                .map(a -> new ModelMapper().map(a, UsuarioResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        UsuarioResponse usuarioResponse = new ModelMapper().map(usuarioOptional.orElseThrow(), UsuarioResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }

    // @GetMapping("/porDisciplinaId/{disciplinaId}")
    // public ResponseEntity<List<usuarioResponse>> findusuariosByDisciplinaId(@PathVariable Long disciplinaId) {
    //     List<usuario> usuarioes = usuarioService.findusuarioByDisciplinaId(disciplinaId);
    //     List<usuarioResponse> usuarioResponses = usuarioes.stream()
    //             .map(a -> new ModelMapper().map(a, usuarioResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    // }

    // @GetMapping("/porCursoId/{cursoId}")
    // public ResponseEntity<List<usuarioResponse>> findusuariosByCursoId(@PathVariable Long cursoId) {
    //     List<usuario> usuarioes = usuarioService.findusuarioByCursoId(cursoId);
    //     List<usuarioResponse> usuarioResponses = usuarioes.stream()
    //             .map(a -> new ModelMapper().map(a, usuarioResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    // }

    // @GetMapping("/porTrimestreId/{trimestreId}")
    // public ResponseEntity<List<usuarioResponse>> findusuariosByTrimestreId(@PathVariable Long trimestreId) {
    //     List<usuario> usuarioes = usuarioService.findusuarioByTrimestreId(trimestreId);
    //     List<usuarioResponse> usuarioResponses = usuarioes.stream()
    //             .map(a -> new ModelMapper().map(a, usuarioResponse.class))
    //             .collect(Collectors.toList());
    //     return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
    // }

    @PostMapping
    public ResponseEntity<UsuarioResponse> save(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        Usuario usuario = new ModelMapper().map(usuarioRequest, Usuario.class);
        usuario = usuarioService.save(usuario);
        UsuarioResponse usuarioResponse = new ModelMapper().map(usuario, UsuarioResponse.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        Usuario usuario = new ModelMapper().map(usuarioOptional.orElseThrow(), Usuario.class);
        usuarioService.delete(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("usuario deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable @Valid Long id,
            @RequestBody  UsuarioRequest usuarioRequest) {
        Optional<Usuario> profeOptional = usuarioService.findById(id);
        Usuario usuario = new ModelMapper().map(usuarioRequest, Usuario.class);
        usuario.setId(profeOptional.orElseThrow().getId());
        usuarioService.save(usuario);
        UsuarioResponse usuarioResponse = new ModelMapper().map(usuario, UsuarioResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }
}
