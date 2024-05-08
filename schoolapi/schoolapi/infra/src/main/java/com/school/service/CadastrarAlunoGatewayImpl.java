package com.school.service;

import com.school.entidade.aluno.Aluno;
import com.school.gateway.CadastrarAlunoGateway;
import com.school.mapper.AlunoMapper;
import com.school.mapper.EnderecoMapper;
import com.school.model.AlunoModel;
import com.school.model.EnderecoModel;
import com.school.repositoryimpl.JpaAlunoRepository;
import com.school.repositoryimpl.JpaEnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import static com.school.util.Util.log;

@Service
@AllArgsConstructor
public class CadastrarAlunoGatewayImpl implements CadastrarAlunoGateway {

    private JpaAlunoRepository jpaAlunoRepository;

    private JpaEnderecoRepository jpaEnderecoRepository;

    private AlunoMapper alunoMapper;


    @Override
    public Aluno cadastrar(Aluno aluno) {
        try{

            log.info("Inicio Cadastro Aluno");
            AlunoModel alunoCadastrado = jpaAlunoRepository.save(alunoMapper.toAlunoModel(aluno));
            log.info("Aluno Cadastrado com Successo");
            return alunoMapper.toAluno(alunoCadastrado);
        }catch (Exception exception){
            log.info("Falha ao CadastrarAluno");
            return null;
        }
    }
}
