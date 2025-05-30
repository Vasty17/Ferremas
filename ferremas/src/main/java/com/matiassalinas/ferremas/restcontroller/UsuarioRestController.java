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

import com.matiassalinas.ferremas.entities.Usuario;
import com.matiassalinas.ferremas.services.UsuarioService;

@RestController // Indica que esta clase será un controlador REST
@RequestMapping("api/usuarios") // Ruta base para acceder a los endpoints
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    // GET: lista de todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.findByAll();
    }

    // GET: Detalle de un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> verUsuario(@PathVariable Long id) {

        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // POST: Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario unUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(unUsuario));
    }

    // PUT: Modificar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUsuario(@PathVariable Long id, @RequestBody Usuario datos) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExiste = usuarioOptional.get();
            usuarioExiste.setUsuario(datos.getUsuario());
            usuarioExiste.setContraseña(datos.getContraseña());
            usuarioExiste.setRol(datos.getRol());
            Usuario usuarioModificado = usuarioService.save(usuarioExiste);
            return ResponseEntity.ok(usuarioModificado);
        }
        return ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        Usuario unUsuario = new Usuario();
        unUsuario.setId(id);
        Optional<Usuario> usuarioOptional = usuarioService.delete(unUsuario);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
