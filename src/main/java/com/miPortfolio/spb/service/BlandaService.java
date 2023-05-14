package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.Blandas;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.BlandaRepository;

@Service
@Transactional
public class BlandaService {
    @Autowired
    BlandaRepository blandaRepository;
    
    public List<Blandas> list(){
        return blandaRepository.findAll();
    }
    
    public Optional<Blandas> getOne(int idBlanda){
        return blandaRepository.findById(idBlanda);
    }
    
    public Optional<Blandas> getByNombreBlanda(String nombreBlanda) {
        return blandaRepository.findByNombreBlanda(nombreBlanda);
    }
    
    public void save(Blandas blanda){
        blandaRepository.save(blanda);
    }
    
    public void delete(int idBlanda){
        blandaRepository.deleteById(idBlanda);
    }
    
    public boolean existsById(int idBlanda){
        return blandaRepository.existsById(idBlanda);
    }
    
    public boolean existsByNombreBlanda(String nombreBlanda){
        return blandaRepository.existsByNombreBlanda(nombreBlanda);
    } 
}
