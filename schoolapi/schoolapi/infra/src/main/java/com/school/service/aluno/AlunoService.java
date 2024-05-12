package com.school.service.aluno;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.dto.response.CadastrarAlunoResponse;
import com.school.dto.response.ConsultarAlunoResponse;
import com.school.entidade.aluno.Aluno;
import com.school.mapper.Aluno_Mapper;
import com.school.usecase.aluno.CadastrarAlunoUseCase;
import lombok.AllArgsConstructor;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AlunoService {

    private CadastrarAlunoUseCase cadastrarNovoAluno;

    public CadastrarAlunoResponse cadastrarNovoAluno(CadastrarAlunoRequest request){
        Aluno_Mapper mapper = Mappers.getMapper(Aluno_Mapper.class);
        Aluno aluno = mapper.toAluno(request);
        Aluno alunocadastrado = cadastrarNovoAluno.cadastrar(aluno);
        return mapper.toCadastrarResponse(alunocadastrado);
    }

    public ConsultarAlunoResponse consultarAluno(String id){
        return new ConsultarAlunoResponse();
    }

}
