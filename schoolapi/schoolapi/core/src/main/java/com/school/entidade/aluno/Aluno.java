package com.school.entidade.aluno;

import com.school.entidade.Entity;
import com.school.entidade.endereco.Endereco;
import com.school.entidade.exceptions.DomainExceptions;
import com.school.entidade.exceptions.Notification;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class Aluno extends Entity {

    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Long numeroContato;
    private String email;

    public Aluno(
            UUID ID,
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email,
            LocalDateTime dataInclusao,
            LocalDateTime dataAtualizacao,
            LocalDateTime dataDelete,
            Boolean isDeleted
    ){
        super(ID,dataInclusao,dataAtualizacao,dataDelete,isDeleted);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.email = email;
        validate();
    }

    public Aluno(
            String nome,
            LocalDate dataNascimento,
            Endereco endereco,
            Long numeroContato,
            String email
    ){
        super(null,null,null,null,null);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroContato = numeroContato;
        this.email = email;
        validate();
    }

    public Aluno(){}

    public void validate(){
        Notification notification = new Notification();
        notification.add(()->{verifyStringError(nome,"Name");});
        notification.add(()->{verifyObjectError(dataNascimento,"Date of Birth");});
        notification.add(()->{verifyObjectError(endereco,"Adress");});
        notification.add(()->{verifyObjectError(numeroContato,"Contact number");});
        notification.add(()->{verifyStringError(email,"E-mail");});
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
            throw DomainExceptions.throwException(" Update date, Inclusion date or Delete date, not be null ","Aluno");
        }
   }

   private static void verifyStringError(String objects,String atributeName){
        if(objects == null || objects.isEmpty() || objects.isBlank()){
            throw DomainExceptions.throwException(atributeName+" not be null ","Aluno");
        }
   }

    private static <T> void verifyObjectError(T objects,String atributeName){
        if(objects == null){
            throw DomainExceptions.throwException(atributeName+" not be null ","Aluno");
        }
    }

}
