package com.school.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CadastrarAlunoResponse {

    private String nome;
    private LocalDate dataNascimento;
    private EnderecoResponse endereco;
    private Long numeroContato;
    private String email;

    public CadastrarAlunoResponse(String nome, LocalDate dataNascimento, Long numeroContato, EnderecoResponse endereco, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroContato = numeroContato;
        this.endereco = endereco;
        this.email = email;
    }

}
