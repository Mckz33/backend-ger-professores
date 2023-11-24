package com.ger_professores.sistema.dtos.requests;

import java.util.List;

import com.ger_professores.sistema.dtos.responses.CursoResponse;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TrimestreRequest {

    @NotBlank
    private String descricao;

    @Valid 
    @Nullable
    private List<CursoResponse> cursos;

}
