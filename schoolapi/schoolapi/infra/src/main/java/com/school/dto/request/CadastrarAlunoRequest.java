package com.school.dto.request;

import com.school.entidade.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CadastrarAlunoRequest {

    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Long numeroContato;
    private String email;

}
