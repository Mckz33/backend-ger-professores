package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.models.Disciplina;
import java.util.List;
import lombok.Data;

@Data
public class CursoRequest {

  private Long curso_id;

  private String curso_nome;

  private List<Disciplina> disciplinas;
}
