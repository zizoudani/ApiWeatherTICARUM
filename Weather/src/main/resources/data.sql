-- Insertar sensores
INSERT INTO sensores (tipo, magnitud) VALUES ('Temperatura', '°C');
INSERT INTO sensores (tipo, magnitud) VALUES ('Humedad', '%');
INSERT INTO sensores (tipo, magnitud) VALUES ('Presión', 'hPa');
INSERT INTO sensores (tipo, magnitud) VALUES ('Velocidad del viento', 'm/s');

-- Insertar mediciones para el sensor de Temperatura
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-01T12:00:00', 25.0, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-02T13:00:00', 26.5, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-03T14:00:00', 24.0, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-04T15:00:00', 27.0, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-05T16:00:00', 23.5, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-06T17:00:00', 28.0, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-07T18:00:00', 22.0, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-08T19:00:00', 29.5, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-09T20:00:00', 21.0, 1);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-10T21:00:00', 30.0, 1);

-- Insertar mediciones para el sensor de Humedad
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-01T12:00:00', 60.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-02T13:00:00', 62.5, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-03T14:00:00', 58.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-04T15:00:00', 65.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-05T16:00:00', 55.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-06T17:00:00', 70.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-07T18:00:00', 50.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-08T19:00:00', 75.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-09T20:00:00', 45.0, 2);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-10T21:00:00', 80.0, 2);

-- Insertar mediciones para el sensor de Presión
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-01T12:00:00', 1013.25, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-02T13:00:00', 1015.50, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-03T14:00:00', 1010.75, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-04T15:00:00', 1012.00, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-05T16:00:00', 1014.20, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-06T17:00:00', 1011.30, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-07T18:00:00', 1016.00, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-08T19:00:00', 1009.50, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-09T20:00:00', 1017.75, 3);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-10T21:00:00', 1008.00, 3);

-- Insertar mediciones para el sensor de Velocidad del viento
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-01T12:00:00', 10.5, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-02T13:00:00', 12.0, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-03T14:00:00', 9.0, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-04T15:00:00', 14.5, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-05T16:00:00', 8.0, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-06T17:00:00', 16.0, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-07T18:00:00', 7.5, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-08T19:00:00', 18.0, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-09T20:00:00', 6.0, 4);
INSERT INTO mediciones (fecha, valor, sensor_id) VALUES ('2023-01-10T21:00:00', 20.0, 4);