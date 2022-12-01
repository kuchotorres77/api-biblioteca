package com.biblioteca.api.repository;

import com.biblioteca.api.entity.Gasto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGastoRepository extends JpaRepository<Gasto, Integer> {
    public Optional<Gasto> findByCategoria(String categoria);

    public boolean existsByCategoria(String categoria);
    
    public Optional<Gasto> findByCuenta(String cuenta);
}
