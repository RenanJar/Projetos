package com.school.repositoryimpl;

import com.school.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaAlunoRepository extends JpaRepository<AlunoModel, UUID> {

}
