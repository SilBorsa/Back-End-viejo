package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class EstudioFormal {
    @NotNull
    private int idPersona;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEstudio;
    
    @NotNull
    private String nombreInstituto;
    private String periodoEstudio;
    private String tituloEstudio;
    private String urlInstituto;
    private String url_imgInst;

    //constructor vacio
    public EstudioFormal() {
    }
    
    //constructor con parametros
    public EstudioFormal(int idPersona, String nombreInstituto, String periodoEstudio, String tituloEstudio, String urlInstituto, String url_imgInst) {
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

    public int getIdEstudio() {
        return idEstudio;
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

    public void setIdEstudio(int idEstudio) {
        this.idEstudio = idEstudio;
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
