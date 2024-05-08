package com.school.usecase.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.gateway.CadastrarAlunoGateway;
import com.school.usecaseinterface.aluno.CadastrarNovoAluno;

import java.util.Optional;


public class CadastrarNovoAlunoImpl implements CadastrarNovoAluno {

    private CadastrarAlunoGateway cadastrarAlunoGateway;

    public CadastrarNovoAlunoImpl(CadastrarAlunoGateway cadastrarAlunoGateway) {
        this.cadastrarAlunoGateway = cadastrarAlunoGateway;
    }

    @Override
    public Aluno cadastrar(Aluno aluno) {

        Optional<Aluno> alunoCadastrado = Optional.of(cadastrarAlunoGateway.cadastrar(aluno));

        //log informando que nao foi cadastrado

        return alunoCadastrado.isPresent() ? alunoCadastrado.get() : null;
    }



}
