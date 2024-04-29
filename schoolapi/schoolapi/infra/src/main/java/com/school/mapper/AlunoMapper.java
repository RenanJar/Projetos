package com.school.mapper;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.entidade.aluno.Aluno;
import com.school.model.AlunoModel;

public class AlunoMapper {

    public Aluno toAluno(CadastrarAlunoRequest request){
        return Aluno.criarAluno(
                request.getNome(),
                request.getDataNascimento(),
                request.getEndereco(),
                request.getNumeroContato(),
                request.getEmail());
    }

    public AlunoModel toAlunoModel(Aluno aluno){
        AlunoModel model =  new AlunoModel();
        model.setNome(aluno.getNome());
        model.setDataNascimento(aluno.getDataNascimento());
        model.setEmail(aluno.getEmail());
        model.setNumeroContato(aluno.getNumeroContato());
        return model;
    }
}
