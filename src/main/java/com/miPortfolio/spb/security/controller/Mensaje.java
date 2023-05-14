package com.miPortfolio.spb.security.controller;

public class Mensaje {
    private String mensaje;
    
    //contructor vacio
    public Mensaje() {
    }
    
    //constructor
    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //metodos getter y setter
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
