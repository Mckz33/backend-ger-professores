package com.ger_professores.sistema.dtos.responses;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CursoDisciplinaProfessorResponse {
    @NotNull
    private Long id;

    @Valid
    private CursoResponse curso;

    @Valid
    private DisciplinaResponse disciplina;

    @Valid
    private ProfessorResponse professor;

}
