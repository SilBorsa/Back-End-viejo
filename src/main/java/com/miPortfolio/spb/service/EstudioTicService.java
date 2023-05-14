package com.miPortfolio.spb.service;

import com.miPortfolio.spb.model.EstudioTic;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.EstudioTicRepository;

@Service
@Transactional
public class EstudioTicService {
    @Autowired
    EstudioTicRepository ticRepository;
    
    public List<EstudioTic> list(){
        return ticRepository.findAll();
    }
    
    public Optional<EstudioTic> getOne(int idTic){
        return ticRepository.findById(idTic);
    }
    
    public Optional<EstudioTic> getByCursoTic(String cursoTic) {
        return ticRepository.findByCursoTic(cursoTic);
    }
    
    public void save(EstudioTic estudioTic){
        ticRepository.save(estudioTic);
    }
    
    public void delete(int idTic){
        ticRepository.deleteById(idTic);
    }
    
    public boolean existsById(int idTic){
        return ticRepository.existsById(idTic);
    }
    
    public boolean existsByCursoTic(String cursoTic){
        return ticRepository.existsByCursoTic(cursoTic);
    }
}
