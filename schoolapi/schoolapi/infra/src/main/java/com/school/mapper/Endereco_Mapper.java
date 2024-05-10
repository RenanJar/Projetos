package com.school.mapper;

import com.school.dto.response.EnderecoResponse;
import com.school.entidade.endereco.Endereco;
import com.school.model.EnderecoModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Endereco_Mapper {

    @Mapping(source = "ID",target = "ID")
    @Mapping(source = "logradouro",target = "logradouro")
    @Mapping(source = "numero",target = "numero")
    @Mapping(source = "complemento",target = "complemento")
    @Mapping(source = "bairro",target = "bairro")
    @Mapping(source = "cidade",target = "cidade")
    @Mapping(source = "pais",target = "pais")
    @Mapping(source = "cep",target = "cep")
    EnderecoResponse toResponse(Endereco entity);

    @Mapping(target = "ID", source = "ID")
    @Mapping(target = "logradouro", source = "logradouro")
    @Mapping(target = "numero", source = "numero")
    @Mapping(target = "complemento", source = "complemento")
    @Mapping(target = "bairro", source = "bairro")
    @Mapping(target = "cidade", source = "cidade")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "pais", source = "pais")
    @Mapping(target = "cep", source = "cep")
    EnderecoModel toModel(Endereco endereco);

    @Mapping(target = "ID", source = "ID")
    @Mapping(target = "logradouro", source = "logradouro")
    @Mapping(target = "numero", source = "numero")
    @Mapping(target = "complemento", source = "complemento")
    @Mapping(target = "bairro", source = "bairro")
    @Mapping(target = "cidade", source = "cidade")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "pais", source = "pais")
    @Mapping(target = "cep", source = "cep")
    @Mapping(target = "isDelete", source = "isDeletado")
    Endereco toEntity(EnderecoModel enderecoModel);
}
