package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoLaboral;
import com.miPortfolio.spb.model.Laboral;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.LaboralService;
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
@RequestMapping("lab")
@CrossOrigin(origins = "http://localhost:4200")
public class LaboralController {
    @Autowired
    LaboralService labService;
    
    //Listado
    @GetMapping("/listarLab")
    public ResponseEntity<List<Laboral>> list(){
        List<Laboral> list = labService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detail/{idLaboral}")
    public ResponseEntity<Laboral> getById(@PathVariable("idLaboral") int idLaboral){
        if(!labService.existsById(idLaboral))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla Laboral!"), HttpStatus.NOT_FOUND);
        Laboral laboral = labService.getOne(idLaboral).get();
        return new ResponseEntity(laboral, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearLab")
    public ResponseEntity<?> create(@RequestBody dtoLaboral dtoLab){
        if(StringUtils.isBlank(dtoLab.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la empresa!"), HttpStatus.BAD_REQUEST);
        if(labService.existsByNombreEmpresa(dtoLab.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Esa empresa ya existe!"), HttpStatus.BAD_REQUEST);
        
        Laboral lab = new Laboral (dtoLab.getIdPersona(), dtoLab.getNombreEmpresa(), dtoLab.getPeriodoEmpresa(), dtoLab.getDescEmpresa(), dtoLab.getUrlEmpresa(), dtoLab.getUrl_imgLab());
        labService.save(lab);
        return new ResponseEntity(new Mensaje("Empresa guardada!"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editar/{idLaboral}")
    public ResponseEntity<?> update(@PathVariable("idLaboral") int idLaboral, @RequestBody dtoLaboral dtoLab){
        if(!labService.existsById(idLaboral))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Laboral"), HttpStatus.BAD_REQUEST);
        if(labService.existsByNombreEmpresa(dtoLab.getNombreEmpresa()) && labService.getByNombreEmpresa(dtoLab.getNombreEmpresa()).get().getIdLaboral() != idLaboral)
            return new ResponseEntity(new Mensaje("Esa empresa ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoLab.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la empresa!"), HttpStatus.BAD_REQUEST);
        
        Laboral lab = labService.getOne(idLaboral).get();
        lab.setIdPersona(dtoLab.getIdPersona());
        lab.setNombreEmpresa(dtoLab.getNombreEmpresa());
        lab.setPeriodoEmpresa(dtoLab.getPeriodoEmpresa());
        lab.setDescEmpresa(dtoLab.getDescEmpresa());
        lab.setUrlEmpresa(dtoLab.getUrlEmpresa());
        lab.setUrl_imgLab(dtoLab.getUrl_imgLab());
        
        labService.save(lab);
        return new ResponseEntity(new Mensaje("Empresa actualizada!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{idLaboral}")
    public ResponseEntity<?> delete(@PathVariable("idLaboral") int idLaboral){
        if(!labService.existsById(idLaboral))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Laboral!"), HttpStatus.BAD_REQUEST);
        labService.delete(idLaboral);
        return new ResponseEntity(new Mensaje("Empresa eliminada!"), HttpStatus.OK);
    }
}