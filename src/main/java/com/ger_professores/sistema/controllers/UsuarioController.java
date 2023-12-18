package com.ger_professores.sistema.controllers;

import com.ger_professores.sistema.dtos.requests.UsuarioRequest;
import com.ger_professores.sistema.dtos.responses.UsuarioResponse;
import com.ger_professores.sistema.models.Usuario;
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
@RequestMapping("/api/usuario")
public class UsuarioController {

  @Autowired
  UsuarioService usuarioService;

  @GetMapping
  public ResponseEntity<List<UsuarioResponse>> findAll() {
    List<Usuario> usuarios = usuarioService.findAll();
    List<UsuarioResponse> usuarioResponses = usuarios
        .stream()
        .map(a -> new ModelMapper().map(a, UsuarioResponse.class))
        .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK).body(usuarioResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
    Optional<Usuario> usuarioOptional = usuarioService.findById(id);
    UsuarioResponse usuarioResponse = new ModelMapper()
        .map(usuarioOptional.orElseThrow(), UsuarioResponse.class);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
  }

  @PostMapping
  public ResponseEntity<UsuarioResponse> save(
      @RequestBody @Valid UsuarioRequest usuarioRequest) {
    Usuario usuario = new ModelMapper().map(usuarioRequest, Usuario.class);
    usuario = usuarioService.save(usuario);
    UsuarioResponse usuarioResponse = new ModelMapper()
        .map(usuario, UsuarioResponse.class);
    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable Long id) {
    Optional<Usuario> usuarioOptional = usuarioService.findById(id);
    Usuario usuario = new ModelMapper()
        .map(usuarioOptional.orElseThrow(), Usuario.class);
    usuarioService.delete(usuario);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body("usuario deletado com sucesso.");
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioResponse> update(@PathVariable Long id,
      @RequestBody @Valid UsuarioRequest usuarioRequest) {
    Optional<Usuario> profeOptional = usuarioService.findById(id);
    Usuario usuario = new ModelMapper().map(usuarioRequest, Usuario.class);
    usuario.setUsuarioId(profeOptional.orElseThrow().getUsuarioId());
    usuarioService.save(usuario);
    UsuarioResponse usuarioResponse = new ModelMapper()
        .map(usuario, UsuarioResponse.class);
    return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
  }

  @PutMapping("/{usuarioId}/login/{id}")
  public ResponseEntity<?> associarProfessor(
      @PathVariable Long usuarioId,
      @PathVariable Long id) {
    usuarioService.associarUser(usuarioId, id);
    return ResponseEntity.status(HttpStatus.OK).body("Associado com sucesso!");
  }
}
