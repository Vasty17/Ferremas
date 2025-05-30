package com.matiassalinas.ferremas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matiassalinas.ferremas.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
