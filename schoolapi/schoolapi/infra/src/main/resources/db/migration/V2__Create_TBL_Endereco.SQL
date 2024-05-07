CREATE TABLE TBL_ENDERECO (
    enderecoID varchar(255) PRIMARY KEY,
    logradouro varchar(255),
    numero numeric(9),
    complemento varchar(255),
    bairro varchar(255),
    cidade varchar(255),
    estado varchar(2),
    pais varchar(255),
    cep numeric(8),
    dataAtualizacao timestamp,
    dataInclusao timestamp,
    dataDelete timestamp,
    deletado boolean
);