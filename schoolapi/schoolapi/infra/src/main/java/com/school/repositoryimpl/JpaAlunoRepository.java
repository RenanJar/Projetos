package com.school.repositoryimpl;

import com.school.entidade.Aluno;
import com.school.model.AlunoModel;
import com.school.repository.AlunoRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAlunoRepository extends JpaRepository<AlunoModel, UUID> {

}
