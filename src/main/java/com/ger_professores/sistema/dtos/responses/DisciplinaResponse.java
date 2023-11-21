package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.models.Professor;

import lombok.Data;

@Data
public class DisciplinaResponse {
    private Long disciplina_id;
    private String disciplina_nome;
    private Integer disciplina_carga;    

    private Professor professor;

}
