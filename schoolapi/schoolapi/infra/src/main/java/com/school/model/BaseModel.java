package com.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseModel {

    @Column(name="dataatualizacao")
    private LocalDateTime dataAtualizacao ;

    @Column(name="datainclusao")
    private LocalDateTime dataInclusao;

    @Column(name="datadelete")
    private LocalDateTime dataDelete;

    @Column(name="deletado")
    private Boolean isDeletado;
}
