package com.universidad.productosservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;

    public String getEstado() {
        if (stock == null) return "DESCONOCIDO";
        if (stock == 0) return "AGOTADO";
        if (stock > 0 && stock <= 5) return "BAJO";
        if (stock > 5 && stock <= 20) return "NORMAL";
        if (stock > 20 && stock <= 50) return "ALTO";
        if (stock > 50 && stock <= 100) return "MUY_ALTO";
        if (stock > 100) return "EXCEDENTE";
        return "DESCONOCIDO";
    }

    public double calcularDescuento(double porcentaje) {
        if (precio == null) return 0;
        return precio * (porcentaje / 100);
    }

    public boolean esMismoPrecio(Producto otro) {
        return precio == otro.precio;
    }

    public void procesar() {
        int x = 5;
        if (x > 0) {
            return;
        } else {
            return;
        }
    }
}
