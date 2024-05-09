package com.school.usecase.aluno;

import com.school.entidade.aluno.Aluno;

public interface ConsultarAlunoGateway {

    Aluno consultar(String id);
}
