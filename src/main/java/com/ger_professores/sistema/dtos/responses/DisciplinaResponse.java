package com.ger_professores.sistema.dtos.responses;

import java.util.List;

import lombok.Data;

@Data
public class DisciplinaResponse {

    private String disciplina_nome;
    private Integer disciplina_carga;

    private List<ProfessorResponse> professores;
    private List<CursoResponse> cursos;
}
