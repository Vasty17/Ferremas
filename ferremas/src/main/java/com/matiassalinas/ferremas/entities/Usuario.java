package com.matiassalinas.ferremas.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Esta anotación indica que esta clase será una tabla en la base de datos
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // El ID se autogenera automáticamente
    private Long id;

    private String usuario;
    private String contraseña;
    private String rol;

    // Constructor vacío requerido por JPA
    public Usuario() {
    }

    public Usuario(Long id, String usuario, String contraseña, String rol) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Método que devuelve una representación en texto del objeto
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", usuario=" + usuario + ", rol=" + rol + "]";
    }

}
