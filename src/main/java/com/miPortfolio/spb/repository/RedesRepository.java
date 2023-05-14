package com.miPortfolio.spb.repository;

//Conecta directamente con la BD

import com.miPortfolio.spb.model.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepository extends JpaRepository<Redes, Integer> {
    public Optional<Redes> findByNombreRed(String nombreRed);
    public boolean existsByNombreRed(String nombreRed);
}
