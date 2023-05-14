package com.miPortfolio.spb.service;

//logica del negocio

import com.miPortfolio.spb.interfaz.IPersonaService;
import com.miPortfolio.spb.model.Persona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miPortfolio.spb.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService implements IPersonaService{
    //traigo el repositorio para leer los campos
    @Autowired 
    PersonaRepository personaRepository;
    
    //se trae automaticamente con clic derecho implementes abstract methods
    @Override
    public List<Persona> getPersona() {
        //creo la var persona para que almacene la lista
        List<Persona> persona = personaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(int idPersona) {
        personaRepository.deleteById(idPersona);
    }

    @Override
    public Persona findPersona(int idPersona) {
        Persona persona=personaRepository.findById(idPersona).orElse(null);
        return persona;
    }  
}
