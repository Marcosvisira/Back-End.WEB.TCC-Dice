create table dadosempresa(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    nome_fantasia varchar(100),
    cnpj varchar(100) not null unique,
    logradouro varchar(100) not null,
    cidade varchar(100) not null,
    uf varchar(2) not null,
    cep varchar(9) not null,
    bairro varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),

    primary key(id)


);