package com.ger_professores.sistema.dtos.responses;

import lombok.Data;

@Data
public class CoordenadorResponse {
    
    private Long id;
    private String nome;
    private String cpf;
    private String email;

    private String login;
    private String senha;
}
