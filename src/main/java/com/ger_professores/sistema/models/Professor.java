package com.ger_professores.sistema.models;

import com.ger_professores.sistema.enums.Contratacao;

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

    private Integer professor_carga;
    private String curso;
    private String disciplina;
    private Contratacao contratacao;
}
