package com.biblioteca.api.controller;

import com.biblioteca.api.dto.LibroDto;
import com.biblioteca.api.entity.Libro;
import com.biblioteca.api.service.LibroService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("https://appfrontbiblioteca.web.app/")
public class LibroController {

    @Autowired
    private LibroService libroserv;

    // Trae todos los registros libros de la bd
    @GetMapping("/vertodos")
    public ResponseEntity<List<Libro>> list() {
        List<Libro> libros = libroserv.list();
        return ResponseEntity.status(HttpStatus.OK).body(libros);
        //return ResponseEntity.ok(libros);
    }

    // Trae un libro por id
    @GetMapping("/ver/{id}")
    public ResponseEntity<Libro> getById(@PathVariable("id") int id) {
        if (!libroserv.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Libro libro = libroserv.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(libro);
    }

    // Borrar libro
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!libroserv.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        libroserv.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Crear Libro
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody LibroDto dtolibro) {
        if (StringUtils.isBlank(dtolibro.getNombre())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if (libroserv.existsByNombre(dtolibro.getNombre())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Libro libro = new Libro(dtolibro.getNombre(), dtolibro.getAutor(), dtolibro.getEditorial(), dtolibro.getAnio(), dtolibro.isFueLeido(), dtolibro.getFormato());
        libroserv.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Editar Libro
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody LibroDto dtolibro) {
        if (!libroserv.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else if (StringUtils.isBlank(dtolibro.getNombre())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else if (libroserv.existsByNombre(dtolibro.getNombre()) && libroserv.getByNombre(dtolibro.getNombre()).get().getId() != id) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Libro libro = libroserv.getById(id).get();
        libro.setNombre(dtolibro.getNombre());
        libro.setAutor(dtolibro.getAutor());
        libro.setEditorial(dtolibro.getEditorial());
        libro.setAnio(dtolibro.getAnio());
        libro.setFueLeido(dtolibro.isFueLeido());
        libro.setFormato(dtolibro.getFormato());
        libroserv.save(libro);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
