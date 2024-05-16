package com.school.entidade;

import com.school.entidade.exceptions.Notification;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public abstract class Entity {
    protected UUID ID;
    protected LocalDateTime dataInclusao;
    protected LocalDateTime dataAtualizacao;
    protected LocalDateTime dataDelete;
    protected Boolean isDelete;

    public Entity(UUID ID, LocalDateTime dataInclusao, LocalDateTime dataAtualizacao, LocalDateTime dataDelete, Boolean isDelete) {
        this.ID = ID;
        this.dataInclusao = dataInclusao;
        this.dataAtualizacao = dataAtualizacao;
        this.dataDelete = dataDelete;
        this.isDelete = isDelete;
    }
}
