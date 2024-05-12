package com.school.usecase.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.usecase.gateway.CadastrarAlunoGateway;
import lombok.AllArgsConstructor;
import java.util.Optional;

@AllArgsConstructor
public class CadastrarNovoAlunoImpl implements  CadastrarAlunoUseCase{

    private CadastrarAlunoGateway cadastrarAlunoGateway;

    @Override
    public Aluno cadastrar(Aluno aluno) {

        Optional<Aluno> alunoCadastrado = Optional.of(cadastrarAlunoGateway.cadastrar(aluno));

        //log informando que nao foi cadastrado

        return alunoCadastrado.isPresent() ? alunoCadastrado.get() : null;
    }

}
