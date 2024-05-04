package com.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="TBL_ALUNO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel extends BaseModel{

    @Id
    @Column(name = "alunoid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;

    @Column(name="numeroContato")
    private Long numeroContato;

    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name ="endereco_id")
    private EnderecoModel endereco;
}
