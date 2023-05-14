package com.miPortfolio.spb.controller;

import com.miPortfolio.spb.dto.dtoEstudioTic;
import com.miPortfolio.spb.model.EstudioTic;
import com.miPortfolio.spb.security.controller.Mensaje;
import com.miPortfolio.spb.service.EstudioTicService;
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
@RequestMapping("tic")
@CrossOrigin (origins = "http://localhost:4200")
public class EstudioTicController {
    @Autowired
    EstudioTicService ticService;
    
    //Listado
    @GetMapping("/listarTic")
    public ResponseEntity<List<EstudioTic>> list(){
        List<EstudioTic> list = ticService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Edicion
    @GetMapping("/detail/{idTic}")
    public ResponseEntity<EstudioTic> getById(@PathVariable("idTic") int idTic){
        if(!ticService.existsById(idTic))
            return new ResponseEntity(new Mensaje("Ese id no existe en la tabla EstudioTic!"), HttpStatus.NOT_FOUND);
        EstudioTic tic = ticService.getOne(idTic).get();
        return new ResponseEntity(tic, HttpStatus.OK);
    }
    
    //creacion
    @PostMapping("/crearTic")
    public ResponseEntity<?> create(@RequestBody dtoEstudioTic dtoTic){
        if(StringUtils.isBlank(dtoTic.getCursoTic()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre del curso tic!"), HttpStatus.BAD_REQUEST);
        if(ticService.existsByCursoTic(dtoTic.getCursoTic()))
            return new ResponseEntity(new Mensaje("El curso ya existe!"), HttpStatus.BAD_REQUEST);
        
        EstudioTic tic = new EstudioTic (dtoTic.getIdPersona(), dtoTic.getNombreInstTic(), dtoTic.getPeriodoTic(), dtoTic.getCursoTic(), dtoTic.getUrlInstTic(), dtoTic.getUrl_imgTic());
        ticService.save(tic);
        return new ResponseEntity(new Mensaje("Curso guardado"), HttpStatus.OK);
    }
    
    //edicion
    @PutMapping("/editarTic/{idTic}")
    public ResponseEntity<?> update(@PathVariable("idTic") int idTic, @RequestBody dtoEstudioTic dtoTic){
        if(!ticService.existsById(idTic))
            return new ResponseEntity(new Mensaje("El id no existe enl a tabla EstudioTic!"), HttpStatus.BAD_REQUEST);
        if(ticService.existsByCursoTic(dtoTic.getCursoTic()) && ticService.getByCursoTic(dtoTic.getCursoTic()).get().getIdTic() != idTic)
            return new ResponseEntity(new Mensaje("El curso ya existe!"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoTic.getCursoTic()))
            return new ResponseEntity(new Mensaje("Debe ingresar el nombre del curso tic!"), HttpStatus.BAD_REQUEST);
        
        EstudioTic tic = ticService.getOne(idTic).get();
        tic.setIdPersona(dtoTic.getIdPersona());
        tic.setNombreInstTic(dtoTic.getNombreInstTic());
        tic.setPeriodoTic(dtoTic.getPeriodoTic());
        tic.setCursoTic(dtoTic.getCursoTic());
        tic.setUrlInstTic(dtoTic.getUrlInstTic());
        tic.setUrl_imgTic(dtoTic.getUrl_imgTic());
        
        ticService.save(tic);
        return new ResponseEntity(new Mensaje("Curso actualizado!"), HttpStatus.OK);
    }

    @DeleteMapping("/borrarTic/{idTic}")
    public ResponseEntity<?> delete(@PathVariable("idTic") int idTic){
        if(!ticService.existsById(idTic))
            return new ResponseEntity(new Mensaje("El id no existe en la tabla EstudioTic!"), HttpStatus.BAD_REQUEST);
        ticService.delete(idTic);
        return new ResponseEntity(new Mensaje("Curso eliminado!"), HttpStatus.OK);
    }
}
