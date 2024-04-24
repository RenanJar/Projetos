package com.school.entidade.aluno;

import com.school.entidade.Entity;
import com.school.entidade.endereco.Endereco;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Aluno extends Entity {

    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Long numeroContato;
    private String email;

    private  Aluno(
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email,
            LocalDate dataInclusao,
            LocalDate dataAtualizacao,
            LocalDate dataDelete,
            Boolean isDeleted

    ){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.email = email;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.dataDelete = dataDelete;
        this.isDelete = isDeleted;
    }

    public Aluno cadastrarAluno(
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email
    ){
        Aluno novoAluno =  buildAluno(
                nome,
                dataNascimento,
                endereco,
                numeroContato,
                email
        );

        novoAluno.setDataInclusao(LocalDate.now());

        return novoAluno;
    }

    public Aluno atualizarAluno(
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email
    ){
        Aluno novoAluno =  buildAluno(nome, dataNascimento, endereco, numeroContato, email);
        novoAluno.setDataAtualizacao(LocalDate.now());
        return novoAluno;
    }

    private Aluno buildAluno(
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email
    ){
        Objects.requireNonNull(nome, "Nome nao pode ser vazio");
        Objects.requireNonNull(dataNascimento,"Aluno deve conter uma data de nascimento");
        Objects.requireNonNull(endereco,"Aluno deve conter um endereço");
        Objects.requireNonNull(numeroContato,"Aluno deve Conter um numero para Contato");
        Objects.requireNonNull(email,"Aluno deve Conter um E-mail");

        return new AlunoBuilder()
                .nome(nome)
                .endereco(endereco)
                .email(email)
                .numeroContato(numeroContato)
                .dataNascimento(dataNascimento)
                .build();
    }

    public Aluno excluirAluno(Aluno aluno){
        aluno.setDataDelete(LocalDate.now());
        aluno.setIsDelete(true);
        return aluno;
    }

}
