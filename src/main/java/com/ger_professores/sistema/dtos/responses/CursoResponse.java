package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.models.Coordenador;
import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.Trimestre;

import lombok.Data;

@Data
public class CursoResponse {

    private Long curso_id;
    private String curso_nome;

    private Trimestre trimestre;
    private Coordenador coordenador;
    private Disciplina disciplina;

}
