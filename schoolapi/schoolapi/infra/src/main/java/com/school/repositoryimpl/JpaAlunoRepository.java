package com.school.repositoryimpl;

import com.school.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAlunoRepository extends JpaRepository<AlunoModel, UUID> {

}
