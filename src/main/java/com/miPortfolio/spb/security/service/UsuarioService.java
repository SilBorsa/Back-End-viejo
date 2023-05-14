package com.miPortfolio.spb.security.service;

import com.miPortfolio.spb.security.entity.Usuario;
import com.miPortfolio.spb.security.repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmailUsuario(String emailUsuario){
        return iusuarioRepository.existsByEmailUsuario(emailUsuario);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }    
}
