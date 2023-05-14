package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.Laboral;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.LaboralRepository;

@Service
@Transactional  //sincroniza con la BD
public class LaboralService {
    @Autowired
    LaboralRepository labRepository;
    
    public List<Laboral> list(){
        return labRepository.findAll();
    }
    
    public Optional<Laboral> getOne(int idLaboral){
        return labRepository.findById(idLaboral);
    }
    
    public Optional<Laboral> getByNombreEmpresa(String nombreEmpresa) {
        return labRepository.findByNombreEmpresa(nombreEmpresa);
    }
    
    public void save(Laboral lab){
        labRepository.save(lab);
    }
    
    public void delete(int idLaboral){
        labRepository.deleteById(idLaboral);
    }
    
    public boolean existsById(int idLaboral){
        return labRepository.existsById(idLaboral);
    }
    
    public boolean existsByNombreEmpresa(String nombreEmpresa){
        return labRepository.existsByNombreEmpresa(nombreEmpresa);
    }
}
