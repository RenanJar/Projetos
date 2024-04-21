package com.school.service;

import com.school.entidade.Aluno;
import com.school.gateway.CadastrarAlunoGateway;
import com.school.mapper.AlunoMapper;
import com.school.repository.AlunoRepository;
import com.school.repositoryimpl.JpaAlunoRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import static com.school.util.Util.log;
@Service
public class CadastrarAlunoGatewayImpl implements CadastrarAlunoGateway {

    private JpaAlunoRepository jpaAlunoRepository;

    private AlunoMapper alunoMapper;


    public CadastrarAlunoGatewayImpl(JpaAlunoRepository jpaAlunoRepository, AlunoMapper alunoMapper) {
        this.jpaAlunoRepository = jpaAlunoRepository;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public boolean cadastrar(Aluno aluno) {
        try{

            log.info("Inicio Cadastro Aluno");
            jpaAlunoRepository.save(alunoMapper.toAlunoModel(aluno));
            log.info("Aluno Cadastrado com Successo");
            return true;

        }catch (Exception exception){
            log.info("Falha ao CadastrarAluno");
            return false;
        }
    }
}
