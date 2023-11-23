package com.ger_professores.sistema.dtos.requests;

import java.util.List;


import lombok.Data;

@Data
public class CursoRequest {

    private Long curso_id;
    private String curso_nome;

    private TrimestreRequest trimestres;
    private CoordenadorRequest coordenador;
    private List<DisciplinaRequest> disciplinas;
}
