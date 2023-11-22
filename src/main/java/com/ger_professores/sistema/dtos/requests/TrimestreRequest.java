package com.ger_professores.sistema.dtos.requests;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TrimestreRequest {

    @NotBlank
    private String descricao;

    private List<CursoRequest> cursos;

}
