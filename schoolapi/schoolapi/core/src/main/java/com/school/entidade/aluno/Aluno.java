package com.school.entidade.aluno;

import com.school.entidade.Entity;
import com.school.entidade.endereco.Endereco;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
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
        alunoAtualizado.trocarNome(alunoValidado.getNome());
        alunoAtualizado.trocarEmail(alunoValidado.getEmail());
        alunoAtualizado.trocarNumeroContato(alunoValidado.getNumeroContato());
        alunoAtualizado.setID(alunoValidado.getID());
        alunoAtualizado.trocarEndereco(aluno.getEndereco());
        alunoAtualizado.trocarDataNascimento(alunoValidado.getDataNascimento());
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
        validarID(aluno.getID());
        validarNome(aluno.getNome());
        validarDataNascimento(aluno.getDataNascimento());
        validarNumeroContato(aluno.getNumeroContato());
        validarEndereco(aluno.getEndereco());
        validarEmail(aluno.getEmail());
        return aluno;
    }

    private static Aluno validarCriarAluno(Aluno aluno){
        validarNome(aluno.getNome());
        validarDataNascimento(aluno.getDataNascimento());
        validarNumeroContato(aluno.getNumeroContato());
        validarEndereco(aluno.getEndereco());
        validarEmail(aluno.getEmail());
        return aluno;
    }

   private static void validarNome(String nome){
       Objects.requireNonNull(nome, "Nome nao pode ser vazio");
   }

   private static void validarDataNascimento(LocalDate dataNascimento){
       Objects.requireNonNull(dataNascimento,"Aluno deve conter uma data de nascimento");
   }

   private static void validarEndereco(Endereco endereco){
       Objects.requireNonNull(endereco,"Aluno deve conter um endereço");

   }

   private static void validarNumeroContato(Long numeroContato){
       Objects.requireNonNull(numeroContato,"Aluno deve Conter um numero para Contato");

   }

   private static void validarEmail(String email){
       Objects.requireNonNull(email,"Aluno deve Conter um E-mail");
   }

   private static void validarID(UUID ID){
       Objects.requireNonNull(ID, "ID de Aluno nao pode ser vazio");
   }

   public void trocarNome(String nome){
        validarNome(nome);
        this.nome = nome;
   }

   public void trocarEndereco(Endereco endereco){
        validarEndereco(endereco);
        this.endereco = endereco;
   }

   public void trocarEmail(String email){
        validarEmail(email);
        this.email = email;
   }

   public void trocarNumeroContato(Long numeroContato){
        validarNumeroContato(numeroContato);
        this.numeroContato = numeroContato;
   }

   public void trocarDataNascimento(LocalDate dataNascimento){
        validarDataNascimento(dataNascimento);
        this.dataNascimento = dataNascimento;
   }


}
