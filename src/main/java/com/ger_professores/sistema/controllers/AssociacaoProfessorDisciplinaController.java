package com.ger_professores.sistema.controllers;

import com.ger_professores.sistema.models.AssociacaoProfessorDisciplina;
import com.ger_professores.sistema.services.AssociacaoProfessorDisciplinaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping("/aprovar/{associaçãoId}")
  public void aprovarAssociação(@PathVariable Long associaçãoId) {
    associacaoService.aprovarAssociação(associaçãoId);
  }
}
