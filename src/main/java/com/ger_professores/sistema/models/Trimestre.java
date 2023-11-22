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
import jakarta.persistence.OneToMany;
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
@Table(name = "trimestre")
public class Trimestre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long trimestre_id;
    @Column(nullable = false)
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "trimestre_curso",
        joinColumns = @JoinColumn(name = "trimestre_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

}
