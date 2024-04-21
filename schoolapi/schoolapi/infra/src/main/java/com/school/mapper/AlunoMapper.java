package com.school.mapper;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.entidade.Aluno;
import com.school.model.AlunoModel;

public class AlunoMapper {

    public Aluno toAluno(CadastrarAlunoRequest request){
        Aluno aluno =  new Aluno();
        aluno.setNome(request.getNome());
        return aluno;
    }

    public AlunoModel toAlunoModel(Aluno aluno){
        AlunoModel model =  new AlunoModel();
        model.setNome(aluno.getNome());
        return model;
    }
}
