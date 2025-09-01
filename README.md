# Sistema de Gestión de Biblioteca Municipal

Sistema de gestión de biblioteca desarrollado en Java conectada a una base de datos con MySQL, diseñado para administrar usuarios, préstamos y devoluciones de manera segura y eficiente.

## Características

- Control de roles de usuario: administradores y lectores.
- Registro de préstamos y devoluciones con fechas límite y sanciones automáticas.
- Gestión de inventario: agregar libros, actualizar stock y registrar actividades.
- Base de datos incluida para replicar el sistema fácilmente.

## Tecnologías

- Java con interfaz gráfica Swing
- MySQL con procedimientos almacenados
- JDBC para conectividad con base de datos

## Estructura del Proyecto

El proyecto está organizado en los siguientes componentes principales:

- **ConexionMySQL.java**: Gestión de conexiones a base de datos
- **Interfaz_Administrador.java**: Panel de control para administradores
- **Interfaz_Lector.java**: Interfaz para usuarios lectores
- **Interfaz_Login.java**: Sistema de autenticación de usuarios
- **Main.java**: Punto de entrada de la aplicación
- **BD_BIBLIOTECA_MUNICIPAL.sql**: Esquema completo de base de datos con datos de ejemplo

## Funcionalidades Principales

### Módulo Administrativo
Gestión completa de libros, control de usuarios, sistema de sanciones, reportes y administración de préstamos.

### Módulo de Lector
Consulta de disponibilidad de libros, historial de préstamos personales y gestión de cuenta de usuario.

### Base de Datos
Esquema normalizado con tablas para libros, lectores, administradores, historial de movimientos y relación de préstamos activos.

## Características Técnicas

- Autenticación dual con roles diferenciados
- Procedimientos almacenados para operaciones críticas
- Validación de datos en frontend y backend
- Manejo de excepciones controlado
- Límite máximo de 3 préstamos por usuario

## Instalación y ejecución

1. Crear la base de datos usando `BD_BIBLIOTECA_MUNICIPAL.sql`.
2. Configurar la conexión en src/ConexionMySQL.java
3. Ejecutar el proyecto en Eclipse o desde consola.

## Valor del Proyecto

Sistema completo que demuestra competencias en desarrollo Java, gestión de bases de datos MySQL y creación de interfaces funcionales para administración bibliotecaria municipal. Incluye base de datos preconfigurada con datos de ejemplo para testing inmediato.
