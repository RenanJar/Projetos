package com.school.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="TBL_ENDERECO")
public class EnderecoModel extends BaseModel{

    @Id
    @Column(name = "enderecoid")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ID;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @Column(name = "cep")
    private Long cep;

    public EnderecoModel(LocalDateTime dataAtualizacao, LocalDateTime dataInclusao, LocalDateTime dataDelete, Boolean isDeletado, UUID ID, String logradouro, Long numero, String complemento, String bairro, String cidade, String estado, Long cep, String pais) {
        super(dataAtualizacao, dataInclusao, dataDelete, isDeletado);
        this.ID = ID;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
    }

    public EnderecoModel() {
        super();
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
