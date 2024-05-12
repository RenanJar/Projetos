package com.school.entidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Entity {
    protected UUID ID;
    protected LocalDate dataInclusao;
    protected LocalDate dataAtualizacao;
    protected LocalDate dataDelete;
    protected Boolean isDelete;
}
