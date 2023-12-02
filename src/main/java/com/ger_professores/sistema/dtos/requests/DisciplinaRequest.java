package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.enums.Trimestre;
import com.ger_professores.sistema.models.Usuario;
import java.util.List;
import lombok.Data;

@Data
public class DisciplinaRequest {

  private Long disciplinaId;

  private String disciplinaNome;

  private Integer disciplinaCarga;

  private Trimestre trimestre;

  private List<Usuario> usuario;
}
