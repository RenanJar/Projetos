package com.school.entidade;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Entity {
    protected UUID ID;
    protected LocalDate dataInclusao;
    protected LocalDate dataAtualizacao;
    protected LocalDate dataDelete;
    protected Boolean isDelete;
}

