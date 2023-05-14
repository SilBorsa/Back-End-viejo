package com.miPortfolio.spb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idPersona;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    private String url_img;

    //constructor vacio
    public Persona() {
    }
    
    //constructor con parametros
    public Persona(String nombre, String apellido, String url_img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.url_img = url_img;
    }
    
    //getters
    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUrl_img() {
        return url_img;
    }
    
    //setters
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }
}






