package com.ger_professores.sistema.dtos.responses;

import java.util.List;

import lombok.Data;

@Data
public class CursoResponse {

    private Long curso_id;
    private String curso_nome;

    private TrimestreResponse trimestres;
    private CoordenadorResponse coordenador;
    private List<DisciplinaResponse> disciplinas;

}
