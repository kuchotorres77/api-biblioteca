package com.biblioteca.api.service;

import com.biblioteca.api.entity.Libro;
import com.biblioteca.api.repository.ILibroRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LibroService {

    @Autowired
    ILibroRepository librorepo;
    
    //Create
    public void save(Libro libro){
        librorepo.save(libro);
    }
    //Read
    public List<Libro>list(){
        return librorepo.findAll();
    }
    
    public Optional<Libro> getById(int id){
        return librorepo.findById(id);
    }
    
    public Optional<Libro> getByNombre(String nombre){
        return librorepo.findByNombre(nombre);
    }
    
    public Optional<Libro> getByAutor(String autor){
        return librorepo.findByAutor(autor);
    }
    //Update
    
    //Delete
    public void delete(int id){
        librorepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return librorepo.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return librorepo.existsByNombre(nombre);
    }
}
