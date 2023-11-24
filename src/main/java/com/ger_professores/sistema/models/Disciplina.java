package com.ger_professores.sistema.models;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "disciplina")
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long disciplina_id;

    @Column(nullable = false)
    private String disciplina_nome;
    
    @Column(nullable = false)
    private Integer disciplina_carga;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplina_professor",
               joinColumns = @JoinColumn(name = "disciplina_id"),
               inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professores;

}
