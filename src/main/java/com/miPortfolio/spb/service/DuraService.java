package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.Duras;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.DuraRepository;

@Service
@Transactional
public class DuraService {
    @Autowired
    DuraRepository duraRepository;
    
    public List<Duras> list(){
        return duraRepository.findAll();
    }
    
    public Optional<Duras> getOne(int idDura){
        return duraRepository.findById(idDura);
    }
    
    public Optional<Duras> getByNombreDura(String nombreDura) {
        return duraRepository.findByNombreDura(nombreDura);
    }
    
    public void save(Duras dura){
        duraRepository.save(dura);
    }
    
    public void delete(int idDura){
        duraRepository.deleteById(idDura);
    }
    
    public boolean existsById(int idDura){
        return duraRepository.existsById(idDura);
    }
    
    public boolean existsByNombreDura(String nombreDura){
        return duraRepository.existsByNombreDura(nombreDura);
    }
}
