package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoBlanda;
import com.miPortfolio.spb.model.Blandas;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.BlandaService;
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
@RequestMapping("soft")
@CrossOrigin(origins = "http://localhost:4200")
public class BlandaController {
    @Autowired
    BlandaService blandaService;
    
    //Listado
    @GetMapping("/listarSoft")
    public ResponseEntity<List<Blandas>> list(){
        List<Blandas> list = blandaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detail/{idBlanda}")
    public ResponseEntity<Blandas> getById(@PathVariable("idBlanda") int idBlanda){
        if(!blandaService.existsById(idBlanda))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla Blandas!"), HttpStatus.NOT_FOUND);
        Blandas blandas = blandaService.getOne(idBlanda).get();
        return new ResponseEntity(blandas, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearSoft")
    public ResponseEntity<?> create(@RequestBody dtoBlanda dtoBlanda){
        if(StringUtils.isBlank(dtoBlanda.getNombreBlanda()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la habilidad blanda!"), HttpStatus.BAD_REQUEST);
        if(blandaService.existsByNombreBlanda(dtoBlanda.getNombreBlanda()))
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe!"), HttpStatus.BAD_REQUEST);
        
        Blandas blanda = new Blandas (dtoBlanda.getIdPersona(), dtoBlanda.getNombreBlanda(), dtoBlanda.getUrl_imgBlanda(), dtoBlanda.getColorBlanda());
        blandaService.save(blanda);
        return new ResponseEntity(new Mensaje("Habilidad blanda guardada!"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editarSoft/{idBlanda}")
    public ResponseEntity<?> update(@PathVariable("idBlanda") int idBlanda, @RequestBody dtoBlanda dtoBlanda){
        if(!blandaService.existsById(idBlanda))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Blandas"), HttpStatus.BAD_REQUEST);
        if(blandaService.existsByNombreBlanda(dtoBlanda.getNombreBlanda()) && blandaService.getByNombreBlanda(dtoBlanda.getNombreBlanda()).get().getIdBlanda() != idBlanda)
            return new ResponseEntity(new Mensaje("Esa habilidad blanda ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoBlanda.getNombreBlanda()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la habilidad blanda!"), HttpStatus.BAD_REQUEST);
        
        Blandas blanda = blandaService.getOne(idBlanda).get();
        blanda.setIdPersona(dtoBlanda.getIdPersona());
        blanda.setNombreBlanda(dtoBlanda.getNombreBlanda());
        blanda.setUrl_imgBlanda(dtoBlanda.getUrl_imgBlanda());
        blanda.setColorBlanda(dtoBlanda.getColorBlanda());
                
        blandaService.save(blanda);
        return new ResponseEntity(new Mensaje("Habilidad blandas actualizada!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrarSoft/{idBlanda}")
    public ResponseEntity<?> delete(@PathVariable("idBlanda") int idBlanda){
        if(!blandaService.existsById(idBlanda))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Blandas!"), HttpStatus.BAD_REQUEST);
        blandaService.delete(idBlanda);
        return new ResponseEntity(new Mensaje("Habilidad blanda eliminada!"), HttpStatus.OK);
    }
}
