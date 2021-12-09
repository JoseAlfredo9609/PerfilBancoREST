# PerfilBancarioREST
Paso a paso para ejecutar la aplicación:

### Proyecto Micro Servicio \ API
- Proyecto para definir el perfil de tarjetas de credito
- Necesidad básica CRUD de todas las entidades.
- Métodos de consultas particulares.

**Las entidades del sistema son:**

+ Cliente
+ Tarjeta


------------

**Datos por entidad:**

- Cliente tiene: id, nombre, apellido, pasion, salario mensual, fecha alta y fecha de modificacion.
 
- Tarjeta tiene: id, numero, vigencia, tipo de tarjeta fecha alta y fecha de modificacion.

# UniversidadesREST
Paso a paso para ejecutar la aplicación:

1. Instalar PostgreSQL
- Al momento  de instalar el motor de base de datos tomar en cuenta el siguiente requermiento:
- contrasena: admin

(Si tiene instalado PostgreSQL omitir este paso y configure la contraseña de la base de datos en proyecto en la seccion src/main/resources application.properties) en el proyecto.

2. Luego de instalar el motor de base de datos debe:

- Crear base de datos banco.
Una vez creada la base de datos crear la base de datos universidad y dentro crear el schema universidad.

-Utilizar el schema public para probar los test;

3. Clonar y descargar el presente proyecto:


4. Importar el proyecto como MAVEN en la IDE spring tool suite
**se debe tener instalada la librería lombook**

5. Ejecutar el proyecto **debug as spring boot app**

------------