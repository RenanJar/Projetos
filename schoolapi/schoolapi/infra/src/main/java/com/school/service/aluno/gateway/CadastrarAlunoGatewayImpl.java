package com.school.service.aluno.gateway;

import com.school.entidade.aluno.Aluno;
import com.school.gateway.CadastrarAlunoGateway;
import com.school.mapper.Aluno_Mapper;
import com.school.model.AlunoModel;
import com.school.repositoryimpl.JpaAlunoRepository;
import com.school.repositoryimpl.JpaEnderecoRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import static com.school.util.Util.log;

@Service
@AllArgsConstructor
public class CadastrarAlunoGatewayImpl implements CadastrarAlunoGateway {

    private JpaAlunoRepository jpaAlunoRepository;
    private JpaEnderecoRepository jpaEnderecoRepository;


    @Override
    public Aluno cadastrar(Aluno aluno) {
        Aluno_Mapper mapper = Mappers.getMapper(Aluno_Mapper.class);
        try{
            log.info("Inicio Cadastro Aluno");
            AlunoModel alunoCadastrado = jpaAlunoRepository.save(mapper.toModel(aluno));
            log.info("Aluno Cadastrado com Successo");
            return mapper.toAluno(alunoCadastrado);
        }catch (Exception exception){
            log.info("Falha ao CadastrarAluno");
            return null;
        }
    }
}
