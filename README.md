# Taller #1 - Servicios Web con Spring Boot

## Nombre del proyecto

sw-tarea-semana3

## Objetivo

Desarrollar una API REST sencilla para el caso academico ficticio Cafe Soluble S.A. La API permite consultar productos, consultar un producto por ID y registrar productos nuevos en memoria.

## Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.1
- Spring Web
- Maven
- Jackson
- API REST
- JSON

## Estructura del codigo

```text
src/
+-- main/
    +-- java/
        +-- com/
            +-- cafesoluble/
                +-- swtareasemana3/
                    +-- SwTareaSemana3Application.java
                    +-- controller/
                    |   +-- ProductoController.java
                    +-- model/
                        +-- Producto.java
```

## Modelo Producto

La clase `Producto` contiene exactamente estos atributos:

- `id`: `Long`
- `nombre`: `String`
- `presentacion`: `String`
- `categoria`: `String`
- `disponible`: `boolean`

Incluye constructor vacio, constructor con parametros, getters y setters para que Jackson pueda convertir JSON a objetos Java y objetos Java a JSON.

## Endpoints

| Operacion | Metodo | Ruta | Codigo |
|-----------|--------|------|--------|
| Consultar productos | GET | /api/productos | 200 |
| Consultar producto | GET | /api/productos/{id} | 200 |
| Producto inexistente | GET | /api/productos/{id} | 404 |
| Registrar producto | POST | /api/productos | 201 |

## Ejemplos JSON

### GET /api/productos

Respuesta:

```json
[
  {
    "id": 1,
    "nombre": "Cafe Soluble Clasico",
    "presentacion": "50 g",
    "categoria": "Cafe soluble",
    "disponible": true
  }
]
```

### GET /api/productos/3

Respuesta:

```json
{
  "id": 3,
  "nombre": "Cafe Instantaneo Tradicional",
  "presentacion": "100 g",
  "categoria": "Cafe instantaneo",
  "disponible": true
}
```

### POST /api/productos

Cuerpo de la peticion:

```json
{
  "nombre": "Cafe Soluble Especial",
  "presentacion": "100 g",
  "categoria": "Cafe soluble",
  "disponible": true
}
```

Respuesta:

```json
{
  "id": 9,
  "nombre": "Cafe Soluble Especial",
  "presentacion": "100 g",
  "categoria": "Cafe soluble",
  "disponible": true
}
```

## Instrucciones para ejecutar

En Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

La aplicacion inicia en:

```text
http://localhost:8080
```

## Instrucciones basicas para probar

Consultar todos los productos:

```text
GET http://localhost:8080/api/productos
```

Consultar un producto existente:

```text
GET http://localhost:8080/api/productos/3
```

Consultar un producto inexistente:

```text
GET http://localhost:8080/api/productos/999
```

Registrar un producto:

```text
POST http://localhost:8080/api/productos
Content-Type: application/json
```

```json
{
  "nombre": "Cafe Soluble Especial",
  "presentacion": "100 g",
  "categoria": "Cafe soluble",
  "disponible": true
}
```

## Codigos HTTP

- `200 OK`: la consulta se realizo correctamente.
- `201 CREATED`: el producto fue creado correctamente.
- `404 NOT FOUND`: no existe un producto con el ID solicitado.

## Contribucion y Colaboracion

- **Modificacion hecha por Javier:** Creacion de rama de trabajo, comentarios de documentacion y verificacion tecnica del proyecto sin alterar la funcionalidad del programa.

