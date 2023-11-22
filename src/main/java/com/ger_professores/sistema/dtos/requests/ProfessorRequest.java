package com.ger_professores.sistema.dtos.requests;

import org.hibernate.annotations.NotFound;

import com.ger_professores.sistema.enums.Contratacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfessorRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;

    @NotNull
    private Integer professor_carga;
    @NotBlank
    private String disciplina;
    @NotFound
    private Contratacao contratacao;
}
