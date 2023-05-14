package com.miPortfolio.spb.dto;

import jakarta.validation.constraints.NotNull;

public class dtoBlanda {
    @NotNull
    private int idPersona;
    @NotNull
    private String nombreBlanda;
    @NotNull
    private String colorBlanda;
    @NotNull
    private String url_imgBlanda;

    //constructor vacio
    public dtoBlanda() {
    }
    
    //constructor con parametros
    public dtoBlanda(int idPersona, String nombreBlanda, String colorBlanda, String url_imgBlanda) {
        this.idPersona = idPersona;
        this.nombreBlanda = nombreBlanda;
        this.colorBlanda = colorBlanda;
        this.url_imgBlanda = url_imgBlanda;
    }

    //Getters
    public int getIdPersona() {
        return idPersona;
    }

    public String getNombreBlanda() {
        return nombreBlanda;
    }

    public String getColorBlanda() {
        return colorBlanda;
    }

    public String getUrl_imgBlanda() {
        return url_imgBlanda;
    }

    //Setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombreBlanda(String nombreBlanda) {
        this.nombreBlanda = nombreBlanda;
    }

    public void setColorBlanda(String colorBlanda) {
        this.colorBlanda = colorBlanda;
    }

    public void setUrl_imgBlanda(String url_imgBlanda) {
        this.url_imgBlanda = url_imgBlanda;
    }
}