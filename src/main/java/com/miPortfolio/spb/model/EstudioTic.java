package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class EstudioTic {
    @NotNull
    private int idPersona;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTic;
    
    @NotNull
    private String nombreInstTic;
    private String periodoTic;
    private String cursoTic;
    private String urlInstTic;
    private String url_imgTic;
    
    //constructor vacio
    public EstudioTic() {
    }

    //constructor con parametros
    public EstudioTic(int idPersona, String nombreInstTic, String periodoTic, String cursoTic, String urlInstTic, String url_imgTic) {
        this.idPersona = idPersona;
        this.nombreInstTic = nombreInstTic;
        this.periodoTic = periodoTic;
        this.cursoTic = cursoTic;
        this.urlInstTic = urlInstTic;
        this.url_imgTic = url_imgTic;
    }

    //Getters
    public int getIdPersona() {
        return idPersona;
    }

    public int getIdTic() {
        return idTic;
    }

    public String getNombreInstTic() {
        return nombreInstTic;
    }

    public String getPeriodoTic() {
        return periodoTic;
    }

    public String getCursoTic() {
        return cursoTic;
    }

    public String getUrlInstTic() {
        return urlInstTic;
    }

    public String getUrl_imgTic() {
        return url_imgTic;
    }

    //setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdTic(int idTic) {
        this.idTic = idTic;
    }

    public void setNombreInstTic(String nombreInstTic) {
        this.nombreInstTic = nombreInstTic;
    }

    public void setPeriodoTic(String periodoTic) {
        this.periodoTic = periodoTic;
    }

    public void setCursoTic(String cursoTic) {
        this.cursoTic = cursoTic;
    }

    public void setUrlInstTic(String urlInstTic) {
        this.urlInstTic = urlInstTic;
    }

    public void setUrl_imgTic(String url_imgTic) {
        this.url_imgTic = url_imgTic;
    }
    
    
}
