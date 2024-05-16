package com.school.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.entidade.endereco.Endereco;
import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AlunoTest {

    String nome = "Rodolfo Elias";
    LocalDate dataNascimento = LocalDate.of(1996, 1,1);
    Endereco mockedEndereco = Mockito.mock(Endereco.class);
    Long numeroContato = 1112345678L;
    String email =  "rodolfo@Mail.com";

    @Test
    public void whenCallingTheConstructor_itShouldNotThrowException(){

        Aluno aluno = new Aluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        assertTrue(aluno.getNome().equals(nome));
        assertTrue(aluno.getDataNascimento().equals(dataNascimento));
        assertTrue(aluno.getEndereco().equals(mockedEndereco));
        assertTrue(aluno.getNumeroContato().equals(numeroContato));
        assertTrue(aluno.getEmail().equals(email));
    }

    @Test
    public void whenCallingTheConstructor_ifOneAtributeIsNull_then_ThrowException(){
        try{
            new Aluno(nome,null,mockedEndereco,null,email);
        }catch (RuntimeException e){
            assertEquals("[DOMAIN_Aluno: Date of Birth not be null , DOMAIN_Aluno: Contact number not be null ]",e.getMessage());
        }
    }

    @Test
    public void whenCallingTheConstructor_ifidIsPresentAndDateControlsnotExists_then_ThrowException(){
        try{
            UUID id = UUID.randomUUID();
            new Aluno(id,nome,dataNascimento,mockedEndereco,numeroContato,email,null,null,null,null);
        }catch (RuntimeException e){
            assertEquals("[DOMAIN_Aluno:  Update date, Inclusion date or Delete date, not be null ]",e.getMessage());
        }
    }

    @Test
    public void whenCallingTheConstructor_ifIdIsPresentAndDateControlsExists_then_itShouldNotThrowException(){
        UUID id = UUID.randomUUID();
        LocalDateTime dataIncl = LocalDateTime.now();
        try{
            Aluno alunoExpect = new Aluno(id,nome,dataNascimento,mockedEndereco,numeroContato,email,dataIncl,null,null,null);
            assertEquals(dataIncl,alunoExpect.getDataInclusao());
        }catch (Exception e){
            e.getMessage();
        }
    }

}
