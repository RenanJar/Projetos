package com.school.mapper;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.dto.response.CadastrarAlunoResponse;
import com.school.dto.response.ConsultarAlunoResponse;
import com.school.dto.response.EnderecoResponse;
import com.school.entidade.aluno.Aluno;
import com.school.entidade.endereco.Endereco;
import com.school.model.AlunoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Aluno_Mapper {

    @Mapping(source = "nome",target = "nome")
    @Mapping(source = "dataNascimento",target = "dataNascimento")
    @Mapping(source = "endereco",target = "endereco")
    @Mapping(source = "numeroContato",target = "numeroContato")
    @Mapping(source = "email",target = "email")
    Aluno toAluno(CadastrarAlunoRequest request);

    @Mapping(source = "nome",target = "nome")
    @Mapping(source = "dataNascimento",target = "dataNascimento")
    @Mapping(source = "endereco",target = "endereco")
    @Mapping(source = "numeroContato",target = "numeroContato")
    @Mapping(source = "email",target = "email")
    Aluno toAluno(AlunoModel model);

    @Mapping(source = "nome",target = "nome")
    @Mapping(source = "dataNascimento",target = "dataNascimento")
    @Mapping(source = "endereco",target = "endereco")
    @Mapping(source = "numeroContato",target = "numeroContato")
    @Mapping(source = "email",target = "email")
    @Mapping(source = "dataInclusao",target = "dataInclusao")
    @Mapping(source = "dataAtualizacao",target = "dataAtualizacao")
    @Mapping(source = "dataDelete",target = "dataDelete")
    AlunoModel toModel(Aluno entity);

    @Mapping(source = "nome",target = "nome")
    @Mapping(source = "dataNascimento",target = "dataNascimento")
    @Mapping(source = "endereco",target = "endereco")
    @Mapping(source = "numeroContato",target = "numeroContato")
    @Mapping(source = "email",target = "email")
    CadastrarAlunoResponse toCadastrarResponse(Aluno entity);

    ConsultarAlunoResponse toConsultarResponse(Aluno entity);

    default EnderecoResponse map(Endereco endereco){
        Endereco_Mapper mapper = Mappers.getMapper(Endereco_Mapper.class);
        return mapper.toResponse(endereco);
    }
}
