package com.biblioteca.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gastos")
@Getter
@Setter
@NoArgsConstructor
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "monto")
    private double monto;
    
    @Column(name = "cuenta")
    private String cuenta;
    
    @Column(name = "categoria")
    private String categoria;
    
    @Column(name = "detalle")
    private String detalle;
    
    @Column(name = "fecha")
    private java.util.Date fecha;

    public Gasto(double monto, String cuenta, String categoria, String detalle, Date fecha) {
        this.monto = monto;
        this.cuenta = cuenta;
        this.categoria = categoria;
        this.detalle = detalle;
        this.fecha = fecha;
    }
    
    
}
