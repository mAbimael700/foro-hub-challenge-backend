# Foro Hub Challenge - Spring Boot

Este es un proyecto de API REST desarrollado en Spring Boot como parte del curso de Alura Java y Spring Framework G7 - ONE. La API permite la gestión de tópicos en un foro, implementando operaciones CRUD con buenas prácticas de desarrollo.

## Tecnologías utilizadas

- **Spring Boot** - Framework principal para la construcción de la API REST.
- **Spring JPA (Hibernate)** - Para la persistencia de datos.
- **MySQL** - Base de datos relacional utilizada para almacenar la información.
- **Flyway** - Gestión de migraciones de base de datos.
- **Spring Security** - Implementación de autenticación y autorización.
- **JWT (JSON Web Token)** - Autenticación basada en tokens seguros.

## Funcionalidades

La API permite a los usuarios realizar las siguientes operaciones sobre los tópicos:

1. **Crear un nuevo tópico** (`POST /topicos`)
2. **Mostrar todos los tópicos creados** (`GET /topicos`)
3. **Mostrar un tópico específico** (`GET /topicos/{id}`)
4. **Actualizar un tópico** (`PUT /topicos/{id}`)
5. **Eliminar (desactivar) un tópico** (`DELETE /topicos/{id}`)

### Notas sobre la eliminación de tópicos

El endpoint de eliminación solo desactiva el tópico, marcándolo como inactivo en la base de datos en lugar de eliminarlo físicamente.

## Arquitectura del proyecto

El proyecto está estructurado en las siguientes capas:

- **`domain`**: Contiene las entidades, servicios y repositorios.
- **`infra`**: Manejo de excepciones, configuraciones de JWT y Spring Security.
- **`controllers`**: Encargados de recibir y procesar las solicitudes HTTP.

## Manejo de validaciones y excepciones

- Se han implementado validaciones de reglas de negocio mediante clases separadas que implementan una interfaz de validación, aplicando el principio SOLID.
- Uso de **DTOs (Data Transfer Objects)** con `records` para las consultas.
- Manejo de excepciones utilizando `@RestControllerAdvice` y `@ExceptionHandler` para capturar errores específicos como:
  - Validaciones de reglas de negocio con el `Validator` de Spring.
  - Entidades no encontradas, devolviendo respuestas adecuadas con `ResponseEntity`.

## Seguridad

Cada endpoint está protegido mediante autenticación con JWT. Los usuarios deben estar autenticados para realizar cualquier operación en la API.

## Ejecución del proyecto

Para ejecutar la aplicación, asegúrate de tener configurados los siguientes parámetros en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.security.jwt.secret=clave_secreta
```

Luego, ejecuta el proyecto con:

```bash
mvn spring-boot:run
```

## Endpoints de la API

| Método HTTP | Ruta            | Descripción                   |
| ----------- | --------------- | ----------------------------- |
| POST        | `/topicos`      | Crea un nuevo tópico          |
| GET         | `/topicos`      | Obtiene todos los tópicos     |
| GET         | `/topicos/{id}` | Obtiene un tópico específico  |
| PUT         | `/topicos/{id}` | Actualiza un tópico existente |
| DELETE      | `/topicos/{id}` | Desactiva un tópico           |

## Contribuciones

Si deseas contribuir al proyecto, por favor crea un *fork* del repositorio y abre un *pull request* con tus cambios.

---

Desarrollado por Abimael Alexander Méndez Landero como parte del desafío de Alura Latam.

