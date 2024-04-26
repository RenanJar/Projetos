package com.school.aluno;

import com.school.entidade.aluno.Aluno;
import com.school.entidade.endereco.Endereco;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.UUID;

public class AlunoTest {

    String nome = "Rodolfo Elias";
    LocalDate dataNascimento = LocalDate.of(1996, 1,1);
    Endereco mockedEndereco = Mockito.mock(Endereco.class);
    Long numeroContato = 1112345678L;
    String email =  "rodolfo@Mail.com";

    @Test
    public void deveRetornarErroAoTentarCriarAlunoSemNome(){
        Assert.assertThrows(NullPointerException.class, ()->{
           Aluno novoAluno = Aluno.criarAluno(null,dataNascimento,mockedEndereco,numeroContato,email);
        });
    }

    @Test
    public void deveRetornarErroAoCriarSemDataDeNascimento(){
        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno novoAluno = Aluno.criarAluno(nome,null,mockedEndereco,numeroContato,email);
        });
    }

    @Test
    public void deveRetornarErroAoCriarSemEndereco(){
        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,null,numeroContato,email);
        });
    }

    @Test
    public void deveRetornarErroAoCriarSemNumeroContato(){
        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,null,email);
        });
    }

    @Test
    public void deveRetornarErroAoCriarSemEmail(){
        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,null);
        });
    }

    @Test
    public void deveCriarNovoAlunoSemErros(){
        Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        Assert.assertNotNull(novoAluno);
    }

    @Test
    public void deveExibirDataDeInclusaAoCriarAluno(){
        Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        LocalDate dataHoje =  LocalDate.now();
        Assert.assertEquals(dataHoje, novoAluno.getDataInclusao());
    }

    @Test
    public void deveRetornarAlunoNaoDeletado(){
        Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        Assert.assertFalse(novoAluno.getIsDelete());
    }

    @Test
    public void deveRetornarErroAoTentarAtualizarAlunoSemID(){
        Aluno alunoAtualizado = Aluno.criarAluno("Alan Oliveira",dataNascimento,mockedEndereco,numeroContato,email);
        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoTentarAtualizarAlunoSemNome(){
        UUID fakeID = UUID.randomUUID();
        Aluno alunoAtualizado = Aluno.criarAluno(null,dataNascimento,mockedEndereco,numeroContato,email);
        alunoAtualizado.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()->{
           Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveAtualizarNomeAluno(){
        UUID fakeID = UUID.randomUUID();
        Aluno alunoAtualizado = Aluno.criarAluno("Rodolfo Pirani",dataNascimento,mockedEndereco,numeroContato,email);
        alunoAtualizado.setID(fakeID);
        Assert.assertTrue(alunoAtualizado.getNome().equals("Rodolfo Pirani"));
    }

    @Test
    public void deveRetornarErroAoAtualizarSemDataDeNascimento(){
        UUID fakeID = UUID.randomUUID();
        Aluno alunoAtualizado = Aluno.criarAluno("Rodolfo Pirani",null,mockedEndereco,numeroContato,email);
        alunoAtualizado.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveAtualizarDataDeNascimento(){
        UUID fakeID = UUID.randomUUID();
        LocalDate dataAtualizada = LocalDate.of(2002,6,6);
        Aluno alunoAtualizado = Aluno.criarAluno("Rodolfo Pirani",dataAtualizada,mockedEndereco,numeroContato,email);
        alunoAtualizado.setID(fakeID);
        Assert.assertTrue(alunoAtualizado.getDataNascimento().equals(dataAtualizada));
    }

    @Test
    public void deveRetornarErroAoAtualizarSemEndereco(){
        UUID fakeID = UUID.randomUUID();
        Aluno alunoAtualizado = Aluno.criarAluno(nome,dataNascimento,null,numeroContato,email);
        alunoAtualizado.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()-> {
            Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarSemEmail(){
        Aluno alunoAtualizado = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,null);
        UUID fakeID = UUID.randomUUID();
        alunoAtualizado.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()-> {
            Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveAtualizarEmail(){
        UUID fakeID = UUID.randomUUID();
        String newEmail = "RodolfoEmail@gmail.com";
        Aluno aluno = Aluno.criarAluno("Rodolfo Pirani",dataNascimento,mockedEndereco,numeroContato,email);
        aluno.setID(fakeID);
        aluno.setEmail(newEmail);
        Aluno alunoAtualizado = Aluno.atualizarAluno(aluno);
        Assert.assertTrue(alunoAtualizado.getDataNascimento().equals(newEmail));
    }

    @Test
    public void deveAtualizarAlunoSemErros(){
        Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        Assert.assertNotNull(novoAluno);
    }

    @Test
    public void deveExibirDataDeAtualizacaoAluno(){
        Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        LocalDate dataHoje =  LocalDate.now();
        Assert.assertEquals(dataHoje, novoAluno.getDataInclusao());
    }

    @Test
    public void deveRetornarAlunoNaoDeletadoAoAtualizar(){
        Aluno novoAluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        Assert.assertFalse(novoAluno.getIsDelete());
    }

}
