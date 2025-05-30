package com.matiassalinas.ferremas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.matiassalinas.ferremas.entities.Usuario;
import com.matiassalinas.ferremas.repositories.UsuarioRepository;

@Controller // Indica que esta clase se encargará de recibir peticiones web (como /usuarios)
public class UsuarioController {

    @Autowired // Inyecta automáticamente el repositorio para usarlo sin crear una instancia
               // manual
    private UsuarioRepository usuariorepository;

    @GetMapping("/usuarios") // Ruta web que mostrará la lista de usuarios
    public String usuarios(Model model) {
        // Trae todos los usuarios desde la base de datos
        List<Usuario> usuarios = (List<Usuario>) usuariorepository.findAll();

        // Agrega la lista al modelo para mostrarla en el HTML
        model.addAttribute("usuarios", usuarios);

        // Devuelve el nombre del archivo HTML (usuario.html)
        return "usuario";
    }
}