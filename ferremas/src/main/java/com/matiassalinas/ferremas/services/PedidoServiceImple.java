package com.matiassalinas.ferremas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matiassalinas.ferremas.entities.Pedido;
import com.matiassalinas.ferremas.repositories.PedidoRepository;

@Service // Esta clase es un componente de servicio gestionado por Spring
public class PedidoServiceImple implements PedidoService {

    @Autowired
    private PedidoRepository pedidorepository;

    // Eliminar pedido si existe en la base de datos
    @Override
    @Transactional
    public Optional<Pedido> delete(Pedido unPedido) {
        Optional<Pedido> pedidoOptional = pedidorepository.findById(unPedido.getId());
        pedidoOptional.ifPresent(pedidoDb -> {
            pedidorepository.delete(unPedido);
        });

        return pedidoOptional;
    }

    // Obtener todos los pedidos
    @Override
    @Transactional
    public List<Pedido> findByAll() {

        return (List<Pedido>) pedidorepository.findAll();
    }

    // Buscar pedido por ID
    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long id) {

        return pedidorepository.findById(id);
    }

    // Guardar o actualizar un pedido
    @Override
    @Transactional
    public Pedido save(Pedido unPedido) {

        return pedidorepository.save(unPedido);
    }
}