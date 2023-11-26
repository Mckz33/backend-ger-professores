package com.ger_professores.sistema.dtos.responses;

import java.util.List;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TrimestreResponse {

    @NotNull
    private Long trimestre_id;

    @NotBlank
    private String descricao;

    @Valid 
    @Nullable
    private List<CursoResponse> cursos;

}
