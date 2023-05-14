package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.Proyecto;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.ProyectoRepository;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    ProyectoRepository pyRepository;
    
    public List<Proyecto> list(){
        return pyRepository.findAll();
    }
    
    public Optional<Proyecto> getOne(int idPy){
        return pyRepository.findById(idPy);
    }
    
    public Optional<Proyecto> getByNombrePy(String nombrePy) {
        return pyRepository.findByNombrePy(nombrePy);
    }
    
    public void save(Proyecto py){
        pyRepository.save(py);
    }
    
    public void delete(int idPy){
        pyRepository.deleteById(idPy);
    }
    
    public boolean existsById(int idPy){
        return pyRepository.existsById(idPy);
    }
    
    public boolean existsByNombrePy(String nombrePy){
        return pyRepository.existsByNombrePy(nombrePy);
    }
}
