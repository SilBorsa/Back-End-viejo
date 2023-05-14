package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Duras {
    @NotNull
    private int idPersona;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDura;
    @NotNull
    private String nombreDura;
    @NotNull
    private int Porcentaje;
    private double num;
    private double giro;
    @NotNull
    private String colorDura;

    //constructor vacio
    public Duras() {
    }
    
    //constructor con parametros
    public Duras(int idPersona, String nombreDura, int Porcentaje, String colorDura) {
        this.idPersona = idPersona;
        this.nombreDura = nombreDura;
        this.Porcentaje = Porcentaje;
        this.num = (440 - 440 * Porcentaje / 100);
        this.giro = (3.6 * Porcentaje);
        this.colorDura = colorDura;
    }

    //Getters
    public int getIdPersona() {
        return idPersona;
    }

    public int getIdDura() {
        return idDura;
    }

    public String getNombreDura() {
        return nombreDura;
    }

    public int getPorcentaje() {
        return Porcentaje;
    }

    public double getNum() {
        return num;
    }

    public double getGiro() {
        return giro;
    }

    public String getColorDura() {
        return colorDura;
    }

    //Setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setIdDura(int idDura) {
        this.idDura = idDura;
    }

    public void setNombreDura(String nombreDura) {
        this.nombreDura = nombreDura;
    }

    public void setPorcentaje(int Porcentaje) {
        this.Porcentaje = Porcentaje;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public void setGiro(double giro) {
        this.giro = giro;
    }

    public void setColorDura(String colorDura) {
        this.colorDura = colorDura;
    }

    
} 