package com.miPortfolio.spb.security.service;

import com.miPortfolio.spb.security.entity.Rol;
import com.miPortfolio.spb.security.enums.RolNombre;
import com.miPortfolio.spb.security.repository.iRolRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void saveRol(Rol rol){
        irolRepository.save(rol);
    }
}
