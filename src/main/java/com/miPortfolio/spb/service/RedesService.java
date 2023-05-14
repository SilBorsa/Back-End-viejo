package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.Redes;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.RedesRepository;

@Service
@Transactional
public class RedesService {
    @Autowired
    RedesRepository redesRepository;
    
    public List<Redes> list(){
        return redesRepository.findAll();
    }
    
    public Optional<Redes> getOne(int idRed){
        return redesRepository.findById(idRed);
    }
    
    public Optional<Redes> getByNombreRed(String nombreRed) {
        return redesRepository.findByNombreRed(nombreRed);
    }
    
    public void save(Redes red){
        redesRepository.save(red);
    }
    
    public void delete(int idRed){
        redesRepository.deleteById(idRed);
    }
    
    public boolean existsById(int idRed){
        return redesRepository.existsById(idRed);
    }
    
    public boolean existsByNombreRed(String nombreRed){
        return redesRepository.existsByNombreRed(nombreRed);
    }
}
