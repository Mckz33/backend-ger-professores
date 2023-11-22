package com.ger_professores.sistema.dtos.responses;

import java.util.List;


import lombok.Data;

@Data
public class TrimestreResponse {

    private String descricao;

    private List<CursoResponse> cursos;

}
