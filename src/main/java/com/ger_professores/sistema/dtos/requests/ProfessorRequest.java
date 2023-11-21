package com.ger_professores.sistema.dtos.requests;

import com.ger_professores.sistema.enums.Contratacao;

import lombok.Data;

@Data
public class ProfessorRequest {

    private String nome;
    private String cpf;
    private String email;

    private Integer professor_carga;
    private String disciplina;
    private Contratacao contratacao;
}
