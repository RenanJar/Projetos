package com.school.usecase.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.gateway.CadastrarAlunoGateway;
import com.school.usecaseinterface.aluno.CadastrarNovoAluno;


public class CadastrarNovoAlunoImpl implements CadastrarNovoAluno {

    private CadastrarAlunoGateway cadastrarAlunoGateway;

    public CadastrarNovoAlunoImpl(CadastrarAlunoGateway cadastrarAlunoGateway) {
        this.cadastrarAlunoGateway = cadastrarAlunoGateway;
    }
    @Override
    public Aluno cadastrar(Aluno aluno) {

        // cadastrar endereço - > regras -> entidade  se ok -> set aluno
        // cadastrar o aluno -> regras -> entidade se ok -> gateway.Cadastrar()

        boolean isCadastrado = cadastrarAlunoGateway.cadastrar(aluno);

        if(isCadastrado){
            return aluno;
        }

        return null;
    }



}
