package com.school.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name="TBL_ALUNO")
public class AlunoModel extends BaseModel{

    @Id
    @Column(name = "alunoid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name="numerocontato")
    private Long numeroContato;

    @Column(name="email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "enderecoid")
    private EnderecoModel endereco;

    public AlunoModel(LocalDateTime dataAtualizacao, LocalDateTime dataInclusao, LocalDateTime dataDelete, Boolean isDeletado, UUID id, String nome, LocalDate dataNascimento, Long numeroContato, String email, EnderecoModel endereco) {
        super(dataAtualizacao, dataInclusao, dataDelete, isDeletado);
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroContato = numeroContato;
        this.email = email;
        this.endereco = endereco;
    }

    public AlunoModel() {

    }

}
