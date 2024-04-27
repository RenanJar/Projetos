package com.school.entidade.aluno;

import com.school.entidade.Entity;
import com.school.entidade.endereco.Endereco;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Aluno extends Entity {

    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Long numeroContato;
    private String email;

    private Aluno(
            UUID id,
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
        this.ID = id;
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

    private Aluno(){}

    public static Aluno criarAluno(
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

    public static Aluno atualizarAluno(Aluno aluno){
        Aluno alunoValidado = validarAtualizarAluno(aluno);
        Aluno alunoAtualizado = new Aluno();
        alunoAtualizado.setNome(alunoValidado.getNome());
        alunoAtualizado.setEmail(alunoValidado.getEmail());
        alunoAtualizado.setNumeroContato(alunoValidado.getNumeroContato());
        alunoAtualizado.setID(alunoValidado.getID());
        alunoAtualizado.setDataNascimento(alunoValidado.getDataAtualizacao());
        alunoAtualizado.setDataAtualizacao(LocalDate.now());
        alunoAtualizado.setIsDelete(false);
        return alunoAtualizado;
    }

    public static Aluno deletarAluno(Aluno aluno){
        Objects.requireNonNull(aluno.getID());
        aluno.setIsDelete(true);
        aluno.setDataDelete(LocalDate.now());
        return aluno;
    }

    private static Aluno buildAluno(
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email
    ){
        LocalDate dataHoje = LocalDate.now();
        Aluno aluno = new Aluno(
                null,
                nome,
                dataNascimento,
                endereco,
                numeroContato,
                email,
                dataHoje,
                null,
                null,
                false
        );
        return validarCriarAluno(aluno);
    }

    public Aluno excluirAluno(Aluno aluno){
        aluno.setDataDelete(LocalDate.now());
        aluno.setIsDelete(true);
        return aluno;
    }

    private static Aluno validarAtualizarAluno(Aluno aluno){
        Objects.requireNonNull(aluno.getID(), "ID de Aluno nao pode ser vazio");
        Objects.requireNonNull(aluno.getNome(), "Nome nao pode ser vazio");
        Objects.requireNonNull(aluno.getDataNascimento(),"Aluno deve conter uma data de nascimento");
        Objects.requireNonNull(aluno.getEndereco(),"Aluno deve conter um endereço");
        Objects.requireNonNull(aluno.getNumeroContato(),"Aluno deve Conter um numero para Contato");
        Objects.requireNonNull(aluno.getEmail(),"Aluno deve Conter um E-mail");
        return aluno;
    }

    private static Aluno validarCriarAluno(Aluno aluno){
        Objects.requireNonNull(aluno.getNome(), "Nome nao pode ser vazio");
        Objects.requireNonNull(aluno.getDataNascimento(),"Aluno deve conter uma data de nascimento");
        Objects.requireNonNull(aluno.getEndereco(),"Aluno deve conter um endereço");
        Objects.requireNonNull(aluno.getNumeroContato(),"Aluno deve Conter um numero para Contato");
        Objects.requireNonNull(aluno.getEmail(),"Aluno deve Conter um E-mail");
        return aluno;
    }

}
