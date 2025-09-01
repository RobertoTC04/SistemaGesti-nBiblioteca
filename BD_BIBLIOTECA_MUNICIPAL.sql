CREATE DATABASE BD_BIBLIOTECA_MUNICIPAL_2025;
USE BD_BIBLIOTECA_MUNICIPAL_2025;

CREATE TABLE LIBRO(
    Codigo_Libro CHAR(3) PRIMARY KEY,
    Nombre_Libro VARCHAR(50) NOT NULL,
    Autor_Libro VARCHAR(30) NOT NULL,
    Editorial_Libro VARCHAR(30) NOT NULL,
    Stock_Libro INT DEFAULT 0
);

CREATE TABLE LECTOR(
    Codigo_Lector CHAR(3) PRIMARY KEY,
    Nombres_Lector VARCHAR(50) NOT NULL,
    Apellidos_Lector VARCHAR(50) NOT NULL,
    Usuario_Lector VARCHAR(50) NOT NULL UNIQUE,
    Contraseña_Lector VARCHAR(50) NOT NULL,
    ContadorSanciones_Lector INT DEFAULT 0,
    Libro1 CHAR(3),
    Libro2 CHAR(3),
    Libro3 CHAR(3),
    FOREIGN KEY (Libro1) REFERENCES LIBRO(Codigo_Libro),
    FOREIGN KEY (Libro2) REFERENCES LIBRO(Codigo_Libro),
    FOREIGN KEY (Libro3) REFERENCES LIBRO(Codigo_Libro)
);

CREATE TABLE ADMINISTRADOR(
    Codigo_Administrador CHAR(3) PRIMARY KEY,
    Nombres_Administrador VARCHAR(50) NOT NULL,
    Apellidos_Administrador VARCHAR(50) NOT NULL,
    Usuario_Administrador VARCHAR(50) NOT NULL,
    Contraseña_Administrador VARCHAR(50) NOT NULL
);

CREATE TABLE HISTORIAL (
    Codigo_Historial CHAR(4) PRIMARY KEY,
    Codigo_Lector CHAR(3) NULL,
    Codigo_Libro CHAR(3) NULL,
    Codigo_Administrador CHAR(3) NULL,
    Tipo_Movimiento INT NOT NULL,
    Fecha_Movimiento DATETIME DEFAULT CURRENT_TIMESTAMP,
    Descripcion VARCHAR(100) NOT NULL,
    FOREIGN KEY (Codigo_Lector) REFERENCES LECTOR(Codigo_Lector),
    FOREIGN KEY (Codigo_Libro) REFERENCES LIBRO(Codigo_Libro),
    FOREIGN KEY (Codigo_Administrador) REFERENCES ADMINISTRADOR(Codigo_Administrador)
);

CREATE PROCEDURE InsertarLibro(
    cod CHAR(3),
    nom VARCHAR(50),
    autor VARCHAR(30),
    edit VARCHAR(30),
    stock INT
)
INSERT INTO LIBRO VALUES(cod, nom, autor, edit, stock);

CREATE PROCEDURE ListarLibro()
SELECT * FROM LIBRO ORDER BY Codigo_Libro;

CREATE PROCEDURE EliminarLibro(
    codi CHAR(3)
)
DELETE FROM LIBRO WHERE Codigo_Libro = codi;

CREATE PROCEDURE EditarLibro(
    cod CHAR(3),
    nom VARCHAR(50),
    autor VARCHAR(30),
    edit VARCHAR(30),
    stock INT
)
UPDATE LIBRO SET Nombre_Libro = nom, Autor_Libro = autor, Editorial_Libro = edit, Stock_Libro = stock
WHERE Codigo_Libro = cod;

CREATE PROCEDURE ConsultarCodLibro(
    cod CHAR(3)
)
SELECT * FROM LIBRO WHERE Codigo_Libro = cod;

CREATE PROCEDURE AplicarSancion(
    cod CHAR(3)
)
UPDATE LECTOR
SET ContadorSanciones_Lector = ContadorSanciones_Lector + 1
WHERE Codigo_Lector = cod;

CREATE PROCEDURE QuitarSancion(
    cod CHAR(3)
)
UPDATE LECTOR
SET ContadorSanciones_Lector = ContadorSanciones_Lector - 1
WHERE Codigo_Lector = cod;

