CREATE PROCEDURE sp_ins_cliente(in id int(11),in lastName varchar(50),in name varchar(50), in mail varchar(50), in phoneNumber varchar(50))
     insert into clientes values(id,lastName,name,mail,phoneNumber);

CREATE PROCEDURE sp_upd_cliente(in id int(11),in lastName varchar(50),in name varchar(50), in mail varchar(50), in phoneNumber varchar(50))
     update clientes set apellidos=lastName, nombres=name, correo=mail, telefono=phoneNumber where idcliente=id;

CREATE PROCEDURE sp_del_cliente(in id int(11))
     delete from clientes where idcliente=id;

CREATE PROCEDURE sp_findAll_cliente()
     select * from clientes;

CREATE PROCEDURE sp_find_cliente(in id int(11))
     select * from clientes where idcliente=id;
