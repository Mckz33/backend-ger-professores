package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.models.Coordenador;
import com.ger_professores.sistema.models.Disciplina;
import com.ger_professores.sistema.models.Trimestre;

import lombok.Data;

@Data
public class CursoRequest {

    private Long curso_id;
    private String curso_nome;

    private Trimestre trimestre;
    private Coordenador coordenador;
    private Disciplina disciplina;
}
