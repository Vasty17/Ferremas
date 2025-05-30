package com.matiassalinas.ferremas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.matiassalinas.ferremas.entities.Pedido;

// Esta interfaz permite hacer operaciones como guardar, buscar y eliminar pedidos
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
