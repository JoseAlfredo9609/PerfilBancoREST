# PerfilBancoREST

### Proyecto Micro Servicio \ API
- Proyecto para definir el perfil de tarjetas de credito
- Necesidad básica CRUD de todas las entidades.
- Métodos de consultas particulares.
- Test mockito y JUnite

**Las entidades del sistema son:**

+ Cliente
+ Tarjeta

**Datos por entidad:**

- Cliente tiene: id, nombre, apellido, pasion, salario mensual, fecha alta y fecha de modificacion.
 
- Tarjeta tiene: id, numero, vigencia, tipo de tarjeta fecha alta y fecha de modificacion.


### Paso a paso para ejecutar la aplicación:

1. Instalar PostgreSQL
- Al momento  de instalar el motor de base de datos tomar en cuenta el siguiente requermiento:
- contrasena: admin.

- Si tiene instalado PostgreSQL omitir este paso y configure la contraseña de la base de datos en proyecto en la seccion src/main/resources application.properties en el proyecto.

2. Luego de instalar el motor de base de datos debe:

- Crear base de datos perfil.
- Una vez creada la base de datos no es necesrio crear nungun esquema se crearan en el esquema publico para que puedas pobrar los test que incluye a aplicacion.

3. Clonar y descargar el presente proyecto:

4. Importar el proyecto como MAVEN en la IDE spring tool suite.

5. Ejecutar el proyecto **debug as spring boot app.**

6. Puedes probrar los endopints en la aplicacion de postman o en alguna otra similar. La URL de cada endpoint debe comenzar de la siguiente manera /api/v1/banco. 

7. La url para probar el swagger es la siguiente: **http://localhost:9091/api/v1/banco/swagger-ui/**


------------
