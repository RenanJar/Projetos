package com.school.mapper;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.entidade.aluno.Aluno;
import com.school.entidade.endereco.Endereco;
import com.school.model.AlunoModel;
import com.school.model.EnderecoModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AlunoMapper {

    private EnderecoMapper enderecoMapper;

    public Aluno toAluno(CadastrarAlunoRequest request){
        return Aluno.criarAluno(
                request.getNome(),
                request.getDataNascimento(),
                request.getEndereco(),
                request.getNumeroContato(),
                request.getEmail()
        );
    }

    public AlunoModel toAlunoModel(Aluno aluno){
        EnderecoModel enderecoModel = enderecoMapper.toEnderecoModel(aluno.getEndereco());
        AlunoModel model =  new AlunoModel();
        model.setEndereco(enderecoModel);
        model.setNome(aluno.getNome());
        model.setDataNascimento(aluno.getDataNascimento());
        model.setEmail(aluno.getEmail());
        model.setNumeroContato(aluno.getNumeroContato());
        model.setDataInclusao(aluno.getDataInclusao());
        model.setDataDelete(aluno.getDataDelete());
        model.setDataAtualizacao(aluno.getDataAtualizacao());
        model.setIsDeletado(aluno.getIsDelete());
        return model;
    }

    public Aluno toAluno(AlunoModel alunoModel){

        Endereco endereco = enderecoMapper.toEndereco(alunoModel.getEndereco());

        Aluno aluno =  Aluno.criarAluno(
                alunoModel.getNome(),
                alunoModel.getDataNascimento(),
                endereco,
                alunoModel.getNumeroContato(),
                alunoModel.getEmail()
        );

        aluno.setID(alunoModel.getId());

        return aluno;
    }
}
