-- Insertar datos en la tabla de la base de datos con personajes de Dragon Ball Z
INSERT INTO usuarios (id_usuario, usuario, nombre, email, clave) VALUES (1, 'goku', 'Son Goku', 'goku@dbz.com', 'goku123');
INSERT INTO usuarios (id_usuario, usuario, nombre, email, clave) VALUES (2, 'vegeta', 'Vegeta', 'vegeta@dbz.com', 'vegeta123');
INSERT INTO usuarios (id_usuario, usuario, nombre, email, clave) VALUES (3, 'gohan', 'Son Gohan', 'gohan@dbz.com', 'gohan123');
INSERT INTO usuarios (id_usuario, usuario, nombre, email, clave) VALUES (4, 'trunks', 'Trunks', 'trunks@dbz.com', 'trunks123');
INSERT INTO usuarios (id_usuario, usuario, nombre, email, clave) VALUES (5, 'goten', 'Goten', 'goten@dbz.com', 'goten123');
INSERT INTO usuarios (id_usuario, usuario, nombre, email, clave) VALUES (6, 'piccolo', 'Piccolo',  'piccolo@dbz.com', 'piccolo123');

-- Insertar datos en la tabla de cuentas de la base de datos con personajes de Dragon Ball Z
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (1, 1, '1234567890', 'BASICA', 1000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (2, 2, '1234567891', 'BASICA', 2000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (3, 3, '1234567892', 'BASICA', 3000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (4, 4, '1234567893', 'PREMIUM', 4000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (5, 5, '1234567894', 'BASICA', 5000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (6, 6, '1234567895', 'PREMIUM', 6000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (7, 4, '1234567896', 'BASICA', 2000, 3500);
INSERT INTO cuentas (id_cuenta, id_usuario, numero_cuenta, tipo_cuenta, saldo, limite_retiro_diario) VALUES (8, 2, '1234567897', 'PREMIUM', 6000, 3500);

-- Insertar datos en la tabla de transacciones de la base de datos con personajes de Dragon
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (1, 1, 'DEPOSITO', '2024-10-01', 1000);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (2, 2, 'DEPOSITO', '2024-10-02', 2000);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (3, 3, 'DEPOSITO', '2024-10-03', 300);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (4, 4, 'DEPOSITO', '2024-10-02', 400);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (5, 5, 'DEPOSITO', '2024-10-04', 5000);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (6, 6, 'DEPOSITO', '2024-10-03', 1200);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (7, 4, 'DEPOSITO', '2024-10-05', 7200);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (8, 2, 'DEPOSITO', '2024-10-02', 8200);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (9, 2, 'DEPOSITO', '2024-10-01', 920);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (10, 4, 'DEPOSITO', '2024-10-01', 1000);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (11, 1, 'RETIRO', '2024-10-01', 100);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (12, 2, 'RETIRO', '2024-10-02', 200);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (13, 2, 'RETIRO', '2024-10-03', 300);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (14, 2, 'RETIRO', '2024-10-01', 400);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (15, 5, 'RETIRO', '2024-10-05', 500);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (16, 6, 'RETIRO', '2024-10-04', 600);
INSERT INTO transacciones (id_transaccion, id_cuenta, tipo, fecha_transaccion, monto) VALUES (17, 4, 'RETIRO', '2024-10-03', 700);