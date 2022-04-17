create table usuario(
 id_usuario int auto_increment primary key,
 nome_usuario varchar(45) unique,
 senha_usuario varchar(16)
);
alter table usuario add column tipo_usuario varchar(8);