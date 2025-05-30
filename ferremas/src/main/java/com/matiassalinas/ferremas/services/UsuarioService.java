package com.matiassalinas.ferremas.services;

import java.util.List;
import java.util.Optional;

import com.matiassalinas.ferremas.entities.Usuario;

// Interfaz que define los métodos que implementará la clase de servicio
public interface UsuarioService {

    List<Usuario> findByAll(); // Obtener todos los usuarios

    Optional<Usuario> findById(Long id); // Buscar usuario por ID

    Usuario save(Usuario usuario); // Crear o actualizar un usuario

    Optional<Usuario> delete(Usuario usuario); // Eliminar usuario por objeto (usando su ID)
}
