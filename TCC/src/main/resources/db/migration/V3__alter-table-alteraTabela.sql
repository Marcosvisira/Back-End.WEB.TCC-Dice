alter table dadosempresa drop column nome_fantasia;


ALTER TABLE dadosempresa
ADD status VARCHAR(255);

alter table usuarios
add role varchar(100) not null;