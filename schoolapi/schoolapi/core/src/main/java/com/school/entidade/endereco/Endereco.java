package com.school.entidade.endereco;

import com.school.entidade.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco extends Entity {

    private String rua;
    private Long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private CEP cep;

    private Endereco(
            String rua,
            Long numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String pais,
            CEP cep
    ){
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
    }


}
