create table tb_proprietario(
	id_proprietario bigint not null auto_increment,
    nome_proprietario varchar(100) not null,
    email_proprietario varchar(255) not null,
    telefone_proprietario varchar(20) not null,

    primary key (id_proprietario)
);

alter table tb_proprietario
add constraint uk_tb_proprietario unique (email_proprietario);