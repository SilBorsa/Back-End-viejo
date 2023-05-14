package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Blandas {
    @NotNull
    private int idPersona;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idBlanda;
    @NotNull
    private String nombreBlanda;
    @NotNull
    private String colorBlanda;
    @NotNull
    private String url_imgBlanda;

    //constructor vacio
    public Blandas() {
    }

    //constructor con parametros
    public Blandas(int idPersona, String nombreBlanda, String colorBlanda, String url_imgBlanda) {
        this.idPersona = idPersona;
        this.nombreBlanda = nombreBlanda;
        this.colorBlanda = colorBlanda;
        this.url_imgBlanda = url_imgBlanda;
    }

    //Getters
    public int getIdPersona() {
        return idPersona;
    }

    public int getIdBlanda() {
        return idBlanda;
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

    public void setIdBlanda(int idBlanda) {
        this.idBlanda = idBlanda;
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
