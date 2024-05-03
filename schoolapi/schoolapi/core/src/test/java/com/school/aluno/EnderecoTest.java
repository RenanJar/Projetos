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

    // validação criar
    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemLogradouro() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(null, numero, complemento, bairro, cidade, estado, pais, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemNumero() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, null, complemento, bairro, cidade, estado, pais, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemComplemento() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, numero, null, bairro, cidade, estado, pais, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemBairro() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, numero, complemento, null, cidade, estado, pais, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemCidade() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, numero, complemento, bairro, null, estado, pais, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemEstado() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, numero, complemento, bairro, cidade, null, pais, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemPais() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, numero, complemento, bairro, cidade, estado, null, cep);
        });
    }

    @Test
    public void deveRetornarErroAoTentarCriarEnderecoSemCep() {
        Assert.assertThrows(NullPointerException.class, ()->{
            Endereco novoEndereco = Endereco.criarEndereco(logradouro, numero, complemento, bairro, cidade, estado, pais, null);
        });
    }

    // validação atualizar

    public Endereco criarNovoEndereco(){
        UUID fakeID = UUID.randomUUID();
        Endereco endereco = Endereco.criarEndereco(logradouro,numero,complemento,bairro,cidade,estado,pais,cep);
        endereco.setID(fakeID);
        return endereco;
    }

    @Test public void deveRetornarErroAoTentarAtualizarEnderecoSemID() {
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);
        enderecoAtualizado.setID(null);

        Assert.assertThrows(NullPointerException.class, () -> {
            Endereco.atualizarEndereco(enderecoAtual, enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoTentarAtualizarEnderecoSemLogradouro(){
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setLogradouro(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemNumero(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setNumero(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemComplemento(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setComplemento(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemBairro(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setBairro(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemCidade(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setCidade(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemEstado(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setEstado(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemPais(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setPais(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    @Test
    public void deveRetornarErroAoAtualizarEnderecoSemCep(){
        UUID fakeID = UUID.randomUUID();
        Endereco enderecoAtualizado = criarNovoEndereco();
        Endereco enderecoAtual = criarNovoEndereco();
        enderecoAtual.setID(null);
        enderecoAtualizado.setID(fakeID);

        Assert.assertThrows(NullPointerException.class, ()->{
            enderecoAtualizado.setCep(null);
            Endereco.atualizarEndereco(enderecoAtual ,enderecoAtualizado);
        });
    }

    // validação deletar

    @Test
    public void deveRetornarErroQuandoDeletarEnderecoSemID(){
        Endereco endereco = criarNovoEndereco();
        endereco.setID(null);
        Assert.assertThrows(NullPointerException.class, ()-> {
            Endereco.deletarEndereco(endereco);
        });
    }

    @Test
    public void deveSetarEnderecoIsDeletedToTrue(){
        UUID fakeID = UUID.randomUUID();
        Endereco endereco = criarNovoEndereco();
        endereco.setID(fakeID);

        Endereco enderecoDeletado = Endereco.deletarEndereco(endereco);
        Assert.assertTrue(enderecoDeletado.getIsDelete());
    }

    @Test
    public void deveAprensentarDataExclusao(){
        UUID fakeID = UUID.randomUUID();
        Endereco endereco = criarNovoEndereco();
        endereco.setID(fakeID);

        Endereco enderecoDeletado = Endereco.deletarEndereco(endereco);

        Assert.assertTrue(enderecoDeletado.getDataDelete().equals(LocalDate.now()));
    }
}
