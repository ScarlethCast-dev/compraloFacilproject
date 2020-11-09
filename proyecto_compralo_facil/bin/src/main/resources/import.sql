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


/*Estado pedido*/
INSERT INTO t_estado_pedido(ts_created, ts_modified, usu_created, usu_modified, descripcion) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'En Bodega Guatemala');

/*Metodo Envio*/
INSERT INTO t_metodo_envio(ts_created, ts_modified, usu_created, usu_modified, descripcion) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 'A domicilio');

/*Producto*/

INSERT INTO t_productos(ts_created, ts_modified, usu_created, usu_modified, cantidad, descripcion, foto, nombre, precio) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe',10, 'Laptop', '', '', 3000);

/*Pedidos*/
INSERT INTO t_pedido(ts_created, ts_modified, usu_created, usu_modified, fecha_pedido, t_cliente_id, t_estado_pedido_id_estado_pedido, t_metodo_envio_id_metodo_envio, t_producto_id) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', '2020-01-01', '1', '1', '1', '1');


INSERT INTO t_detalle_pedido(ts_created, ts_modified, usu_created, usu_modified, cantidad, detalle_producto, link_producto, precio, id_pedido) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 1, 'Laptop', 'google.com', 5000, 1);
INSERT INTO t_detalle_pedido(ts_created, ts_modified, usu_created, usu_modified, cantidad, detalle_producto, link_producto, precio, id_pedido) values ('1999-12-31 23:59:59','1999-12-31 23:59:59','Jefe','Jefe', 1, 'RTX 3000', 'google.com', 3000, 1);
/*Usuarios*/
INSERT INTO `usuarios` (username, password, enabled) VALUES ('Diego','$2a$10$FaIiyLiDPQGeib68rNlfl.stch3cyY54g54/PPV/95QHIQzbnIuQq',1);
INSERT INTO `usuarios` (username, password, enabled) VALUES ('Admin','$2a$10$WxQu2py8fgu13NSRW608PecobtTYr4BOy10USEANXt8WFOBv5/Bf6',1);

INSERT INTO `authorities` (id_usuario, authority) values (1, 'ROLE_USER');
INSERT INTO `authorities` (id_usuario, authority) values (2, 'ROLE_ADMIN');

