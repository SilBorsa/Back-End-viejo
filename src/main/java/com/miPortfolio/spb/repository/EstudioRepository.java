package com.miPortfolio.spb.repository;

//Conecta directamente con la BD

import com.miPortfolio.spb.model.EstudioFormal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository<EstudioFormal, Integer> {
    public Optional<EstudioFormal> findByTituloEstudio(String tituloEstudio);
    public boolean existsByTituloEstudio(String tituloEstudio);
}
