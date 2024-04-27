package com.school.mapper;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.entidade.aluno.Aluno;
import com.school.model.AlunoModel;

public class AlunoMapper {

    public Aluno toAluno(CadastrarAlunoRequest request){
        Aluno aluno =  Aluno.criarAluno(
                request.getNome(),
                request.getDataNascimento(),
                request.getEndereco(),
                request.getNumeroContato(),
                request.getEmail());
        return aluno;
    }

    public AlunoModel toAlunoModel(Aluno aluno){
        AlunoModel model =  new AlunoModel();
        model.setNome(aluno.getNome());
        return model;
    }
}
