# Proyecto de patrones de diseño de software

### Planteamiento del problema

Una empresa requiere una aplicación para llevar un registro del inventario del estado de vacunación de los empleados.

La aplicación contará con 2 roles: `Administrador y Empleado`.

Para el desarrollo de la aplicación tenemos las siguientes historias de usuario.

1. Como `Administrador` requiero **registrar, editar, listar y eliminar** a los empleados.
   <br>
   <br>
   **Criterios de aceptación**
   <br>
   <br>
   a. Registrar la siguiente información del empleado.
    * Cédula.
    * Nombres.
    * Apellidos.
    * Correo Electrónico.

   b. Los campos deben contener validaciones de acuerdo al tipo de dato:
    * Todos los campos son requeridos.
    * Cédula válida. (Incluir un valor numérico y único de 10 dígitos).
    * Correo electrónico válido.
    * Nombres y apellidos no deben contener números o caracteres especiales.

   c. Al dar de alta un empleado se debe generar un usuario y contraseña para el empleado.
   <br>
   <br>
2. Como `Empleado` requiero ingresar al sistema para visualizar y actualizar mi información.
   <br>
   <br>
   **Criterios de aceptación**
   <br>
   <br>
   a. Completar la siguiente información:
    * Fecha de nacimiento.
    * Dirección de domicilio.
    * Teléfono móvil.
    * Estado de vacunación: Vacunado / No Vacunado.
    * Si el empleado está en estado vacunado, se debe pedir la siguiente información requerida:
        * Tipo de vacuna: Sputnik, AstraZeneca, Pfizer y Jhonson&Jhonson
        * Fecha de vacunación.
        * Número de dosis.

### Tecnologías a usar:

* **Lenguaje**: Java
* **Framework**: Spring Boot
    * **Librerias**:
        * **Datos**: Spring JPA
        * **Modelos de clases**: Lombook
        * **Seguridad**: Spring security
        * **Servicios Web**: Spring Web
* **Persistencia de datos**: Postrgresql
* **Documentación**: Swagger + Open API
