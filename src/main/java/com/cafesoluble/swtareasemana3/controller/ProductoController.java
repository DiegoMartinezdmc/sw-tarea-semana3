package com.cafesoluble.swtareasemana3.controller;

import com.cafesoluble.swtareasemana3.model.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para el catálogo de productos de Café Soluble S.A.
 * Modificación hecha por Javier.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {
        productos.add(new Producto(1L, "Cafe Soluble Clasico", "50 g", "Cafe soluble", true));
        productos.add(new Producto(2L, "Cafe Soluble Premium", "100 g", "Cafe premium", true));
        productos.add(new Producto(3L, "Cafe Instantaneo Tradicional", "100 g", "Cafe instantaneo", true));
        productos.add(new Producto(4L, "Cafe Descafeinado", "50 g", "Cafe descafeinado", true));
        productos.add(new Producto(5L, "Cafe Soluble Intenso", "200 g", "Cafe soluble", true));
        productos.add(new Producto(6L, "Cafe Instantaneo Suave", "100 g", "Cafe instantaneo", true));
        productos.add(new Producto(7L, "Cafe Premium Reserva", "200 g", "Cafe premium", false));
        productos.add(new Producto(8L, "Cafe Soluble Familiar", "200 g", "Cafe soluble familiar", true));
    }

    @GetMapping
    public ResponseEntity<List<Producto>> consultarProductos() {
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarProductoPorId(@PathVariable Long id) {
        Optional<Producto> productoEncontrado = productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst();

        return productoEncontrado
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        productos.add(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }
}
