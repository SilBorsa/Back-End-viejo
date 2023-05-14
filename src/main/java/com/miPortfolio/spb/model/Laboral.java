package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Laboral {
    @NotNull
    private int idPersona;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idLaboral;
    
    @NotNull
    private String nombreEmpresa;
    private String periodoEmpresa;
    private String descEmpresa;
    private String urlEmpresa;
    private String url_imgLab;
    
    //constructor vacio
    public Laboral() {
    }
    
    //constructor con parametros
    public Laboral(int idPersona, String nombreEmpresa, String descEmpresa, String periodoEmpresa, String urlEmpresa, String url_imgLab) {
        this.idPersona = idPersona;
        this.nombreEmpresa = nombreEmpresa;
        this.descEmpresa = descEmpresa;
        this.periodoEmpresa = periodoEmpresa;
        this.urlEmpresa = urlEmpresa;
        this.url_imgLab = url_imgLab;
    }
    
    //getters
    public int getIdPersona() {
        return idPersona;
    }

    public int getIdLaboral() {
        return idLaboral;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    
    public String getPeriodoEmpresa(){
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

    public void setIdLaboral(int idLaboral) {
        this.idLaboral = idLaboral;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public void setPeriodoEmpresa(String periodoEmpresa){
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
