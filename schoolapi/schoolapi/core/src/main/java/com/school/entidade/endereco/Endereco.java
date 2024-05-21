package com.school.entidade.endereco;

import com.school.entidade.Entity;
import com.school.entidade.exceptions.DomainExceptions;
import com.school.entidade.exceptions.Notification;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Setter
@Getter
public class Endereco extends Entity {

    private String logradouro;
    private Long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private Long cep;

    public Endereco(
            UUID ID,
            String logradouro,
            Long numero,
            String complemento,
            String bairro,
            String cidade,
            String estado,
            String pais,
            Long cep,
            LocalDateTime dataInclusao,
            LocalDateTime dataAtualizacao,
            LocalDateTime dataDelete,
            Boolean isDelete
    ){
        this.ID = ID;
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
        this.isDelete = isDelete;
    }

    public Endereco(){}

    public void validate(){
        Notification notification = new Notification();
        notification.add(()->{verifyStringError(logradouro,"Logradouro");});
        notification.add(()->{verifyObjectError(numero,"Numero");});
        notification.add(()->{verifyStringError(complemento,"Complemento");});
        notification.add(()->{verifyStringError(bairro,"Bairro");});
        notification.add(()->{verifyStringError(cidade,"Cidade");});
        notification.add(()->{verifyStringError(estado,"Estado");});
        notification.add(()->{verifyStringError(pais,"Pais");});
        notification.add(()->{verifyObjectError(cep,"Cep");});
        notification.add(()->{validateControlData();});
        notification.dispatch();
    }

    private void validateControlData(){

        if(
                super.ID != null &&
                        super.dataAtualizacao == null &&
                        super.dataInclusao == null &&
                        super.dataDelete == null
        ){
            throw DomainExceptions.throwException(" Update date, Inclusion date or Delete date, not be null ","Endereco");
        }
    }
    private static void verifyStringError(String objects,String atributeName){
        if(objects == null || objects.isEmpty() || objects.isBlank()){
            throw DomainExceptions.throwException(atributeName+" not be null ","Endereco");
        }
    }

    private static <T> void verifyObjectError(T objects,String atributeName){
        if(objects == null){
            throw DomainExceptions.throwException(atributeName+" not be null ","Endereco");
        }
    }
}
