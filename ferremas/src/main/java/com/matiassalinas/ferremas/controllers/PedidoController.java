package com.matiassalinas.ferremas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.matiassalinas.ferremas.entities.Pedido;
import com.matiassalinas.ferremas.repositories.PedidoRepository;

@Controller // Indica que esta clase recibe peticiones web
public class PedidoController {

    @Autowired
    PedidoRepository pedidorepository; // Inyecta el repositorio para usarlo

    @GetMapping("/pedidos") // Ruta que muestra la lista de pedidos
    public String pedidos(Model model) {
        List<Pedido> pedidos = (List<Pedido>) pedidorepository.findAll(); // Obtener todos los pedidos
        model.addAttribute("pedidos", pedidos); // Agregar al modelo
        return "pedido"; // Mostrar la vista "pedido.html"
    }
}