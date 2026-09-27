# SpeedFast - Semana 7

## Descripción

En esta actividad se implementa persistencia de datos utilizando JDBC y MySQL en el sistema SpeedFast.

La aplicación permite registrar pedidos y repartidores, consultar los pedidos almacenados y registrar entregas asociando un pedido con un repartidor.

Cuando se inicia una entrega, el estado del pedido cambia de `PENDIENTE` a `EN_REPARTO`.



## Estructura del proyecto

- `modelo`: contiene las clases Pedido, Repartidor y Entrega.
- `dao`: contiene la conexión a MySQL y las operaciones de acceso a datos.
- `controlador`: comunica la interfaz gráfica con la capa DAO.
- `vista`: contiene las ventanas desarrolladas con Java Swing.
- `main`: contiene el punto de inicio de la aplicación y clases utilizadas para pruebas.

## Base de datos

La aplicación utiliza una base de datos MySQL llamada:

`speedfast_db`

Contiene las tablas:

- `pedido`
- `repartidor`
- `entrega`

La tabla `entrega` relaciona cada pedido con un repartidor mediante claves foráneas.

## Funcionalidades

- Registrar pedidos en MySQL.
- Consultar pedidos almacenados y mostrarlos en un JTable.
- Registrar repartidores.
- Consultar los repartidores almacenados.
- Asignar un repartidor a un pedido.
- Registrar una entrega con fecha y hora.
- Actualizar el estado del pedido a `EN_REPARTO` al iniciar una entrega.

## Configuración de la conexión

La conexión utiliza:

- Base de datos: `speedfast_db`
- Puerto: `3306`
- Usuario: `root`

Por seguridad, la contraseña de MySQL no está almacenada directamente en el código.

Debe configurarse una variable de entorno llamada:

`MYSQL_PASSWORD`

con la contraseña correspondiente al usuario MySQL antes de ejecutar la aplicación.

## Ejecución

Ejecutar la clase:

`main.Main`

La aplicación abrirá la ventana principal de SpeedFast desde donde se pueden registrar pedidos, listar pedidos y gestionar repartidores y entregas.
