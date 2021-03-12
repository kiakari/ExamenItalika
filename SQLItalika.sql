use italika;
create table productos(
id int primary key not null identity,
sku varchar(255)not null,
fert varchar(255) not null,
modelo varchar(255) not null,
tipo varchar(20) not null,
numeroserie varchar(255) not null,
fecha datetime not null);

create table tipos(
id int primary key not null identity,
tipo varchar (20)not null);

insert into tipos(tipo) values('CHOPPER'),('DEPORTIVA'),('INFANTIL'),('TRABAJO');

insert into productos(sku,fert,modelo,tipo,numeroserie,fecha) values
('TA12345678','FERTT1','AT110','TRABAJO','T123456', GETDATE()),
('TA12345679','FERTT2','AT125','TRABAJO','T223456', GETDATE()),
('TF12345678','FERTT3','FT115','TRABAJO','T323456', GETDATE()),
('TF12345679','FERTT4','FT125','TRABAJO','T423456', GETDATE()),
('TG12345678','FERTT5','FT150GTS','TRABAJO','T523456', GETDATE()),
('DT12345678','FERTD1','RT200','DEPORTIVA','D123456', GETDATE()),
('DT12345679','FERTD2','RT250','DEPORTIVA','D223456', GETDATE()),
('IA12345678','FERTI1','ATV150','INFANTIL','I123456', GETDATE()),
('IA12345679','FERTI2','ATV180','INFANTIL','I223456', GETDATE()),
('IA12345681','FERTI3','ATV200','INFANTIL','I323456', GETDATE()),
('IA12345682','FERTI4','ATV250','INFANTIL','I423456', GETDATE());

CREATE PROCEDURE todos
AS 
BEGIN
 SELECT * FROM productos
END

CREATE PROCEDURE modelo @model varchar(255)
AS 
BEGIN
 SELECT * FROM productos where modelo=@model
END

CREATE PROCEDURE sku @sku varchar(255)
AS 
BEGIN
 SELECT * FROM productos where sku like '%'+@sku+'%'
END

CREATE PROCEDURE todostipos
AS 
BEGIN
 SELECT * FROM tipos
END


CREATE PROCEDURE eliminarproducto @id int
AS 
BEGIN
 delete FROM productos where id=@id
END

CREATE PROCEDURE insertarproducto @sku varchar(255), @fert varchar(255),@modelo varchar(255), @tipo varchar(20), @numeroserie varchar(255),@fecha datetime
AS 
BEGIN
 insert into productos(sku,fert,modelo,tipo,numeroserie,fecha) values(@sku,@fert,@modelo,@tipo,@numeroserie,@fecha)
END


CREATE PROCEDURE actualizarproducto @id int, @sku varchar(255), @fert varchar(255),@modelo varchar(255), @tipo varchar(20), @numeroserie varchar(255),@fecha datetime
AS 
BEGIN
 update productos set sku=@sku, fert=@fert,modelo=@modelo,tipo=@tipo,numeroserie=@numeroserie,fecha=@fecha where id=@id
END
