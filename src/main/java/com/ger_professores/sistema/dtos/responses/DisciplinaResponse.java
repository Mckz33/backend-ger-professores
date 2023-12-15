package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.enums.StatusAtivo;
import com.ger_professores.sistema.enums.Trimestre;
import com.ger_professores.sistema.models.Usuario;
import lombok.Data;

@Data
public class DisciplinaResponse {

  private Long disciplinaId;

  private String disciplinaNome;

  private Integer disciplinaCarga;

  private Trimestre trimestre;

  private Usuario usuario;

  private StatusAtivo statusAtivo;
}
