package com.school.entidade;

import com.school.entidade.exceptions.Notification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class Entity {
    protected UUID ID;
    protected LocalDate dataInclusao;
    protected LocalDate dataAtualizacao;
    protected LocalDate dataDelete;
    protected Boolean isDelete;
    protected Boolean isValid = false;
    protected List<Notification> notifications = new ArrayList<>();

    public Entity(UUID ID, LocalDate dataInclusao, LocalDate dataAtualizacao, LocalDate dataDelete, Boolean isDelete) {
        this.ID = ID;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.dataDelete = dataDelete;
        this.isDelete = isDelete;
    }
}
