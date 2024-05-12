package com.school.usecase.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.usecase.gateway.ConsultarAlunoGateway;

public class ConsultarAlunoImpl {

    private ConsultarAlunoGateway consultarAlunoGateway;

    public ConsultarAlunoImpl(ConsultarAlunoGateway consultarAlunoGateway) {
        this.consultarAlunoGateway = consultarAlunoGateway;
    }

}
