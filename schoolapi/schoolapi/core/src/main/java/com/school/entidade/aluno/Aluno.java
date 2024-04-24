package com.school.entidade.aluno;

import com.school.entidade.Entity;
import com.school.entidade.endereco.Endereco;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Entity {

    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Long numeroContato;
    private String email;

}
