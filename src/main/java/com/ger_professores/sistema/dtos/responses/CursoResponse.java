package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.enums.StatusAtivo;
import com.ger_professores.sistema.models.Disciplina;
import java.util.List;
import lombok.Data;

@Data
public class CursoResponse {

  private Long cursoId;

  private String cursoNome;

  private List<Disciplina> disciplinas;

  private StatusAtivo statusAtivo;
}
