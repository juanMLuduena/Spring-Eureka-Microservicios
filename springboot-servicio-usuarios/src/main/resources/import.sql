INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('wachiwonga', '1234', 1, 'Juan','Ludu','jmludu@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('raukomallen', '12345', 1, 'Bianca','Pile','bpilegi@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);