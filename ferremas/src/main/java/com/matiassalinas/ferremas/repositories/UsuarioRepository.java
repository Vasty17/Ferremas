package com.matiassalinas.ferremas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matiassalinas.ferremas.entities.Usuario;

// Esta interfaz extiende CrudRepository para acceder a métodos como findAll(), save(), deleteById(), etc.
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}