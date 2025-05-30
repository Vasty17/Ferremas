package com.matiassalinas.ferremas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matiassalinas.ferremas.entities.Producto;
import com.matiassalinas.ferremas.repositories.ProductoRepository;

@Service
public class ProductoServiceImple implements ProductoService {

    @Autowired
    private ProductoRepository productorepository;

    @Override
    @Transactional
    public Optional<Producto> delete(Producto unProducto) {
        // buscamos el objeto por medio del id
        Optional<Producto> productoOptional = productorepository.findById(unProducto.getId());
        productoOptional.ifPresent(productoDb -> { // si existe el objeto se elimina
            productorepository.delete(unProducto);
        });

        return productoOptional;
    }

    @Override
    @Transactional
    public List<Producto> findByAll() {

        return (List<Producto>) productorepository.findAll(); // devuelve un iterable, coleccion de objetos
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> findById(long id) {

        return productorepository.findById(id); // devuelve un objeto a traves de su id
    }

    @Override
    @Transactional
    public Producto save(Producto unProducto) {

        return productorepository.save(unProducto);
    }

}