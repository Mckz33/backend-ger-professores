package com.ger_professores.sistema.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
@Table(name = "curso")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long curso_id;
    private String curso_nome;

    @ManyToMany
    @JoinColumn(name = "trimestre_id")
    private Trimestre trimestre;

    @OneToOne
    @JoinColumn(name = "coordenador_id")
    private Coordenador coordenador;

    @ManyToMany
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

}
