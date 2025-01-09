# Backend para Portafolio y Currículum Vitae

Este proyecto es una aplicación backend desarrollada en Java utilizando Spring Boot, Spring Security. Está diseñada para manejar la lógica y arquitectura de información para un portafolio y currículum vitae, conectándose a una base de datos SQL.

## Características

- Gestión de la lógica de negocio y datos para portafolios y currículums.
- Conexión a bases de datos SQL (PostgreSQL por defecto).
- Exposición de servicios RESTful.
- Configurable a través de un archivo `.properties`.

## Requisitos previos

1. **Java**: JDK 17 o superior.
2. **Maven**: Instalado y configurado.
3. **PostgreSQL**: Instalado y en ejecución. Y una base de datos creada.

## Instalación

1. **Clona el repositorio**

2. **Configura la conexión a la base de datos**

  Se debe editar el archivo `application.properties` en el directorio `src/main/resources` para configurar la conexión a la base de datos PostgreSQL. Ejemplo:

   spring.datasource.url=jdbc:postgresql://localhost:5432/<NOMBRE_BD>
   spring.datasource.username=usuario
   spring.datasource.password=contraseña
   spring.jpa.hibernate.ddl-auto=update 
   spring.jpa.show-sql=true
 

3. **Construir el proyecto**
   
   mvn clean install


4. **Ejecuta la aplicación**
 
 
## Creación de un usuario administrador inicial

Puedes crear un usuario administrador inicial al iniciar la aplicación utilizando un bean en el método `main`. Este código no está incluido en la configuración del proyecto:


@Bean
CommandLineRunner user(UserService userService, MyProfileService myProfileService) {
    return args -> {
        if (!userService.userExistsByUserName("admin")) {
            userService.createUser("admin", "admin_password", Role.ADMIN);
            System.out.println("Usuario 'admin' creado correctamente.");
        } else {
            System.out.println("El usuario 'admin' ya existe.");
        }
    };
}


Este bean verifica si existe un usuario con el nombre "admin". Si no existe, lo crea automáticamente con la contraseña "admin_password" y el rol `ADMIN`.

## Endpoints

Esta aplicación expone varios endpoints RESTful para interactuar con la base de datos. 
