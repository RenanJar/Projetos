package com.school.controler.aluno;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.entidade.Aluno;
import com.school.mapper.AlunoMapper;
import com.school.usecaseinterface.aluno.CadastrarNovoAluno;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/aluno")
public class AlunoController {

    private CadastrarNovoAluno cadastrarNovoAluno;

    private AlunoMapper alunoMapper;

    public AlunoController(CadastrarNovoAluno cadastrarNovoAluno, AlunoMapper alunoMapper) {
        this.cadastrarNovoAluno = cadastrarNovoAluno;
        this.alunoMapper = alunoMapper;
    }

    @PostMapping("/cadastrar")
    ResponseEntity<Aluno> cadastrar(CadastrarAlunoRequest request){
        Aluno alunoCadastrado = cadastrarNovoAluno.cadastrar(alunoMapper.toAluno(request));
        return ResponseEntity.ok(alunoCadastrado);
    }
}
