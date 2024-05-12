package com.school.service.aluno.gateway;

import com.school.entidade.aluno.Aluno;
import com.school.repositoryimpl.JpaAlunoRepository;
import com.school.usecase.gateway.ConsultarAlunoGateway;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsultarAlunoGatewayImpl implements ConsultarAlunoGateway {

    private JpaAlunoRepository jpaAlunoRepository;

    @Override
    public Aluno consultar(String id) {
        return null;
    }
}
