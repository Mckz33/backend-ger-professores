package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.models.Disciplina;
import java.util.List;
import lombok.Data;

@Data
public class CursoRequest {

  private Long cursoId;

  private String cursoNome;

  private List<Disciplina> disciplinas;
}
