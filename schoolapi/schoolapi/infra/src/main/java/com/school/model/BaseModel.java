package com.school.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {

    @Column(name="dataAtualizacao")
    private LocalDate dataAtualizacao ;

    @Column(name="dataInclusao")
    private LocalDate dataInclusao;

    @Column(name="dataDelete")
    private LocalDate dataDelete;

    @Column(name="deletado")
    private Boolean isDeletado;
}