CREATE PROCEDURE ObtenerHistorialPorTipo(tipo INT)
SELECT Codigo_Historial, Tipo_Movimiento, Descripcion, Fecha_Movimiento
FROM HISTORIAL
WHERE Tipo_Movimiento = tipo
ORDER BY Fecha_Movimiento;

CREATE PROCEDURE listarLector()
SELECT * FROM LECTOR;

INSERT INTO ADMINISTRADOR VALUES ('111','Roberto','Torres Casapia','Roberto','nosequeponer111');
INSERT INTO ADMINISTRADOR VALUES ('222','Raul Alessandro','Yarupayta Arotaype','Raul','nosequeponer222');
INSERT INTO ADMINISTRADOR VALUES ('333','Edgar Antonio','Vasquez Bedoya','Edgar','nosequeponer333');
INSERT INTO ADMINISTRADOR VALUES ('444','Pedro Emmanuel','Zapata Paz','Pedro','nosequeponer444');
INSERT INTO ADMINISTRADOR VALUES ('555','Fresia Nicole','Vilchez Puescas','Nicole','nosequeponer555');

SELECT * FROM ADMINISTRADOR;

INSERT INTO LIBRO VALUES ('A00', 'Cien años de soledad', 'Gabriel García Márquez', 'Sudamericana', 3);
INSERT INTO LIBRO VALUES ('A01', '1984', 'George Orwell', 'Secker & Warburg', 2);
INSERT INTO LIBRO VALUES ('A02', 'Don Quijote', 'Miguel de Cervantes', 'Francisco de Robles', 1);
INSERT INTO LIBRO VALUES ('A03', 'El principito', 'Antoine de Saint-Exupéry', 'Reynal & Hitchcock', 2);
INSERT INTO LIBRO VALUES ('A04', 'Fahrenheit 451', 'Ray Bradbury', 'Ballantine Books', 3);
INSERT INTO LIBRO VALUES ('A05', 'Crónica de una muerte anunciada', 'Gabriel García Márquez', 'Editorial Oveja Negra', 1);
INSERT INTO LIBRO VALUES ('A06', 'La ciudad y los perros', 'Mario Vargas Llosa', 'Seix Barral', 2);
INSERT INTO LIBRO VALUES ('A07', 'Los juegos del hambre', 'Suzanne Collins', 'Scholastic Press', 3);
INSERT INTO LIBRO VALUES ('A08', 'El código Da Vinci', 'Dan Brown', 'Doubleday', 1);
INSERT INTO LIBRO VALUES ('A09', 'It', 'Stephen King', 'Viking', 2);
INSERT INTO LIBRO VALUES ('A10', 'Orgullo y prejuicio', 'Jane Austen', 'T. Egerton', 3);
INSERT INTO LIBRO VALUES ('A11', 'Drácula', 'Bram Stoker', 'Archibald Constable', 1);
INSERT INTO LIBRO VALUES ('A12', 'Rayuela', 'Julio Cortázar', 'Sudamericana', 2);
INSERT INTO LIBRO VALUES ('A13', 'La sombra del viento', 'Carlos Ruiz Zafón', 'Planeta', 3);
INSERT INTO LIBRO VALUES ('A14', 'El Hobbit', 'J.R.R. Tolkien', 'George Allen & Unwin', 1);

SELECT * FROM LIBRO;
SELECT * FROM LECTOR;
SELECT * FROM HISTORIAL ORDER BY Fecha_Movimiento;

CREATE TABLE LECTOR_LIBRO (
    Codigo_Lector CHAR(3),
    Codigo_Libro CHAR(3),
    Fecha_Prestamo DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (Codigo_Lector, Codigo_Libro),
    FOREIGN KEY (Codigo_Lector) REFERENCES LECTOR(Codigo_Lector),
    FOREIGN KEY (Codigo_Libro) REFERENCES LIBRO(Codigo_Libro)
);

SELECT * FROM LECTOR_LIBRO;

INSERT INTO Lector VALUES ('ABC','Juan','Perez Alvarez','Juan Perez' ,'123',0,null,null,null);
INSERT INTO Lector VALUES ('DEF','Luis Alberto', 'Ruiz Segura','Luis Alberto' ,'12345',0,null,null,null);

SELECT * FROM LECTOR;
SELECT * FROM LIBRO;

SELECT * FROM HISTORIAL ORDER BY Fecha_Movimiento;