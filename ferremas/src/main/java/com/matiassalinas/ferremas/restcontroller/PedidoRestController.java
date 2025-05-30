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

import com.matiassalinas.ferremas.entities.Pedido;
import com.matiassalinas.ferremas.services.PedidoService;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("api/pedidos") // Ruta base para acceder a los endpoints de pedidos
public class PedidoRestController {

    @Autowired
    private PedidoService pedidoService;

    // GET: Obtener todos los pedidos
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.findByAll();
    }

    // GET: Ver detalle de un pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> verPedido(@PathVariable Long id) {

        Optional<Pedido> pedidoOptional = pedidoService.findById(id);
        if (pedidoOptional.isPresent()) {
            return ResponseEntity.ok(pedidoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // POST: Crear un nuevo pedido
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido unPedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(unPedido));
    }

    // PUT: Modificar un pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarPedido(@PathVariable Long id, @RequestBody Pedido unPedido) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id);
        if (pedidoOptional.isPresent()) {
            Pedido pedidoExiste = pedidoOptional.get();
            pedidoExiste.setFecha(unPedido.getFecha());
            pedidoExiste.setEstado(unPedido.getEstado());
            pedidoExiste.setTotal(unPedido.getTotal());
            Pedido pedidoModificado = pedidoService.save(pedidoExiste);
            return ResponseEntity.ok(pedidoModificado);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar un pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id) {
        Pedido unPedido = new Pedido();
        unPedido.setId(id);
        Optional<Pedido> pedidoOptional = pedidoService.delete(unPedido);
        if (pedidoOptional.isPresent()) {
            return ResponseEntity.ok(pedidoOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}