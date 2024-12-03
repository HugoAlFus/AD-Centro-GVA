# Gestión de Centros Educativos

- - -
Este proyecto es una aplicación de gestión de centros educativos desarrollada en Java utilizando Hibernate como ORM (
Object-Relational Mapping). La aplicación permite realizar operaciones específicas sobre entidades
como `Centre`, `Regim`, `Provincia` y `Cicle`.
 - - -

## Índice

1. [Características](#1-características)
2. [Tecnologías Utilizadas](#2-tecnologías-utilizadas)
3. [Estructura del Proyecto](#3-estructura-del-proyecto)
4. [Configuración](#4-configuración)
5. [Ejecución](#5-ejecución)

- - -

## 1. Características

1. **Crear Entidades**: Permite crear nuevos centros educativos en la base de datos, asociando datos existentes como
   régimen, provincia y ciclos formativos.
2. **Crear Entidades**: Permite crear nuevos centros educativos en la base de datos, asociando datos existentes como
   régimen, provincia y ciclos formativos.
3. **Leer Entidades**: Permite consultar y obtener información de centros educativos almacenados en la base de datos.
4. **Actualizar Entidades**: Permite actualizar información de los centros educativos, como el número de teléfono.
5. **Eliminar Entidades**: Permite eliminar centros educativos de la base de datos.

 - - -

## 2. Tecnologías Utilizadas

1. **Leer Entidades**: Permite consultar y obtener información de centros educativos almacenados en la base de datos.
2. **Java**: Lenguaje de programación principal.
3. **Actualizar Entidades**: Permite actualizar información de los centros educativos, como el número de teléfono.
4. **Hibernate**: Framework de mapeo objeto-relacional (ORM) utilizado para interactuar con la base de datos.
5. **Eliminar Entidades**: Permite eliminar centros educativos de la base de datos.
6. **Maven**: Herramienta de gestión de proyectos y dependencias.

- - -

## 3. Estructura del Proyecto

1. `src/main/java/es/cheste/Main.java`: Contiene la clase principal con métodos para realizar operaciones CRUD.
2. **Hibernate**: Framework de mapeo objeto-relacional (ORM) utilizado para interactuar con la base de datos.
3. **Maven**: Herramienta de gestión de proyectos y dependencias.
4. `src/main/resources/META-INF/persistence.xml`: Archivo de configuración de Hibernate.

- - -

## 4. Configuración

1. **JPA (Java Persistence API)**: API utilizada para la persistencia de datos.
2. **Dependencias**: Las dependencias necesarias están gestionadas por Maven. Asegúrate de tener Maven instalado y
   ejecuta `mvn install` para descargar las dependencias.

- - -

## 5. Ejecución

**Base de Datos**: Asegúrate de tener una base de datos configurada y accesible. Configura los detalles de conexión en
el archivo `persistence.xml`.
Para ejecutar la aplicación, utiliza la clase `Main` que contiene el método `main`. Este método inicializa
el `EntityManager` y llama a los métodos para realizar las operaciones ya especificadas.
- - -
![Imagen java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate]( https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
