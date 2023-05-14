package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoDura;
import com.miPortfolio.spb.model.Duras;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.DuraService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hard")
@CrossOrigin(origins = "http://localhost:4200")
public class DuraController {
    @Autowired
    DuraService duraService;
    
    //Listado
    @GetMapping("/listarHard")
    public ResponseEntity<List<Duras>> list(){
        List<Duras> list = duraService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detail/{idDura}")
    public ResponseEntity<Duras> getById(@PathVariable("idDura") int idDura){
        if(!duraService.existsById(idDura))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla Duras!"), HttpStatus.NOT_FOUND);
        Duras duras = duraService.getOne(idDura).get();
        return new ResponseEntity(duras, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearHard")
    public ResponseEntity<?> create(@RequestBody dtoDura dtoDura){
        if(StringUtils.isBlank(dtoDura.getNombreDura()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la habilidad dura!"), HttpStatus.BAD_REQUEST);
        if(duraService.existsByNombreDura(dtoDura.getNombreDura()))
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe!"), HttpStatus.BAD_REQUEST);
        
        Duras dura = new Duras (dtoDura.getIdPersona(), dtoDura.getNombreDura(), dtoDura.getPorcentaje(), dtoDura.getColorDura());
        duraService.save(dura);
        return new ResponseEntity(new Mensaje("Habilidad dura guardada!"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editarHard/{idDura}")
    public ResponseEntity<?> update(@PathVariable("idDura") int idDura, @RequestBody dtoDura dtoDura){
        if(!duraService.existsById(idDura))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Duras"), HttpStatus.BAD_REQUEST);
        if(duraService.existsByNombreDura(dtoDura.getNombreDura()) && duraService.getByNombreDura(dtoDura.getNombreDura()).get().getIdDura() != idDura)
            return new ResponseEntity(new Mensaje("Esa habilidad dura ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoDura.getNombreDura()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la habilidad dura!"), HttpStatus.BAD_REQUEST);
        
        Duras dura = duraService.getOne(idDura).get();
        dura.setIdPersona(dtoDura.getIdPersona());
        dura.setNombreDura(dtoDura.getNombreDura());
        dura.setPorcentaje(dtoDura.getPorcentaje());
        dura.setColorDura(dtoDura.getColorDura());
                
        duraService.save(dura);
        return new ResponseEntity(new Mensaje("Habilidad duras actualizada!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrarHard/{idDura}")
    public ResponseEntity<?> delete(@PathVariable("idDura") int idDura){
        if(!duraService.existsById(idDura))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Duras!"), HttpStatus.BAD_REQUEST);
        duraService.delete(idDura);
        return new ResponseEntity(new Mensaje("Habilidad dura eliminada!"), HttpStatus.OK);
    }
}
