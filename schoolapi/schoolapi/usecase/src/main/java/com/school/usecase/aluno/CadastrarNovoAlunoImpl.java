package com.school.usecase.aluno;

import com.school.entidade.Aluno;
import com.school.gateway.CadastrarAlunoGateway;
import com.school.usecaseinterface.aluno.CadastrarNovoAluno;


public class CadastrarNovoAlunoImpl implements CadastrarNovoAluno {

    private CadastrarAlunoGateway cadastrarAlunoGateway;

    public CadastrarNovoAlunoImpl(CadastrarAlunoGateway cadastrarAlunoGateway) {
        this.cadastrarAlunoGateway = cadastrarAlunoGateway;
    }
    @Override
    public Aluno cadastrar(Aluno aluno) {

        boolean isCadastrado = cadastrarAlunoGateway.cadastrar(aluno);

        if(isCadastrado){
            return aluno;
        }

        return null;
    }



}
