package com.school.controler.aluno;

import com.school.dto.request.CadastrarAlunoRequest;
import com.school.dto.response.CadastrarAlunoResponse;
import com.school.dto.response.ConsultarAlunoResponse;
import com.school.service.aluno.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;

    @PostMapping("/cadastrar")
    ResponseEntity<CadastrarAlunoResponse> cadastrar(@RequestBody CadastrarAlunoRequest request) {
        return ResponseEntity.ok(alunoService.cadastrarNovoAluno(request));
    }

    @GetMapping("/consultar/{ID}")
    ResponseEntity<ConsultarAlunoResponse> consultar(@RequestParam String id) {
        return ResponseEntity.ok(alunoService.consultarAluno(id));
    }

}
