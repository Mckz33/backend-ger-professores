package com.ger_professores.sistema.dtos.requests;


import lombok.Data;

@Data
public class DisciplinaRequest {

    private String disciplina_nome;
    private Integer disciplina_carga;

    private ProfessorRequest professor;
    private CursoRequest curso;
}
