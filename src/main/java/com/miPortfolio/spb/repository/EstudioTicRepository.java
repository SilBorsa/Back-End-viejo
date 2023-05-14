package com.miPortfolio.spb.repository;

//Conecta directamente con la BD

import com.miPortfolio.spb.model.EstudioTic;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioTicRepository extends JpaRepository<EstudioTic, Integer> {
    public Optional<EstudioTic> findByCursoTic (String cursoTic);
    public boolean existsByCursoTic(String cursoTic);
}
