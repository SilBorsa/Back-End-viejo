package com.miPortfolio.spb.repository;

//Conecta directamente con la BD

import com.miPortfolio.spb.model.Laboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboralRepository extends JpaRepository<Laboral, Integer> {
    public Optional<Laboral> findByNombreEmpresa(String nombreEmpresa);
    public boolean existsByNombreEmpresa(String nombreEmpresa);
}
