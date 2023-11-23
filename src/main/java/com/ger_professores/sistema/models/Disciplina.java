package com.ger_professores.sistema.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "disciplina")
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long disciplina_id;
    private String disciplina_nome;
    private Integer disciplina_carga;

    @OneToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @OneToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
