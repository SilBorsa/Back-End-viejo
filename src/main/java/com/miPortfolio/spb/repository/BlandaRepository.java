package com.miPortfolio.spb.repository;

//Conecta directamente con la BD

import com.miPortfolio.spb.model.Blandas;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlandaRepository extends JpaRepository<Blandas, Integer> {
    public Optional<Blandas> findByNombreBlanda(String nombreBlanda);
    public boolean existsByNombreBlanda(String nombreBlanda);
}
