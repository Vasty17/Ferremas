package com.matiassalinas.ferremas.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//segun google permite trabajar con fechas locales, sin información de zona horaria ni tiempo
import java.time.LocalDate;

@Entity // Esta clase representa la tabla "pedido" en la base de datos
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autoincrementable
    private Long id;

    private LocalDate fecha; // Fecha del pedido
    private int total; // Monto total del pedido
    private String estado; // Estado del pedido: pendiente, enviado, entregado, etc.

    // Constructor vacío requerido por JPA
    public Pedido() {
    }

    public Pedido(Long id, LocalDate fecha, int total, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Representación textual del objeto
    @Override
    public String toString() {
        return "Pedido [id=" + id + ", fecha=" + fecha + ", total=" + total + ", estado=" + estado + "]";
    }

}