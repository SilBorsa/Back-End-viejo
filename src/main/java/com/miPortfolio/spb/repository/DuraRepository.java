package com.miPortfolio.spb.repository;

//Conecta directamente con la BD

import com.miPortfolio.spb.model.Duras;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuraRepository extends JpaRepository<Duras, Integer> {
    public Optional<Duras> findByNombreDura(String nombreDura);
    public boolean existsByNombreDura(String nombreDura);
}
