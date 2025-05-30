package com.matiassalinas.ferremas.services;

import java.util.List;
import java.util.Optional;

import com.matiassalinas.ferremas.entities.Pedido;

// Interfaz que define los métodos del servicio Pedido
public interface PedidoService {

    List<Pedido> findByAll(); // Obtener todos los pedidos

    Optional<Pedido> findById(Long id); // Buscar un pedido por ID

    Pedido save(Pedido pedido); // Guardar o actualizar un pedido

    Optional<Pedido> delete(Pedido pedido); // Eliminar un pedido si existe
}