package com.school.gateway;

import com.school.entidade.endereco.Endereco;

public interface ConsultarEnderecoGateway {

    Endereco consultarEndereco(Long cep);
}
