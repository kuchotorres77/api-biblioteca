package com.biblioteca.api.service;

import com.biblioteca.api.entity.Gasto;
import com.biblioteca.api.repository.IGastoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GastoService {
    @Autowired
    IGastoRepository gastorepo;
    
    //Create
    public void save(Gasto gasto){
        gastorepo.save(gasto);
    }
    
    //Read
    public List<Gasto>list(){
        return gastorepo.findAll();
    }
    
    public Optional<Gasto> getById(int id){
        return gastorepo.findById(id);
    }
    
    public Optional<Gasto> getByCategoria(String categoria){
        return gastorepo.findByCategoria(categoria);
    }
    
    public Optional<Gasto> getByCuenta(String cuenta){
        return gastorepo.findByCuenta(cuenta);
    }
    
    //Delete
    public void delete(int id){
        gastorepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return gastorepo.existsById(id);
    }
    
    public boolean existsByCategoria(String categoria){
        return gastorepo.existsByCategoria(categoria);
    }
}
