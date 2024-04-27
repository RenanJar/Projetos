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

    public Aluno criarNovoAluno(){
        UUID fakeID = UUID.randomUUID();
        Aluno aluno = Aluno.criarAluno(nome,dataNascimento,mockedEndereco,numeroContato,email);
        aluno.setID(fakeID);
        return aluno;
    }

    @Test
    public void deveRetornarErroAoTentarAtualizarAlunoSemID(){
        Aluno alunoAtualizado = criarNovoAluno();
        alunoAtualizado.setID(null);
        Assert.assertThrows(NullPointerException.class, ()->{
            Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoTentarAtualizarAlunoSemNome(){
        Aluno aluno = criarNovoAluno();

        Assert.assertThrows(NullPointerException.class, ()->{
            aluno.trocarNome(null);
            Aluno.atualizarAluno(aluno);
        });
    }

    @Test
    public void deveAtualizarNomeAluno(){
        Aluno aluno = criarNovoAluno();
        aluno.trocarNome("Rodolfo Pirani");
        Aluno alunoAtualizado = Aluno.atualizarAluno(aluno);
        Assert.assertTrue(alunoAtualizado.getNome().equals("Rodolfo Pirani"));
    }

    @Test
    public void deveRetornarErroAoAtualizarSemDataDeNascimento(){
        UUID fakeID = UUID.randomUUID();
        Aluno aluno = criarNovoAluno();
        aluno.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()->{
            aluno.trocarDataNascimento(null);
            Aluno.atualizarAluno(aluno);
        });
    }

    @Test
    public void deveAtualizarDataDeNascimento(){
        UUID fakeID = UUID.randomUUID();
        LocalDate dataAtualizada = LocalDate.of(2002,6,6);

        Aluno aluno = criarNovoAluno();
        aluno.trocarDataNascimento(dataAtualizada);
        aluno.setID(fakeID);

        Aluno alunoAtualizado = Aluno.atualizarAluno(aluno);
        Assert.assertTrue(alunoAtualizado.getDataNascimento().equals(dataAtualizada));
    }

    @Test
    public void deveRetornarErroAoAtualizarSemEndereco(){
        UUID fakeID = UUID.randomUUID();
        Aluno alunoAtualizado = criarNovoAluno();
        alunoAtualizado.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()-> {
            alunoAtualizado.trocarEndereco(null);
            Aluno.atualizarAluno(alunoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarSemEmail(){
        Aluno aluno = criarNovoAluno();
        UUID fakeID = UUID.randomUUID();
        aluno.setID(fakeID);


        Assert.assertThrows(NullPointerException.class, ()-> {
            aluno.trocarEmail(null);
            Aluno.atualizarAluno(aluno);
        });
    }

    @Test
    public void deveAtualizarEmail(){
        UUID fakeID = UUID.randomUUID();
        String newEmail = "RodolfoEmail@gmail.com";
        Aluno aluno = criarNovoAluno();
        aluno.setID(fakeID);
        aluno.trocarEmail(newEmail);

        Aluno alunoAtualizado = Aluno.atualizarAluno(aluno);
        Assert.assertTrue(alunoAtualizado.getEmail().equals(newEmail));
    }

    @Test
    public void deveExibirDataDeAtualizacaoAluno(){
        UUID fakeID = UUID.randomUUID();
        Aluno aluno = criarNovoAluno();
        LocalDate dataHoje =  LocalDate.now();
        aluno.setID(fakeID);

        Aluno alunoatualziado = Aluno.atualizarAluno(aluno);
        Assert.assertEquals(dataHoje, alunoatualziado.getDataAtualizacao());
    }

    @Test
    public void deveRetornarAlunoNaoDeletadoAoAtualizar(){
        Aluno aluno = criarNovoAluno();
        Aluno alunoatualizado = Aluno.atualizarAluno(aluno);
        Assert.assertFalse(alunoatualizado.getIsDelete());
    }

    @Test
    public void deveRetornarErroQuandoDeletarAlunoSemID(){
        Aluno aluno = criarNovoAluno();
        aluno.setID(null);
        Assert.assertThrows(NullPointerException.class, ()-> {
            Aluno.deletarAluno(aluno);
        });
    }

    @Test
    public void deveSetarIsDeletedToTrue(){
        UUID fakeID = UUID.randomUUID();
        Aluno aluno = criarNovoAluno();
        aluno.setID(fakeID);

        Aluno alunoDeletado = Aluno.deletarAluno(aluno);
        Assert.assertTrue(alunoDeletado.getIsDelete());
    }

    @Test
    public void deveAprensentarDataExclusao(){
        UUID fakeID = UUID.randomUUID();
        Aluno aluno = criarNovoAluno();
        aluno.setID(fakeID);

        Aluno alunoDeletado = Aluno.deletarAluno(aluno);

        Assert.assertTrue(alunoDeletado.getDataDelete().equals(LocalDate.now()));
    }

}
