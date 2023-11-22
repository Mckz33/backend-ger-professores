package com.ger_professores.sistema.dtos.responses;

import com.ger_professores.sistema.enums.Contratacao;

import lombok.Data;

@Data
public class ProfessorResponse {

    private String nome;
    private String cpf;
    private String email;

    private String disciplina;
    private Contratacao contratacao;

}
