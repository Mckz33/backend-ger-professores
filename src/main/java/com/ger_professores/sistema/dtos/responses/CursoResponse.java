package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.models.Disciplina;
import java.util.List;
import lombok.Data;

@Data
public class CursoResponse {

  private Long curso_id;

  private String curso_nome;

  private List<Disciplina> disciplinas;
}
