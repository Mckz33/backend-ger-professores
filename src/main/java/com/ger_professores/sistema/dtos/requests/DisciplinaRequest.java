package com.ger_professores.sistema.dtos.requests;

import java.util.List;

import lombok.Data;

@Data
public class DisciplinaRequest {

    private String disciplina_nome;
    private Integer disciplina_carga;

    private List<ProfessorRequest> professores;
    private List<CursoRequest> cursos;
}
