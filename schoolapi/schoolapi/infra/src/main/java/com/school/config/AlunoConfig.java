package com.school.config;

import com.school.gateway.CadastrarAlunoGateway;
import com.school.usecase.aluno.CadastrarNovoAlunoImpl;
import com.school.usecaseinterface.aluno.CadastrarNovoAluno;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunoConfig {

    @Bean
    public CadastrarNovoAluno cadastrarNovoAluno(CadastrarAlunoGateway cadastrarAlunoGateway){
        return new CadastrarNovoAlunoImpl(cadastrarAlunoGateway);
    }

}
