package com.school.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {

    private String ID;
    private String logradouro;
    private Long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private Long cep;
}
