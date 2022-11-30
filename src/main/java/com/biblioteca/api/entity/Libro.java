package com.biblioteca.api.entity;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "libros")
@Getter
@Setter
@NoArgsConstructor

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "autor")
    private String autor;
    
    @Column(name = "editorial")
    private String editorial;
    
    @Column(name = "anio")
    private int anio;
    
    @Column(name = "fueLeido")
    private boolean fueLeido;
    
    @Column(name = "formato")
    private String formato;

    public Libro(String nombre, String autor, String editorial, int anio, boolean fueLeido, String formato) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.fueLeido = fueLeido;
        this.formato = formato;
    }

    

}
