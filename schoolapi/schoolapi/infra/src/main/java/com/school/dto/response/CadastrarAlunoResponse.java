package com.school.dto.response;

import com.school.entidade.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


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

    public EnderecoResponse getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoResponse endereco) {
        this.endereco = endereco;
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
}
