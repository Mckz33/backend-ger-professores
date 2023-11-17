package com.ger_professores.sistema.models.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorMessage {

    private String titulo;

    private Integer status;

    private String mensagem;

}