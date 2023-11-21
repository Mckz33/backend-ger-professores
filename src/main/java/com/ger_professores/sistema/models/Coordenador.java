package com.ger_professores.sistema.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coordenador extends Usuario {

    private String login;
    private String senha;
    
}
