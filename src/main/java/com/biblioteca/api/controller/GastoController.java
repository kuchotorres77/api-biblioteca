package com.biblioteca.api.controller;

import com.biblioteca.api.dto.GastoDto;
import com.biblioteca.api.entity.Gasto;
import com.biblioteca.api.service.GastoService;

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
@CrossOrigin("https://appfrontbiblioteca-cf9ac.web.app/")
public class GastoController {

    @Autowired
    private GastoService gastoservice;

    // Trae todos los registros gastos de la bd
    @GetMapping("/gasto/vertodos")
    public ResponseEntity<List<Gasto>> list() {
        List<Gasto> gastos = gastoservice.list();
        return ResponseEntity.status(HttpStatus.OK).body(gastos);
    }

    // Trae un gasto por id
    @GetMapping("/gasto/ver/{id}")
    public ResponseEntity<Gasto> getById(@PathVariable("id") int id) {
        if (!gastoservice.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Gasto gasto = gastoservice.getById(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(gasto);
    }

    // Borrar gasto
    @DeleteMapping("/gasto/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!gastoservice.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        gastoservice.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Crear gasto
    @PostMapping("/gasto/crear")
    public ResponseEntity<?> create(@RequestBody GastoDto dtogasto) {
//        if (StringUtils.isBlank(dtogasto.getCategoria())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        } else if (gastoservice.existsByCategoria(dtogasto.getCategoria())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
        Gasto gasto = new Gasto(dtogasto.getMonto(), dtogasto.getCuenta(), dtogasto.getCategoria(), dtogasto.getDetalle(), dtogasto.getFecha());
        gastoservice.save(gasto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Editar gasto
    @PutMapping("/gasto/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody GastoDto dtogasto) {
        if (!gastoservice.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } 
//        else if (StringUtils.isBlank(dtolibro.getNombre())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        } 
//        else if (gastoservice.existsByNombre(dtolibro.getNombre()) && gastoservice.getByNombre(dtolibro.getNombre()).get().getId() != id) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
        Gasto gasto = gastoservice.getById(id).get();
        gasto.setMonto(dtogasto.getMonto());
        gasto.setCuenta(dtogasto.getCuenta());
        gasto.setCategoria(dtogasto.getCategoria());
        gasto.setDetalle(dtogasto.getDetalle());
        gasto.setFecha(dtogasto.getFecha());
        gastoservice.save(gasto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
