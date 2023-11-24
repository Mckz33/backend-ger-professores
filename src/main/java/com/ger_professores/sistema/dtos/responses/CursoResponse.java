package com.ger_professores.sistema.dtos.responses;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CursoResponse {

    @NotNull
    private Long curso_id;

    @NotBlank(message = "O nome do curso não pode estar em branco")
    private String curso_nome;

    @Valid
    @Nullable
    private TrimestreResponse trimestres;

    @Valid
    @Nullable
    private ProfessorResponse coordenador;

    @Valid
    @Nullable
    private List<DisciplinaResponse> disciplinas;
}
