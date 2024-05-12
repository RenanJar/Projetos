package com.school.usecase.gateway;

import com.school.entidade.aluno.Aluno;

public interface ConsultarAlunoGateway {

    Aluno consultar(String id);
}
