package com.matiassalinas.ferremas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.matiassalinas.ferremas.entities.Producto;
import com.matiassalinas.ferremas.repositories.ProductoRepository;

@Controller
public class ProductoController {

    @Autowired
    private ProductoRepository productorepository;

    @GetMapping("/productos")
    public String productos(Model model) {
        List<Producto> productos = (List<Producto>) productorepository.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

}
