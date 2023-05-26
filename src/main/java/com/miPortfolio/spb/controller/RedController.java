package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoRed;
import com.miPortfolio.spb.model.Redes;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.RedesService;
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
@RequestMapping("redes")
@CrossOrigin(origins = "http://localhost:4200")
public class RedController {
    @Autowired
    RedesService redService;
    
    //Listado
    @GetMapping("/listarRedes")
    public ResponseEntity<List<Redes>> list(){
        List<Redes> list = redService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detailRed/{idRed}")
    public ResponseEntity<Redes> getById(@PathVariable("idRed") int idRed){
        if(!redService.existsById(idRed))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla Proyecto!"), HttpStatus.NOT_FOUND);
        Redes redes = redService.getOne(idRed).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearRed")
    public ResponseEntity<?> create(@RequestBody dtoRed dtoRed){
        if(StringUtils.isBlank(dtoRed.getNombreRed()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la red!"), HttpStatus.BAD_REQUEST);
        if(redService.existsByNombreRed(dtoRed.getNombreRed()))
            return new ResponseEntity(new Mensaje("Esa red ya existe!"), HttpStatus.BAD_REQUEST);
        
        Redes redes = new Redes (dtoRed.getIdPersona(), dtoRed.getNombreRed(), dtoRed.getUrlRed(), dtoRed.getUrl_imgRed());
        redService.save(redes);
        return new ResponseEntity(new Mensaje("Red guardada!"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editarRed/{idRed}")
    public ResponseEntity<?> update(@PathVariable("idRed") int idRed, @RequestBody dtoRed dtoRed){
        if(!redService.existsById(idRed))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Redes"), HttpStatus.BAD_REQUEST);
        if(redService.existsByNombreRed(dtoRed.getNombreRed()) && redService.getByNombreRed(dtoRed.getNombreRed()).get().getIdRed() != idRed)
            return new ResponseEntity(new Mensaje("Esa red ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoRed.getNombreRed()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la red!"), HttpStatus.BAD_REQUEST);
        
        Redes redes = redService.getOne(idRed).get();
        redes.setIdPersona(dtoRed.getIdPersona());
        redes.setNombreRed(dtoRed.getNombreRed());
        redes.setUrlRed(dtoRed.getUrlRed());
        redes.setUrl_imgRed(dtoRed.getUrl_imgRed());
                
        redService.save(redes);
        return new ResponseEntity(new Mensaje("Red actualizado!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrarRed/{idRed}")
    public ResponseEntity<?> delete(@PathVariable("idRed") int idRed){
        if(!redService.existsById(idRed))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Redes!"), HttpStatus.BAD_REQUEST);
        redService.delete(idRed);
        return new ResponseEntity(new Mensaje("Red eliminada!"), HttpStatus.OK);
    }
}
