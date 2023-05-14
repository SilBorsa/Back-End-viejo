package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoEstudioFormal;
import com.miPortfolio.spb.model.EstudioFormal;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.EstudioService;
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
@RequestMapping("edu")
@CrossOrigin(origins = "http://localhost:4200")
public class EstudioController {
    @Autowired
    EstudioService eduService;
    
    //Listado
    @GetMapping("/listarEdu")
    public ResponseEntity<List<EstudioFormal>> list(){
        List<EstudioFormal> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detail/{idEstudio}")
    public ResponseEntity<EstudioFormal> getById(@PathVariable("idEstudio") int idEstudio){
        if(!eduService.existsById(idEstudio))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla EstudioFormal!"), HttpStatus.NOT_FOUND);
        EstudioFormal edu = eduService.getOne(idEstudio).get();
        return new ResponseEntity(edu, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearEdu")
    public ResponseEntity<?> create(@RequestBody dtoEstudioFormal dtoEdu){
        if(StringUtils.isBlank(dtoEdu.getTituloEstudio()))
            return new ResponseEntity(new Mensaje("Debe ingresar el titulo obtenido!"), HttpStatus.BAD_REQUEST);
        if(eduService.existsByTituloEstudio(dtoEdu.getTituloEstudio()))
            return new ResponseEntity(new Mensaje("Ese titulo ya existe"), HttpStatus.BAD_REQUEST);
        
        EstudioFormal edu = new EstudioFormal (dtoEdu.getIdPersona(), dtoEdu.getNombreInstituto(), dtoEdu.getPeriodoEstudio(), dtoEdu.getTituloEstudio(), dtoEdu.getUrlInstituto(), dtoEdu.getUrl_imgInst());
        eduService.save(edu);
        return new ResponseEntity(new Mensaje("Estudio guardado!"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editarEdu/{idEstudio}")
    public ResponseEntity<?> update(@PathVariable("idEstudio") int idEstudio, @RequestBody dtoEstudioFormal dtoEdu){
        if(!eduService.existsById(idEstudio))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla EstudioFormal!"), HttpStatus.BAD_REQUEST);
        if(eduService.existsByTituloEstudio(dtoEdu.getTituloEstudio()) && eduService.getByTituloEstudio(dtoEdu.getTituloEstudio()).get().getIdEstudio() != idEstudio)
            return new ResponseEntity(new Mensaje("Ese titulo ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEdu.getTituloEstudio()))
            return new ResponseEntity(new Mensaje("Debe ingresar el titulo obtenido!"), HttpStatus.BAD_REQUEST);
        
        EstudioFormal edu = eduService.getOne(idEstudio).get();
        edu.setIdPersona(dtoEdu.getIdPersona());
        edu.setNombreInstituto(dtoEdu.getNombreInstituto());
        edu.setPeriodoEstudio(dtoEdu.getPeriodoEstudio());
        edu.setTituloEstudio(dtoEdu.getTituloEstudio());
        edu.setUrlInstituto(dtoEdu.getUrlInstituto());
        edu.setUrl_imgInst(dtoEdu.getUrl_imgInst());
        
        eduService.save(edu);
        return new ResponseEntity(new Mensaje("Estudio actualizado!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrarEdu/{idEstudio}")
    public ResponseEntity<?> delete(@PathVariable("idEstudio") int idEstudio){
        if(!eduService.existsById(idEstudio))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla EstudioFormal!"), HttpStatus.BAD_REQUEST);
        eduService.delete(idEstudio);
        return new ResponseEntity(new Mensaje("Estudio eliminado!"), HttpStatus.OK);
    }
}
