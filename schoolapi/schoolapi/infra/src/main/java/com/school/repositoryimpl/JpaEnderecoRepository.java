package com.school.repositoryimpl;

import com.school.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaEnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
}
