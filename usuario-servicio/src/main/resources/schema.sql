CREATE TABLE usuarios (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    tipo VARCHAR(20), -- 'ESTUDIANTE' o 'DOCENTE'
    fecha_registro DATE DEFAULT CURRENT_DATE
);