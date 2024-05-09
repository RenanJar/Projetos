package com.school.usecase.aluno;

import com.school.entidade.aluno.Aluno;

public class ConsultarAlunoImpl implements IconsultarAluno {

    private ConsultarAlunoGateway consultarAlunoGateway;

    public ConsultarAlunoImpl(ConsultarAlunoGateway consultarAlunoGateway) {
        this.consultarAlunoGateway = consultarAlunoGateway;
    }

    @Override
    public Aluno consultarAluno(String id) {
        return null;
    }
}
