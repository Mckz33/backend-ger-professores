package com.ger_professores.sistema.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ger_professores.sistema.dtos.responses.ProfessorResponse;
import com.ger_professores.sistema.models.Professor;
import com.ger_professores.sistema.models.Usuario;

// @Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configurar o mapeamento de Usuario para UsuarioProfessorDTO
        modelMapper.createTypeMap(Usuario.class, ProfessorResponse.class)
                .addMapping(src -> src.getNome(), ProfessorResponse::setNome)
                .addMapping(src -> src.getCpf(), ProfessorResponse::setCpf)
                .addMapping(src -> src.getEmail(), ProfessorResponse::setEmail);

        // Configurar o mapeamento de Professor para UsuarioResponse
        modelMapper.createTypeMap(Professor.class, ProfessorResponse.class)
                .addMapping(src -> ((Professor) src).getProfessor_carga(), ProfessorResponse::setProfessor_carga)
                .addMapping(src -> ((Professor) src).getCurso(), ProfessorResponse::setCurso)
                .addMapping(src -> ((Professor) src).getDisciplina(), ProfessorResponse::setDisciplina)
                .addMapping(src -> ((Professor) src).getContratacao(), ProfessorResponse::setContratacao);

        return modelMapper;
    }
}