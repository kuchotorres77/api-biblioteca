package com.biblioteca.api.repository;

import com.biblioteca.api.entity.Libro;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer> {

    public Optional<Libro> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
    
    public Optional<Libro> findByAutor(String autor);

}
