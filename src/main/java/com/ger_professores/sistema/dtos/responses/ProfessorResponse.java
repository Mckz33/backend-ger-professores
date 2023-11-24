package com.ger_professores.sistema.dtos.responses;

import java.util.List;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.Tipo;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfessorResponse {

    @NotNull
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @NotBlank
    private String email;
    
    @NotNull
    private Tipo tipo;

    @NotNull
    private Integer professor_carga;

    @NotNull
    private Contratacao contratacao;

    @Valid
    @Nullable
    private List<DisciplinaResponse> disciplinas;
}
