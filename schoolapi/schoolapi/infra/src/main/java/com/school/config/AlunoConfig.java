package com.school.config;


import com.school.usecase.aluno.CadastrarAlunoUseCase;
import com.school.usecase.aluno.CadastrarNovoAlunoImpl;
import com.school.usecase.gateway.CadastrarAlunoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlunoConfig {

    @Bean
    public CadastrarAlunoUseCase cadastrarNovoAluno(CadastrarAlunoGateway cadastrarAlunoGateway){
        return new CadastrarNovoAlunoImpl(cadastrarAlunoGateway);
    }

}
