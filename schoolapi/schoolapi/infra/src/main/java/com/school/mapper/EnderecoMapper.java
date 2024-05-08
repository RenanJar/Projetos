package com.school.mapper;

import com.school.entidade.aluno.Aluno;
import com.school.entidade.endereco.Endereco;
import com.school.model.AlunoModel;
import com.school.model.EnderecoModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnderecoMapper {

    public Endereco toEndereco (EnderecoModel enderecoModel){
        Endereco endereco = Endereco.criarEndereco(
                enderecoModel.getLogradouro(),
                enderecoModel.getNumero(),
                enderecoModel.getComplemento(),
                enderecoModel.getBairro(),
                enderecoModel.getCidade(),
                enderecoModel.getEstado(),
                enderecoModel.getPais(),
                enderecoModel.getCep()
        );
        endereco.setID(enderecoModel.getId());

        return endereco;
    }

    public EnderecoModel toEnderecoModel(Endereco endereco){
        EnderecoModel model = new EnderecoModel();
        model.setId(endereco.getID());
        model.setLogradouro(endereco.getLogradouro());
        model.setNumero(endereco.getNumero());
        model.setComplemento(endereco.getComplemento());
        model.setBairro(endereco.getBairro());
        model.setCidade(endereco.getCidade());
        model.setEstado(endereco.getEstado());
        model.setPais(endereco.getPais());
        model.setCep(endereco.getCep());
        model.setDataInclusao(endereco.getDataInclusao());
        model.setDataDelete(endereco.getDataDelete());
        model.setDataAtualizacao(endereco.getDataAtualizacao());
        model.setIsDeletado(endereco.getIsDelete());

        return model;
    }
}
