package com.school.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.entidade.endereco.Endereco;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.UUID;


public class EnderecoTest {

    String logradouro = "Rua Marcelo";
    Long numero = 132l;
    String complemento = "apartamento";
    String bairro = "Jardim Michele";
    String cidade = "Macarenas";
    String estado = "Pernambuco";
    String pais = "Brasil";
    Long cep = 05000320l;

    @Test
    public void naoDeveLancarErros_QuandoAEntidadeEstiverCorreta() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setPais(pais);
        endereco.setCep(cep);
        endereco.validate();

        Assert.assertNotNull(endereco);
    }

    @Test
    public void DeveLancarErros_QuandoAEntidadeEstiverErrada() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouro);
        endereco.setNumero(numero);
        endereco.setComplemento(complemento);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setPais(null);
        endereco.setCep(null);

        try {
            endereco.validate();
        } catch (RuntimeException error) {
            Assert.assertEquals("[DOMAIN_Endereco: Pais not be null , DOMAIN_Endereco: Cep not be null ]", error.getMessage());
        }
    }
}
