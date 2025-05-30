package com.matiassalinas.ferremas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matiassalinas.ferremas.entities.Usuario;
import com.matiassalinas.ferremas.repositories.UsuarioRepository;

@Service // Anotación que indica que esta clase es un servicio gestionado por Spring
public class UsuarioServiceImple implements UsuarioService {

    @Autowired
    private UsuarioRepository usuariorepository;

    // Elimina un usuario si existe
    @Override
    @Transactional
    public Optional<Usuario> delete(Usuario unUsuario) {
        // buscamos el objeto por medio del id
        Optional<Usuario> usuarioOptional = usuariorepository.findById(unUsuario.getId());
        usuarioOptional.ifPresent(usuarioDb -> {
            usuariorepository.delete(unUsuario);
        });

        return usuarioOptional;
    }

    // Devuelve todos los usuarios
    @Override
    @Transactional
    public List<Usuario> findByAll() {

        return (List<Usuario>) usuariorepository.findAll();
    }

    // Devuelve un usuario por ID
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {

        return usuariorepository.findById(id);
    }

    // Guarda o actualiza un usuario
    @Override
    @Transactional
    public Usuario save(Usuario unUsuario) {

        return usuariorepository.save(unUsuario);
    }
}
