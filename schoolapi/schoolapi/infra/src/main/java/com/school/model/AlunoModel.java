package com.school.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

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

    public AlunoModel(LocalDate dataAtualizacao, LocalDate dataInclusao, LocalDate dataDelete, Boolean isDeletado, UUID id, String nome, LocalDate dataNascimento, Long numeroContato, String email, EnderecoModel endereco) {
        super(dataAtualizacao, dataInclusao, dataDelete, isDeletado);
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.numeroContato = numeroContato;
        this.email = email;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(Long numeroContato) {
        this.numeroContato = numeroContato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
