package com.school.model;

import com.school.entidade.endereco.Endereco;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="TBL_ALUNO")
@Getter
@Setter
public class AlunoModel {

    @Id
    @Column(name = "alunoid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name ="endereco_id")
    private Endereco endereco;

    @Column(name="numeroContato")
    private Long numeroContato;

    @Column(name="email")
    private String email;

}
