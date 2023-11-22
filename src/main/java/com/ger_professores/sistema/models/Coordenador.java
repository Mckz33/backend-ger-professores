package com.ger_professores.sistema.models;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coordenador extends Usuario {

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;

}
