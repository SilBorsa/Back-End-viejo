package com.miPortfolio.spb.dto;

import jakarta.validation.constraints.NotNull;

public class dtoLaboral {
    @NotNull
    private int idPersona;
    @NotNull
    private String nombreEmpresa;
    private String periodoEmpresa;
    private String descEmpresa;
    private String urlEmpresa;
    private String url_imgLab;
    
    //constructor vacio
    public dtoLaboral() {
    }
    
    //constructor con parametros
    public dtoLaboral(int idPersona, String nombreEmpresa, String periodoEmpresa, String descEmpresa, String urlEmpresa, String url_imgLab) {
        this.idPersona = idPersona;
        this.nombreEmpresa = nombreEmpresa;
        this.periodoEmpresa = periodoEmpresa;
        this.descEmpresa = descEmpresa;
        this.urlEmpresa = urlEmpresa;
        this.url_imgLab = url_imgLab;
    }
    
    //getters
    public int getIdPersona() {
        return idPersona;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getPeriodoEmpresa() {
        return periodoEmpresa;
    }

    public String getDescEmpresa() {
        return descEmpresa;
    }

    public String getUrlEmpresa() {
        return urlEmpresa;
    }

    public String getUrl_imgLab() {
        return url_imgLab;
    }
        
    
    //setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setPeriodoEmpresa(String periodoEmpresa) {
        this.periodoEmpresa = periodoEmpresa;
    }

    public void setDescEmpresa(String descEmpresa) {
        this.descEmpresa = descEmpresa;
    }

    public void setUrlEmpresa(String urlEmpresa) {
        this.urlEmpresa = urlEmpresa;
    }

    public void setUrl_imgLab(String url_imgLab) {
        this.url_imgLab = url_imgLab;
    }
}