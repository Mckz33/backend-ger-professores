package com.ger_professores.sistema.dtos.requests;

import lombok.Data;

@Data
public class CoordenadorRequest {

    private String nome;
    private String cpf;
    private String email;

    private String login;
    private String senha;

}
