package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.dtos.responses.CursoResponse;
import com.ger_professores.sistema.dtos.responses.DisciplinaResponse;
import com.ger_professores.sistema.dtos.responses.ProfessorResponse;

import jakarta.validation.Valid;
import lombok.Data;

@Data
public class CursoDisciplinaProfessorRequest {


    @Valid
    private CursoResponse curso;

    @Valid
    private DisciplinaResponse disciplina;

    @Valid
    private ProfessorResponse professor;
}
