package com.matiassalinas.ferremas.services;

import java.util.List;
import java.util.Optional;

import com.matiassalinas.ferremas.entities.Producto;

public interface ProductoService {

    List<Producto> findByAll(); // devuelve todos los objetos de la tabla

    Optional<Producto> findById(long id); // devuelve un objeto por medio de su id

    Producto save(Producto unProducto); // devuelve un objeto de tipo producto para crear

    Optional<Producto> delete(Producto unProducto); // devuelve un objeto de tipo optional

}
