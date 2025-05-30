package com.matiassalinas.ferremas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import com.matiassalinas.ferremas.entities.Producto;
import com.matiassalinas.ferremas.services.ProductoService;

@RestController
@RequestMapping("api/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.findByAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> verDetalle(@PathVariable Long id) {

        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto unProducto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(unProducto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarProducto(@PathVariable Long id, @RequestBody Producto unProducto) {
        Optional<Producto> productoOptional = productoService.findById(id);
        if (productoOptional.isPresent()) { // el if present devuelve un booleano
            Producto productoExiste = productoOptional.get();
            productoExiste.setNombre(unProducto.getNombre());
            productoExiste.setDescripcion(unProducto.getDescripcion());
            productoExiste.setPrecio(unProducto.getPrecio());
            Producto productoModificado = productoService.save(productoExiste);
            return ResponseEntity.ok(productoModificado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        Producto unProducto = new Producto();
        unProducto.setId(id);
        Optional<Producto> productoOptional = productoService.delete(unProducto);
        if (productoOptional.isPresent()) {
            return ResponseEntity.ok(productoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}