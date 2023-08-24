create table tb_veiculo(
	id_veiculo bigint not null auto_increment,
    proprietario_id bigint not null,
    marca_veiculo varchar(20) not null,
    modelo_veiculo varchar(20) not null,
    placa_veiculo varchar(7) not null,
    status_veiculo varchar(20) not null,
    data_cadastro_veiculo datetime not null,
    data_apreensao_veiculo datetime,

    primary key (id_veiculo)
);

alter table tb_veiculo add constraint fk_veiculo_proprietario
foreign key (proprietario_id) references tb_proprietario (id_proprietario);

alter table tb_veiculo add constraint uk_tb_veiculo unique (placa_veiculo);