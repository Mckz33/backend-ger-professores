package com.ger_professores.sistema.dtos.requests;

import java.util.List;

import com.ger_professores.sistema.dtos.responses.DisciplinaResponse;
import com.ger_professores.sistema.dtos.responses.ProfessorResponse;
import com.ger_professores.sistema.dtos.responses.TrimestreResponse;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CursoRequest {

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

    @Valid
    @Nullable
    private List<CursoDisciplinaProfessorRequest> cursoDisciplinaProfessores;
}
