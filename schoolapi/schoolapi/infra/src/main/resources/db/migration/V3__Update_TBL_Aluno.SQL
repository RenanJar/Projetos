ALTER TABLE TBL_ALUNO
ADD dataNascimento date,
ADD endereco_id varchar(255),
ADD CONSTRAINT fk_endereco_id FOREIGN KEY(endereco_id) REFERENCES TBL_Endereco(enderecoID),
ADD numeroContato numeric,
ADD email varchar(255),
ADD dataAtualizacao timestamp,
ADD dataInclusao timestamp,
ADD dataDelete timestamp,
ADD deletado boolean;