package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Proyecto {
    @NotNull
    private int idPersona;
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idPy;
    @NotNull
    private String nombrePy;
    private String periodoPy;
    private String descPy;
    private int fotoPy; //cantidad de fotos 
    
    //constructor vacio
    public Proyecto() {
    }

    //constructor con parametros
    public Proyecto(int idPersona, String nombrePy, String periodoPy, String descPy, int fotoPy) {
        this.idPersona = idPersona;
        this.nombrePy = nombrePy;
        this.periodoPy = periodoPy;
        this.descPy = descPy;
        this.fotoPy = fotoPy;
    }
  
    //getters
    public int getIdPersona() {
        return idPersona;
    }

    public int getIdPy() {
        return idPy;
    }

    public String getNombrePy() {
        return nombrePy;
    }

    public String getPeriodoPy() {
        return periodoPy;
    }

    public String getDescPy() {
        return descPy;
    }

    public int getFotoPy() {
        return fotoPy;
    }

    //setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdPy(int idPy) {
        this.idPy = idPy;
    }

    public void setPeriodoPy(String periodoPy) {
        this.periodoPy = periodoPy;
    }

    public void setNombrePy(String nombrePy) {
        this.nombrePy = nombrePy;
    }

    public void setDescPy(String descPy) {
        this.descPy = descPy;
    }

    public void setFotoPy(int fotoPy) {
        this.fotoPy = fotoPy;
    }
}
