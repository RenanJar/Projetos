package com.school.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.util.UUID;

@Entity
@Table(name="TBL_ALUNO")
public class AlunoModel {

    @Id
    @Column(name = "alunoid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome")
    private String nome;

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
}
