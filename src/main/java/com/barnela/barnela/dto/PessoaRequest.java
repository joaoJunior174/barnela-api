package com.barnela.barnela.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PessoaRequest {

    String nome;
    String telefone;
    List<String> presentes;
}
