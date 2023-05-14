package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoProyecto;
import com.miPortfolio.spb.model.Proyecto;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.ProyectoService;
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
@RequestMapping("proy")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    @Autowired
    ProyectoService pyService;
    
    //Listado
    @GetMapping("/listarPy")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = pyService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detail/{idPy}")
    public ResponseEntity<Proyecto> getById(@PathVariable("idPy") int idPy){
        if(!pyService.existsById(idPy))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla Proyecto!"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = pyService.getOne(idPy).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearPy")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoPy){
        if(StringUtils.isBlank(dtoPy.getNombrePy()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre del proyecto!"), HttpStatus.BAD_REQUEST);
        if(pyService.existsByNombrePy(dtoPy.getNombrePy()))
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe!"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto (dtoPy.getIdPersona(), dtoPy.getNombrePy(), dtoPy.getPeriodoPy(), dtoPy.getDescPy(), dtoPy.getFotoPy());
        pyService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto guardado!"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editar/{idPy}")
    public ResponseEntity<?> update(@PathVariable("idPy") int idPy, @RequestBody dtoProyecto dtoPy){
        if(!pyService.existsById(idPy))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Proyecto"), HttpStatus.BAD_REQUEST);
        if(pyService.existsByNombrePy(dtoPy.getNombrePy()) && pyService.getByNombrePy(dtoPy.getNombrePy()).get().getIdPy() != idPy)
            return new ResponseEntity(new Mensaje("Esa empresa ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoPy.getNombrePy()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre de la empresa!"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = pyService.getOne(idPy).get();
        proyecto.setIdPersona(dtoPy.getIdPersona());
        proyecto.setNombrePy(dtoPy.getNombrePy());
        proyecto.setPeriodoPy(dtoPy.getPeriodoPy());
        proyecto.setDescPy(dtoPy.getDescPy());
        proyecto.setFotoPy(dtoPy.getFotoPy());
                
        pyService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{idPy}")
    public ResponseEntity<?> delete(@PathVariable("idPy") int idPy){
        if(!pyService.existsById(idPy))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla Proyecto!"), HttpStatus.BAD_REQUEST);
        pyService.delete(idPy);
        return new ResponseEntity(new Mensaje("Empresa eliminada!"), HttpStatus.OK);
    }
}
