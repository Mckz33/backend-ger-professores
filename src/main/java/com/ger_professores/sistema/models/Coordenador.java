package com.ger_professores.sistema.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "coordenador")
public class Coordenador extends Usuario {

    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String senha;

}
