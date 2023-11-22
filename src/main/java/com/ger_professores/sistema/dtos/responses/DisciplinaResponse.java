package com.ger_professores.sistema.dtos.responses;


import com.ger_professores.sistema.dtos.requests.CursoRequest;
import com.ger_professores.sistema.dtos.requests.ProfessorRequest;

import lombok.Data;

@Data
public class DisciplinaResponse {

    private Long disciplina_id;
    private String disciplina_nome;
    private Integer disciplina_carga;

    private ProfessorRequest professor;
    private CursoRequest curso;

}
