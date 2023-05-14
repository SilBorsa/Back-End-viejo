package com.miPortfolio.spb.dto;

import jakarta.validation.constraints.NotNull;

public class dtoEstudioTic {
    @NotNull
    private int idPersona;
    @NotNull
    private String nombreInstTic;
    private String periodoTic;
    private String cursoTic;
    private String urlInstTic;
    private String url_imgTic;

    //constructor vacio
    public dtoEstudioTic() {
    }

    //constructor con parametros
    public dtoEstudioTic(int idPersona, String periodoTic, String cursoTic, String urlInstTic, String url_imgTic) {
        this.idPersona = idPersona;
        this.periodoTic = periodoTic;
        this.cursoTic = cursoTic;
        this.urlInstTic = urlInstTic;
        this.url_imgTic = url_imgTic;
    }

    //getters
    public int getIdPersona() {
        return idPersona;
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
