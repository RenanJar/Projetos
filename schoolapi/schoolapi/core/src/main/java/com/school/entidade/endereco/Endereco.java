package com.school.entidade.endereco;

import com.school.entidade.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Endereco extends Entity {

    private String logradouro;
    private Long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private Long cep;

    private Endereco(
            UUID id,
            String logradouro,
            Long numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String pais,
            Long cep,
            LocalDate dataInclusao,
            LocalDate dataAtualizacao,
            LocalDate dataDelete,
            Boolean isDeleted
    ){
        this.ID = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cep = cep;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.dataDelete = dataDelete;
        this.isDelete = isDeleted;
    }

    private Endereco(){}
    public static Endereco criarEndereco(
            String logradouro,
            Long numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String pais,
            Long cep
    ){
        LocalDate dataHoje = LocalDate.now();

        Endereco novoEndereco = new Endereco(
                null,
                logradouro,
                numero,
                complemento,
                bairro,
                cidade,
                estado,
                pais,
                cep,
                dataHoje,
                null,
                null,
                false
        );

        return validarCriarEndereco(novoEndereco);
    }

    public static Endereco atualizarEndereco(Endereco enderecoAtual, Endereco enderecoParaAtualizar) {
        LocalDate dataAtualizada = LocalDate.now();
        enderecoAtual.setLogradouro(enderecoParaAtualizar.getLogradouro());
        enderecoAtual.setNumero(enderecoParaAtualizar.getNumero());
        enderecoAtual.setComplemento(enderecoParaAtualizar.getComplemento());
        enderecoAtual.setBairro(enderecoParaAtualizar.getBairro());
        enderecoAtual.setCidade(enderecoParaAtualizar.getCidade());
        enderecoAtual.setEstado(enderecoParaAtualizar.getEstado());
        enderecoAtual.setPais(enderecoParaAtualizar.getPais());
        enderecoAtual.setCep(enderecoParaAtualizar.getCep());
        enderecoAtual.setDataAtualizacao(LocalDate.now());
        enderecoAtual.setIsDelete(false);

        return validarAtualizarEndereco(enderecoAtual);
    }

    public static Endereco deletarEndereco(Endereco endereco) {
        validarId(endereco.getID());
        endereco.setIsDelete(true);
        endereco.setDataDelete(LocalDate.now());
        return endereco;
    }

    public static Endereco validarAtualizarEndereco(Endereco endereco) {
        validarId(endereco.getID());
        validarLogradouro(endereco.getLogradouro());
        validarNumero(endereco.getNumero());
        validarComplemento(endereco.getComplemento());
        validarBairro(endereco.getBairro());
        validarCidade(endereco.getCidade());
        validarEstado(endereco.getEstado());
        validarPais(endereco.getPais());
        validarCep(endereco.getCep());
        return endereco;
    }

    private static Endereco validarCriarEndereco(Endereco endereco){
        validarLogradouro(endereco.getLogradouro());
        validarNumero(endereco.getNumero());
        validarComplemento(endereco.getComplemento());
        validarBairro(endereco.getBairro());
        validarCidade(endereco.getCidade());
        validarEstado(endereco.getEstado());
        validarPais(endereco.getPais());
        validarCep(endereco.getCep());
        return endereco;
    }

    private static void validarId(UUID id){
        Objects.requireNonNull(id,"ID nao pode ser vazio");
    }

    private static void validarLogradouro(String logradouro){
        Objects.requireNonNull(logradouro,"Rua nao pode ser vazio");
    }

    private static void validarNumero(Long numero){
        Objects.requireNonNull(numero,"Endereco deve conter um numero");
    }

    private static void validarComplemento(String complemento){
        Objects.requireNonNull(complemento,"Complemento nao pode ser vazio");
    }

    private static void validarBairro(String bairro){
        Objects.requireNonNull(bairro,"Bairro nao pode ser vazio");
    }

    private static void validarCidade(String cidade){
        Objects.requireNonNull(cidade,"Cidade nao pode ser vazio");
    }

    private static void validarEstado(String estado){
        Objects.requireNonNull(estado,"Estado nao pode ser vazio");
    }

    private static void validarPais(String pais){
        Objects.requireNonNull(pais,"Pais nao pode ser vazio");
    }

    private static void validarCep(Long cep){
        Objects.requireNonNull(cep,"Cep nao pode ser vazio");
    }

}
