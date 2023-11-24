package com.ger_professores.sistema.dtos.responses;


import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DisciplinaResponse {

    @NotNull
    private Long disciplina_id;

    @NotBlank(message = "O nome da disciplina não pode estar em branco")
    private String disciplina_nome;

    @NotNull(message = "A carga horária da disciplina não pode ser nula")
    private Integer disciplina_carga;

    @Valid
    @Nullable
    private List<ProfessorResponse> professores;
    
    @Valid
    @Nullable
    private CursoResponse curso;
}
