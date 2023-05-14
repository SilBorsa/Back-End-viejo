package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.EstudioFormal;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.EstudioRepository;

@Service
@Transactional
public class EstudioService {
    @Autowired
    EstudioRepository eduRepository;
    
    public List<EstudioFormal> list(){
        return eduRepository.findAll();
    }
    
    public Optional<EstudioFormal> getOne(int idEstudio){
        return eduRepository.findById(idEstudio);
    }
    
    public Optional<EstudioFormal> getByTituloEstudio(String tituloEstudio) {
        return eduRepository.findByTituloEstudio(tituloEstudio);
    }
    
    public void save(EstudioFormal estudio){
        eduRepository.save(estudio);
    }
    
    public void delete(int idEstudio){
        eduRepository.deleteById(idEstudio);
    }
    
    public boolean existsById(int idEstudio){
        return eduRepository.existsById(idEstudio);
    }
    
    public boolean existsByTituloEstudio(String tituloEstudio){
        return eduRepository.existsByTituloEstudio(tituloEstudio);
    }
}
