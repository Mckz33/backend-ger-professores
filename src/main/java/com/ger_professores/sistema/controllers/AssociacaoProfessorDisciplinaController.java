package com.ger_professores.sistema.controllers;

import com.ger_professores.sistema.models.AssociacaoProfessorDisciplina;
import com.ger_professores.sistema.services.AssociacaoProfessorDisciplinaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/associacoes")
public class AssociacaoProfessorDisciplinaController {

  @Autowired
  AssociacaoProfessorDisciplinaService associacaoService;

  @GetMapping("/pendentes")
  public List<AssociacaoProfessorDisciplina> obterAssociaçõesPendentes() {
    return associacaoService.obterAssociaçõesPendentes();
  }

  @PutMapping("/aprovar/{associaçãoId}")
  public ResponseEntity<String> aprovarAssociação(
      @PathVariable Long associaçãoId) {
    associacaoService.aprovarAssociação(associaçãoId);
    return ResponseEntity.status(HttpStatus.OK).body("Aprovado Com Sucesso!");
  }

  @PostMapping
  public ResponseEntity<AssociacaoProfessorDisciplina> save(
      @RequestBody AssociacaoProfessorDisciplina associacaoProfessorDisciplina) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(associacaoService.save(associacaoProfessorDisciplina));
  }

  @PutMapping("reprovar/{associaçãoId}")
  public ResponseEntity<String> reprovarAssociação(
      @PathVariable Long associaçãoId) {
    associacaoService.reprovarAssociação(associaçãoId);
    return ResponseEntity.status(HttpStatus.OK).body("Aprovado Com Sucesso!");
  }
}
