package com.ger_professores.sistema.models;

import com.ger_professores.sistema.enums.Contratacao;

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
@Table(name = "professor")
public class Professor extends Usuario {

    @Column(nullable = false)
    private Integer professor_carga;
    @Column(nullable = false)
    private String disciplina;
    @Column(nullable = false)
    private Contratacao contratacao;
}
