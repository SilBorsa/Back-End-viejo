package com.miPortfolio.spb.interfaz;

import com.miPortfolio.spb.model.Persona;
import java.util.List;

public interface IPersonaService {
    //obtener lista de personas
    public List<Persona> getPersona();
    
    //guardar una persona (es la variable, Persona es la clase)
    public void savePersona(Persona persona);
    
    //eliminar una persona
    public void deletePersona(int idPersona);
    
    //buscar una persona
    public Persona findPersona(int idPersona);
}
