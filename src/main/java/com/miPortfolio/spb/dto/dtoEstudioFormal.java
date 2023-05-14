package com.miPortfolio.spb.dto;

import jakarta.validation.constraints.NotNull;

public class dtoEstudioFormal {
    @NotNull
    private int idPersona;
    @NotNull
    private String nombreInstituto;
    private String periodoEstudio;
    private String tituloEstudio;
    private String urlInstituto;
    private String url_imgInst;
    
    //constructor vacio
    public dtoEstudioFormal() {
    }
    
    //constructor con parametros
    public dtoEstudioFormal(int idPersona, String nombreInstituto, String periodoEstudio, String tituloEstudio, String urlInstituto, String url_imgInst) {
        this.idPersona = idPersona;
        this.nombreInstituto = nombreInstituto;
        this.periodoEstudio = periodoEstudio;
        this.tituloEstudio = tituloEstudio;
        this.urlInstituto = urlInstituto;
        this.url_imgInst = url_imgInst;
    }
    
    //Getters
    public int getIdPersona() {
        return idPersona;
    }

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public String getPeriodoEstudio() {
        return periodoEstudio;
    }

    public String getTituloEstudio() {
        return tituloEstudio;
    }

    public String getUrlInstituto() {
        return urlInstituto;
    }

    public String getUrl_imgInst() {
        return url_imgInst;
    }
    
    //Setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public void setPeriodoEstudio(String periodoEstudio) {
        this.periodoEstudio = periodoEstudio;
    }

    public void setTituloEstudio(String tituloEstudio) {
        this.tituloEstudio = tituloEstudio;
    }

    public void setUrlInstituto(String urlInstituto) {
        this.urlInstituto = urlInstituto;
    }

    public void setUrl_imgInst(String url_imgInst) {
        this.url_imgInst = url_imgInst;
    }
}
