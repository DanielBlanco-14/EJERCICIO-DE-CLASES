# Sistema de Ventas e Inventario

Proyecto académico hecho con Spring Boot, Java 17, Spring Data JPA, H2 y Thymeleaf.

## Funcionalidades

- Registro, edición, consulta y eliminación de usuarios.
- Registro, edición, consulta y eliminación de productos.
- Control de inventario mediante la cantidad disponible.
- Registro de ventas.
- Validación de stock antes de vender.
- Descuento automático del stock al realizar una venta.
- Historial de ventas.
- Panel principal con contadores.
- Base de datos H2 persistente en `./data/ventasdb`.

## Restricción del ejercicio

No se utiliza explícitamente:

- `@Service`
- `@Component`

Los servicios son objetos Java normales y se registran mediante:

- `@Configuration`
- `@Bean`

Los repositorios son interfaces de Spring Data JPA, que Spring registra automáticamente.

Los controllers usan `@Controller` porque son los encargados de recibir las peticiones de la página web.

## Ejecutar

Desde IntelliJ, Eclipse o VS Code:

1. Abrir el proyecto como proyecto Maven.
2. Esperar a que Maven descargue las dependencias.
3. Ejecutar `DemoApplication.java`.
4. Abrir:

http://localhost:8080

## Consola H2

http://localhost:8080/h2-console

JDBC URL:

jdbc:h2:file:./data/ventasdb

Usuario:

sa

Contraseña:

dejar vacía.

## Flujo recomendado para probarlo

1. Crear un usuario.
2. Crear un producto con precio y cantidad.
3. Ir a Ventas.
4. Registrar una venta.
5. Volver a Inventario y comprobar que el stock disminuyó.
6. Revisar el historial de ventas.

## Estructura

- `config`: configuración y creación de beans.
- `controller`: páginas y rutas HTTP.
- `model`: entidades de la base de datos.
- `repository`: acceso a datos.
- `service`: lógica de negocio.
- `templates`: páginas HTML.
- `static/css`: estilos.
