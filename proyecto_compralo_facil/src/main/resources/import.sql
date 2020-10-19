/*Clientes*/
INSERT INTO t_clientes(ts_created, ts_modified, usu_created, usu_modified, nombre, apellido, dpi, fecha_nacimiento, telefono, nit, correo, foto) VALUES ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe','Diego', 'Raymundo', 123, '2020-01-01', '12345678', '12345', 'tucorreo@email.com', '');
INSERT INTO t_clientes(ts_created, ts_modified, usu_created, usu_modified, nombre, apellido, dpi, fecha_nacimiento, telefono, nit, correo, foto) VALUES ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe','Mynor', 'Solis', 123, '2020-01-01', '12345678', '12345', 'tucorreo@email.com', '');
INSERT INTO t_clientes(ts_created, ts_modified, usu_created, usu_modified, nombre, apellido, dpi, fecha_nacimiento, telefono, nit, correo, foto) VALUES ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe','Marvin', 'Morales', 123, '2020-01-01', '12345678', '12345', 'tucorreo@email.com', '');
INSERT INTO t_clientes(ts_created, ts_modified, usu_created, usu_modified, nombre, apellido, dpi, fecha_nacimiento, telefono, nit, correo, foto) VALUES ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe','Werner', 'Us', 123, '2020-01-01', '12345678', '12345', 'tucorreo@email.com', '');
INSERT INTO t_clientes(ts_created, ts_modified, usu_created, usu_modified, nombre, apellido, dpi, fecha_nacimiento, telefono, nit, correo, foto) VALUES ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe','Scarleth', 'Mendez', 123, '2020-01-01', '12345678', '12345', 'tucorreo@email.com', '');


/*Municipios*/
INSERT INTO t_municipio(ts_created, ts_modified, usu_created, usu_modified, nombre_municipio) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Nebaj');
INSERT INTO t_municipio(ts_created, ts_modified, usu_created, usu_modified, nombre_municipio) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Aguacatan');
INSERT INTO t_municipio(ts_created, ts_modified, usu_created, usu_modified, nombre_municipio) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Huehetenango');
INSERT INTO t_municipio(ts_created, ts_modified, usu_created, usu_modified, nombre_municipio) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Uspantan');
INSERT INTO t_municipio(ts_created, ts_modified, usu_created, usu_modified, nombre_municipio) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Ixtahuacan');

/*Departamento*/

INSERT INTO t_departamento(ts_created, ts_modified, usu_created, usu_modified, nombre_depart) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Quiche');
INSERT INTO t_departamento(ts_created, ts_modified, usu_created, usu_modified, nombre_depart) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'Huehuetenango');

/*Direcciones clientes*/

INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 1 2-2', 'null', 1, 1, 1);
INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 2 2-2', 'null', 1, 1, 1);

INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 3 2-2', 'null', 2, 2, 2);
INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 4 2-2', 'null', 2, 2, 2);

INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 5 2-2', 'null', 2, 3, 3);
INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 6 2-2', 'null', 2, 3, 3);

INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 7 2-2', 'null', 1, 4, 4);
INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 8 2-2', 'null', 1, 4, 4);

INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 9 2-2', 'null', 2, 5, 5);
INSERT INTO t_direcciones(ts_created, ts_modified, usu_created, usu_modified, codigo_postal, desc_direccion, cliente_id, departamento_id, municipio_id, t_cliente_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '14013', 'Zona 10 2-2', 'null', 2, 5, 5);

