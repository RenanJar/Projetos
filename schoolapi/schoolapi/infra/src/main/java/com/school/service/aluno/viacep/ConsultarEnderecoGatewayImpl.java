package com.school.service.aluno.viacep;

import com.school.clientapi.ViaCepClient;
import com.school.dto.request.viacep.ViaCepResponse;
import com.school.entidade.endereco.Endereco;
import com.school.gateway.ConsultarEnderecoGateway;
import com.school.mapper.EnderecoMapper;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConsultarEnderecoGatewayImpl implements ConsultarEnderecoGateway {

    private ViaCepClient viaCepClient;
    private EnderecoMapper enderecoMapper;

    @Override
    public Endereco consultarEndereco(Long cep) {
        ViaCepResponse response = viaCepClient.getCEP(cep);
        enderecoMapper.toEndereco(response);
        return ;
    }

}
