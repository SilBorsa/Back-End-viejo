package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.interfaz.IPersonaService;
import com.miPortfolio.spb.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
@CrossOrigin(origins="http://localhost:4200")
public class PersonaController {
    @Autowired
    IPersonaService ipersonaService;

    //listar
    @GetMapping("/listar")
    public List<Persona> getPersona() {
        return ipersonaService.getPersona();
    }
    
    //guardar
    //solo disponible para el admin
    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente, deberia anotar su ID para referirla en la carga de datos.";
    }
    
    //borrar
    //@PreAuthorize("hasRole('Role_Admin')")
    @DeleteMapping("/borrar/{idPersona}")
    public String deletePersona(@PathVariable int idPersona){
        ipersonaService.deletePersona(idPersona);
        return "La persona fue eliminada correctamente";
    }
    
    //editar
    //@PreAuthorize("hasRole{'Admin'}")
    @PutMapping("/editar/{idPersona}")
    public Persona editPersona(@PathVariable int idPersona,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("url_img") String nuevoURL_img){
        
        Persona persona = ipersonaService.findPersona(idPersona);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setUrl_img(nuevoURL_img);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
}
