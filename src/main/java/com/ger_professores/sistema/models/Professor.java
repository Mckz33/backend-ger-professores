package com.ger_professores.sistema.models;

import java.util.List;

import com.ger_professores.sistema.enums.Contratacao;
import com.ger_professores.sistema.enums.Tipo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private Tipo tipo;

    @Column(nullable = false)
    private Integer professor_carga;

    @ManyToMany(mappedBy = "professores")
    private List<Disciplina> disciplinas;
    
    @Column(nullable = false)
    private Contratacao contratacao;
}