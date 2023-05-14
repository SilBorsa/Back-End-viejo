package com.miPortfolio.spb.dto;

import jakarta.validation.constraints.NotNull;

public class dtoProyecto {
    @NotNull
    private int idPersona;
    @NotNull
    private String nombrePy;
    private String periodoPy;
    private String descPy;
    private int fotoPy; //cantidad de fotos

    //constructor vacio
    public dtoProyecto() {
    }

    //constructor con parametros
    public dtoProyecto(int idPersona, String nombrePy, String periodoPy, String descPy, int fotoPy) {
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

    public String getNombrePy() {
        return nombrePy;
    }

    public int getFotoPy() {
        return fotoPy;
    }

    public String getPeriodoPy() {
        return periodoPy;
    }

    public String getDescPy() {
        return descPy;
    }
    
    //setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombrePy(String nombrePy) {
        this.nombrePy = nombrePy;
    }

    public void setPeriodoPy(String periodoPy) {
        this.periodoPy = periodoPy;
    }

    public void setDescPy(String descPy) {
        this.descPy = descPy;
    }

    public void setFotoPy(int fotoPy) {
        this.fotoPy = fotoPy;
    }
    
}
